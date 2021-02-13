package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CommentTest {
    @Autowired
    CommentService commentService;

    @Test
    public void testGetComments() throws Exception {
        Comment[] comments = commentService.getCommentByPostId(1);
        Assertions.assertEquals(5, comments.length);
    }

    @Test
    public void testCommentId() throws Exception {
        Comment[] comments = commentService.getCommentByPostId(1);
        Assertions.assertEquals(1, comments[0].postId);
    }

    @Test
    public void testCommentEmail() throws Exception {
        String email = "Lew@alysha.tv";

        Comment[] comments = commentService.getCommentByEmail("Lew@alysha.tv");
        Assertions.assertEquals(email, comments[0].email);
    }
}
