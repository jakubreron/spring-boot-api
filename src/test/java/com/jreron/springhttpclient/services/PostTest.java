package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostTest {
    @Autowired
    PostService postService;

    @Test
    public void testGetPosts() throws Exception {
        Post[] posts = postService.getPostsById(1);
        Assertions.assertEquals(1, posts.length);
    }

    @Test
    public void testPostId() throws Exception {
        Post[] posts = postService.getPostsById(1);
        Assertions.assertEquals(1, posts[0].id);
    }

    @Test
    public void testPostTitle() throws Exception {
        String title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";

        Post[] posts = postService.getPostsByTitle(title);
        Assertions.assertEquals(title, posts[0].title);
    }
}
