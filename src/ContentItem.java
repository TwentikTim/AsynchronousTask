import java.time.Year;

public abstract class ContentItem {

    protected int id;
    protected static int idGen = 1;

    protected String title;
    protected int year;
    protected int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes) {
        this.id = idGen++;
        setTitle(title);
        setYear(year);
        setDurationMinutes(durationMinutes);
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    // Setters with validation
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be null or blank");
        }
        this.title = title;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1990 || year > currentYear) {
            throw new IllegalArgumentException("Year must be between 1990 and current year");
        }
        this.year = year;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        this.durationMinutes = durationMinutes;
    }


    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double getLicenseCost(int currentYear);

    @Override
    public String toString() {
        return "ID=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + durationMinutes + "min";
    }
}
