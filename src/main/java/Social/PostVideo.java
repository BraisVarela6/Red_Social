package Social;

import java.util.Date;
import java.util.List;

public class PostVideo extends Post{
    private String title;
    private String quality;
    private int duration;

    public PostVideo(List<Comments> comments, Date date, String type, int postNumber, String title, String quality, int duration) {
        super(comments, date, type, postNumber);
        this.title = title;
        this.quality = quality;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
