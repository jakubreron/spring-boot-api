package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.ToDo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ToDoTest {
    @Autowired
    ToDoService toDoService;

    @Test
    public void testGetToDos() throws Exception {
        ToDo[] posts = toDoService.getToDosById(1);
        Assertions.assertEquals(1, posts.length);
    }

    @Test
    public void testToDoId() throws Exception {
        ToDo[] posts = toDoService.getToDosById(1);
        Assertions.assertEquals(1, posts[0].id);
    }

    @Test
    public void testToDoCompleted() throws Exception {
        Boolean completed = true;

        ToDo[] posts = toDoService.getToDosByCompleted(completed);
        Assertions.assertEquals(completed, posts[0].completed);
    }
}
