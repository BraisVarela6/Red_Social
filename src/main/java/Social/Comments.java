package Social;

import java.util.Date;

public class Comments {

    private String comment;
    private Date date;
    private Users user;

    public Comments(String comment, Date date, Users user) {
        this.comment = comment;
        this.date = date;
        this.user = user;
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




}
