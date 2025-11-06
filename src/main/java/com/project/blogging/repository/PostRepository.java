package com.project.blogging.repository;

import com.project.blogging.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("""
            SELECT DISTINCT p from Post p
            LEFT JOIN p.tags t
            WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :search, '%'))
                OR LOWER(p.content) LIKE LOWER(CONCAT('%', :search, '%'))
                OR LOWER(p.category) LIKE LOWER(CONCAT('%', :search, '%'))
                OR LOWER(t) LIKE LOWER(CONCAT('%', :search, '%'))
            """)
    List<Post> searchPosts(@Param("search") String search);
}
