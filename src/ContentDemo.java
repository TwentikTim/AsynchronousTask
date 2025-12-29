import java.time.Year;
import java.util.ArrayList;

public class ContentDemo {

    public static void main(String[] args) {

        ArrayList<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("OOP in Java", 2024, 90, "HD"));
        items.add(new VideoLecture("Data Structures", 2022, 120, "4K"));

        items.add(new PodcastEpisode("Tech Talk", 2023, 45, "Alice Johnson"));
        items.add(new PodcastEpisode("AI Weekly", 2021, 60, "Bob Smith"));

        int currentYear = Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(item +
                    " | licenseCost=" +
                    item.getLicenseCost(currentYear));

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println("Max downloads/day: " + d.getMaxDownloadsPerDay());
            }

            System.out.println("------------------------------------------------");
        }
    }
}
