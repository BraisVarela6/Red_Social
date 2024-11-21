package Social;

import java.util.Date;
import java.util.List;

public class PostImage extends Post{
    private String title;
    private int height;
    private int width;

    public PostImage(List<Comments> comments, Date date, String type, int postNumber, String title, int height, int width) {
        super(comments, date, type, postNumber);
        this.title = title;
        this.height = height;
        this.width = width;
    }

    public String getTitle() {
        return title;
    }

    public void setTittle(String title) {
        this.title = title;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
