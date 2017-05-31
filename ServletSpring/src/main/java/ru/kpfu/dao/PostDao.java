package ru.kpfu.dao;

import org.springframework.stereotype.Repository;
import ru.kpfu.entities.PostDB;

import java.util.List;

/**
 * Created by Anatoly on 12.04.2017.
 */
@Repository
public interface PostDao {
    public List<PostDB> getAllPosts();
    public List<PostDB> getPosts(int beginPosition, int endPosition);
    public int getSizePosts();
    public void addPost(PostDB post);
    public void removePost(String slug);
    public PostDB getPost(String slug);
    public void setDataPost(String postSlug, PostDB post);
}
