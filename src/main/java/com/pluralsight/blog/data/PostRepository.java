package com.pluralsight.blog.data;

import com.pluralsight.blog.model.Author;
import com.pluralsight.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public interface PostRepository  extends JpaRepository<Post, Long>{

    //test
    @RestResource(rel="contains-title", path="containsTitle")
    public List<Post> findByTitleContaining(String title);

}