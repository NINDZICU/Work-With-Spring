package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.NestedServletException;
import ru.kpfu.dao.JdbcPostDao;
import ru.kpfu.dao.PostDao;
import ru.kpfu.entities.Post;
import ru.kpfu.entities.PostDB;
import ru.kpfu.entities.PostJPA;
import ru.kpfu.repositories.JPAPostRepository;
import ru.kpfu.repositories.PostDatabase;
import ru.kpfu.repositories.queryBuilder.QueryBuilderRepository;
import ru.kpfu.service.PostService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Anatoly on 11.04.2017.
 */
@Controller
@RequestMapping("/post")
//@PropertySource("classpath:/WEB-INF/locales/messages")
public class PostController {

    @Autowired
    private Environment environment;
    @Autowired
    private PostDao postRepo;
    @Autowired
    private JPAPostRepository postRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private QueryBuilderRepository queryBuilderRepository;

    public static final int COUNT_POSTS_ON_PAGE = 2;
    public static int COUNT_POSTS;

    @RequestMapping("/{page}")
    public String showPosts(@PathVariable int page, Map map, Locale locale) throws SQLException {
//        List<PostDB> postsDB = PostDatabase.getAllPost();
        COUNT_POSTS = postRepo.getSizePosts();
        Page<PostJPA> pagePosts = postRepository.findAll(new PageRequest(page - 1, COUNT_POSTS_ON_PAGE));
//        List<PostJPA> postsDB = pagePosts.getContent();

//        List<PostDB> postsDB = postRepo.getPosts((page-1)*COUNT_POSTS_ON_PAGE, COUNT_POSTS_ON_PAGE);

        List<PostJPA> postsDB = queryBuilderRepository.getSortPosts(COUNT_POSTS_ON_PAGE, page-1);
        List<Post> posts = new ArrayList<Post>();
        if (locale.getLanguage().equals("en")) {
            for (PostJPA postDB : postsDB) {
                posts.add(new Post(postDB.getSlug(), postDB.getName_eng(), postDB.getText_eng()));
            }
        }
        if (locale.getLanguage().equals("ru")) {
            for (PostJPA postDB : postsDB) {
                posts.add(new Post(postDB.getSlug(), postDB.getName_ru(), postDB.getText_ru()));
            }
        }
        map.put("posts", posts);
        postService.pagination(page, map);

        return "posts";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost(Map map) {
        map.put("post", new PostDB());
        return "addPost";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPostHandler(
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute("post") PostDB post,
            BindingResult result) {
        if (result.hasErrors()) {
            return "addPost";
        } else {
//                PostDatabase.addPost(post);
            postRepo.addPost(post);

            redirectAttributes.addFlashAttribute("message", environment.getProperty("post.add.success"));
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("PC#addPost").build();
        }
    }

    @RequestMapping(value = "/drop/{slug}")
    public String dropPost(@PathVariable String slug) throws SQLException {
        System.out.println(slug);
//        PostDatabase.removePost(slug);
        postRepo.removePost(slug);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("PC#showPosts").arg(0, "1").build();
    }

    @RequestMapping(value = "/edit/{slug}", method = RequestMethod.GET)
    public String editPost(@PathVariable String slug, Map map) throws SQLException, NestedServletException {
//        PostDB post = PostDatabase.getPost(slug);
        PostDB post = postRepo.getPost(slug);
        map.put("post", post);
        return "addPost";
    }

    @RequestMapping(value = "/edit/{someSlug}", method = RequestMethod.POST)
    public String SaveEditPost(@PathVariable String someSlug,
                               @Validated @ModelAttribute("post") PostDB post,
                               BindingResult result) throws SQLException, NestedServletException {
        if (result.hasErrors()) {

        } else {
//            PostDatabase.setDataPost(someSlug, post);
            postRepo.setDataPost(someSlug, post);
        }
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("PC#showPosts").build();
    }
}
