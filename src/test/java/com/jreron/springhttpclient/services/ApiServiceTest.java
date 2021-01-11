package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.Comment;
import com.jreron.springhttpclient.api.domain.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApiServiceTest {
    @Autowired
    ApiService apiService;

    @Test
    public void testGetComments() throws Exception {
        Comment[] comments = apiService.getComments(1);
        Assertions.assertEquals(5, comments.length);
    }

    @Test
    public void testGetStocks() throws Exception {
        Stock[] items = apiService.getStocks("tesla");
        Assertions.assertEquals(7, items.length);
    }
}
