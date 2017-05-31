package ru.kpfu.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.entities.PostJPA;

/**
 * Created by Anatoly on 24.04.2017.
 */
@Repository
public interface JPAPostRepository extends PagingAndSortingRepository<PostJPA, String> {}
