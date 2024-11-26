package Social;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private String userName;
    private String password;
    private List<Users> followers;
    private List<Post> posts;



    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Users> getFollowers() {
        return followers;
    }

    public void addFollowers(Users users) {
        followers.add(users);
    }

    public void removeFollowers(Users users) {
        followers.remove(users);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPosts(Post post) {
        posts.add(post);
    }
}