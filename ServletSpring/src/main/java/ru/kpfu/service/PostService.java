package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.controllers.PostController;
import ru.kpfu.dao.PostDao;
import ru.kpfu.repositories.JPAPostRepository;

import java.util.Map;

/**
 * Created by Anatoly on 24.04.2017.
 */
@Service
public class PostService {

//    @Autowired
//    private PostDao postRepo;
//    @Autowired
//    private JPAPostRepository postRepository;

    public void pagination(int page, Map map){
        int lastNumber =(int)Math.ceil((double) PostController.COUNT_POSTS/PostController.COUNT_POSTS_ON_PAGE);
        if(lastNumber==1||lastNumber==0){
            map.put("firstnumber", 1);
        }
        else if(lastNumber==2){
            map.put("firstnumber", 1);
            map.put("secondnumber", 2);

        }
        else if(page == lastNumber){
            map.put("firstnumber", 1);
            map.put("secondnumber", page-1);
            map.put("lastnumber", page);
        }
        else if(page==lastNumber-1){
            map.put("firstnumber", 1);
            map.put("secondnumber", page);
            map.put("lastnumber", lastNumber);
        }
        else{
            map.put("firstnumber", page);
            map.put("secondnumber", page+1);
            map.put("lastnumber", lastNumber);
        }
        map.put("page", page);
    }

}
