package Social;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private Date date;
    private List<Comments> comments;

    public Post(List<Comments> comments, Date date) {
        this.date = date;
        this.comments = new ArrayList<>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void addComments(Comments comment) {
        comments.add(comment);
    }
}
