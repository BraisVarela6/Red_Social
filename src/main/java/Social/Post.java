package Social;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private Date date;
    private List<Comments> comments;
    private String type;
    private int postNumber;



    public Post(List<Comments> comments, Date date, String type, int postNumber) {
        this.date = date;
        this.comments = new ArrayList<>();
        this.type = type;
        this.postNumber = postNumber;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }
}
