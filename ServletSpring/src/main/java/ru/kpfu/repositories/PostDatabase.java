package ru.kpfu.repositories;

import ru.kpfu.entities.Post;
import ru.kpfu.entities.PostDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anatoly on 11.04.2017.
 */
public class PostDatabase {
    private static Connection conn;
    private static ResultSet rs;

    public static List<PostDB> getAllPost() throws SQLException {
        ArrayList<PostDB> posts = new ArrayList<PostDB>();
        conn = DBWrapper.getConection();
        ResultSet rs = null;
        rs = conn.createStatement().executeQuery(
                "SELECT * FROM posts;"
        );
        while (rs.next()) {
            posts.add(new PostDB(
                    rs.getString("slug"),
                    rs.getString("name_ru"),
                    rs.getString("text_ru"),
                    rs.getString("name_eng"),
                    rs.getString("text_eng")
            ));
        }
        return posts;
    }

    public static void addPost(PostDB post) throws SQLException {
        conn = DBWrapper.getConection();
        PreparedStatement st = conn.prepareStatement(
                " INSERT INTO posts (slug, name_ru, text_ru, name_eng, text_eng)" +
                        "VALUES (?,?,?,?,?);");
        st.setString(1, post.getSlug());
        st.setString(2, post.getName_ru());
        st.setString(3, post.getText_ru());
        st.setString(4, post.getName_eng());
        st.setString(5, post.getText_eng());
        st.execute();
    }

    public static void removePost(String slug) throws SQLException {
        conn = DBWrapper.getConection();
        PreparedStatement st =conn.prepareStatement("DELETE FROM posts WHERE slug=?;");
        st.setString(1, slug);
        st.execute();
    }

    public static PostDB getPost(String slug) throws SQLException {
        PostDB post = null;
        conn = DBWrapper.getConection();
        ResultSet rs = null;
        rs = conn.createStatement().executeQuery(
                "SELECT * FROM posts WHERE slug ='" + slug + "';"
        );
        while (rs.next()) {
            post = new PostDB(
                    rs.getString("slug"),
                    rs.getString("name_ru"),
                    rs.getString("text_ru"),
                    rs.getString("name_eng"),
                    rs.getString("text_eng")
            );
        }
        return post;
    }
    public static void setDataPost(String postSlug, PostDB post) throws SQLException {
        conn = DBWrapper.getConection();
        PreparedStatement st = conn.prepareStatement("UPDATE posts SET slug=?, name_ru=?," +
                " text_ru=?, name_eng=?, text_eng=? WHERE slug=? ;");
        st.setString(1, (post.getSlug()));
        st.setString(2, (post.getName_ru()));
        st.setString(3, (post.getText_ru()));
        st.setString(4, (post.getName_eng()));
        st.setString(5, (post.getText_eng()));
        st.setString(6, (postSlug));
        st.execute();
    }
}
