package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;


@Service
public class PostService {

    public ArrayList<Post> getAllPosts() throws SQLException {
        ArrayList<Post> posts = new ArrayList<>();

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/technicalblog", "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts");
            while (rs.next()) {
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                post.setDate(post.getDate());
                posts.add(post);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }  finally {
            connection.close();
        }

        return posts;
    }

    public ArrayList<Post> getOnePost() throws SQLException {
        ArrayList<Post> posts = new ArrayList<>();

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/technicalblog", "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts WHERE id =4");
            while (rs.next()) {
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return posts;
    }

    public void createPost(Post newPost) {
    }
}
