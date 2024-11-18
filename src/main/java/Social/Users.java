package Social;

import java.util.List;

public class Users {

        private String userName;
        private List following;
        private List posts;


    public Users(String userName, List following, List posts) {
        this.userName = userName;
        this.following = following;
        this.posts = posts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List getFollowing() {
        return following;
    }

    public void setFollowing(List following) {
        this.following = following;
    }

    public List getPosts() {
        return posts;
    }

    public void setPosts(List posts) {
        this.posts = posts;
    }
}
