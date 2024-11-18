package Social;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private String userName;
    private List<Users> followers;
    private List<Post> posts;


    public Users(String userName) {
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Users> getFollowers() {
        return followers;
    }

    public void addFollowers(Users users) {
        followers.add(users);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPosts(Post post) {
        posts.add(post);
    }
}