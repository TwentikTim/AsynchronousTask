public class VideoLecture extends ContentItem implements Downloadable {

    private String quality;

    public VideoLecture(String title, int year, int durationMinutes, String quality) {
        super(title, year, durationMinutes);
        setQuality(quality);
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        if (quality == null || quality.isBlank()) {
            throw new IllegalArgumentException("Quality must not be null or blank");
        }
        this.quality = quality;
    }

    @Override
    public double getLicenseCost(int currentYear) {
        int ageFactor = (getAge(currentYear) <= 2) ? 5 : 2;
        return 0.05 * durationMinutes + ageFactor;
    }

    @Override
    public void download() {
        System.out.println("Downloading video in " + quality + "...");
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 3;
    }

    @Override
    public String toString() {
        return "VideoLecture{" + super.toString() +
                ", quality='" + quality + '\'' +
                '}';
    }
}
