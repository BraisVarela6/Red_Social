package Social;

import java.util.Date;

public class Comments {

    private String comment;
    private Date date;
    private Users user;
    private int commentNumber;

    public Comments(String comment, Date date, Users user, int commentNumber) {
        this.comment = comment;
        this.date = date;
        this.user = user;
        this.commentNumber = commentNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
