package ru.kpfu.repositories.queryBuilder;

import org.springframework.stereotype.Repository;
import ru.kpfu.entities.PostJPA;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Anatoly on 25.04.2017.
 */
@Repository
public class QueryBuilderRepository {

    @PersistenceContext
    private EntityManager em;

    public List<PostJPA> getAllPosts() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
//        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PostJPA> query = builder.createQuery(PostJPA.class);
        query.from(PostJPA.class);
        List<PostJPA> posts = em.createQuery(query).getResultList();
        for (PostJPA post : posts) {
            System.out.println(post.getSlug());
        }
        return posts;
    }

    public List<PostJPA> getSortPosts(int countOnPage, int firstResult) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PostJPA> query = builder.createQuery(PostJPA.class);
        Root<PostJPA> root = query.from(PostJPA.class);
        query.orderBy(builder.asc(root.get("text_ru")));
        List<PostJPA> posts = em.createQuery(query)
                .setFirstResult(firstResult)
                .setMaxResults(countOnPage)
                .getResultList();

        return posts;
    }
}
