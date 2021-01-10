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
public class ApiServiceImplTest {
    @Autowired
    ApiService apiService;

    @Test
    public void testGetComments() throws Exception {
        Comment[] comments = apiService.getComments();

        System.out.println("=========================================================================================================");
        System.out.println(comments);
        System.out.println("=========================================================================================================");

//        Assertions.assertNotNull(comments);
    }

//    @Test
//    public void testGetStocks() throws Exception {
//        String item = apiService.getStock();
//        Assertions.assertNotNull(item);
//    }
}
