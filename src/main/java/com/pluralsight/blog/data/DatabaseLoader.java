package com.pluralsight.blog.data;

import com.pluralsight.blog.model.Author;
import com.pluralsight.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final String[] templates = {
            "Smart Home %s", "Mobile %s - For When You're On he Go", "The %s - Your New Favorite Accessory"};
    private final String[] gadgets = {
            "Earbuds", "Speakers", "Tripod", "Instant Pot", "Coffee Cup", "Keyboard", "Sunglasses"};
    public List<Post> randomPosts = new ArrayList<>();
    public List<Author> authors = new ArrayList<>();

    private final PostRepository postRepository;

    @Autowired
    public DatabaseLoader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.range(0,40).forEach(i->{
            String template = templates[i % templates.length];
            String gadget = gadgets[i % gadgets.length];

            String title = String.format(template, gadget);
            Post post = new Post(title, "Lorem ipsum dolor sit amet, consectetur adipiscing elit… ");
            randomPosts.add(post);
        });

        postRepository.saveAll(randomPosts);
    }
}
