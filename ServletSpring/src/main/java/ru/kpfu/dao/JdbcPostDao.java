package ru.kpfu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.kpfu.entities.PostDB;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anatoly on 12.04.2017.
 */
@Repository
public class JdbcPostDao implements PostDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("dataSource")
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PostDB> getAllPosts() {
        List<PostDB> posts = jdbcTemplate.query(
                "select * from posts",
                new RowMapper<PostDB>() {
                    public PostDB mapRow(ResultSet rs, int rowNum) throws SQLException {
                        PostDB post1 = new PostDB();
                        post1.setSlug(rs.getString("slug"));
                        post1.setName_ru(rs.getString("name_ru"));
                        post1.setText_ru(rs.getString("text_ru"));
                        post1.setName_eng(rs.getString("name_eng"));
                        post1.setText_eng(rs.getString("text_eng"));
                        return post1;
                    }
                });
        return posts;
    }

    @Override
    public List<PostDB> getPosts(int beginPosition, int endPosition) {
        List<PostDB> posts = jdbcTemplate.query(
                "select * from posts OFFSET ? LIMIT ?",
                new Object[]{beginPosition,endPosition},
                new RowMapper<PostDB>() {
                    public PostDB mapRow(ResultSet rs, int rowNum) throws SQLException {
                        PostDB post1 = new PostDB();
                        post1.setSlug(rs.getString("slug"));
                        post1.setName_ru(rs.getString("name_ru"));
                        post1.setText_ru(rs.getString("text_ru"));
                        post1.setName_eng(rs.getString("name_eng"));
                        post1.setText_eng(rs.getString("text_eng"));
                        return post1;
                    }
                });
        return posts;
    }
    @Override
    public int getSizePosts(){
        int count = jdbcTemplate.queryForObject("SELECT count(*) FROM posts", Integer.class);
        return count;
    }

    public void addPost(PostDB post) {
        jdbcTemplate.update("INSERT INTO posts (slug, name_ru, text_ru, name_eng, text_eng) VALUES (?,?,?,?,?);",
                new Object[]{post.getSlug(), post.getName_ru(), post.getName_ru(), post.getName_eng(), post.getText_eng()}
        );
    }

    public void removePost(String slug) {
        jdbcTemplate.update("DELETE FROM posts WHERE slug=?;",
                new Object[]{slug});
    }

    public PostDB getPost(String slug) {
        PostDB postDB = jdbcTemplate.queryForObject(
                "SELECT * FROM posts WHERE slug =?",
                new Object[]{slug},
                (ResultSet rs, int rowNum) -> { // Lambda or RowMapper implementation
                    PostDB post = new PostDB();
                    post.setSlug(rs.getString("slug"));
                    post.setName_ru(rs.getString("name_ru"));
                    post.setText_ru(rs.getString("text_ru"));
                    post.setName_eng(rs.getString("name_eng"));
                    post.setText_eng(rs.getString("text_eng"));
                    return post;
                }
        );
        return postDB;
    }

    public void setDataPost(String postSlug, PostDB post) {
        jdbcTemplate.update("UPDATE posts SET slug=?, name_ru=?," +
                " text_ru=?, name_eng=?, text_eng=? WHERE slug=? ;", new Object[]{post.getSlug(),
                post.getName_ru(), post.getText_ru(), post.getName_eng(), post.getText_eng(), postSlug});
    }
}
