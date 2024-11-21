package Social;

import java.util.Date;
import java.util.List;

public class PostText extends Post{
    private String content;

    public PostText(List<Comments> comments, Date date, String type, int postNumber, String content) {
        super(comments, date, type, postNumber);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
