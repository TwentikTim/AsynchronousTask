public class VideoLecture extends ContentItem {

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
        int age = getAge(currentYear);
        int ageFactor = (age <= 2) ? 5 : 2;
        return 0.05 * durationMinutes + ageFactor;
    }

    @Override
    public String toString() {
        return "VideoLecture{" + super.toString() +
                ", quality='" + quality + '\'' +
                '}';

    }
}
