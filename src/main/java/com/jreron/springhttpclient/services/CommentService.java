package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.Comment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommentService {

    public String API_URL = "http://jsonplaceholder.typicode.com/comments?";

    public RestTemplate restTemplate;

    public CommentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Comment[] getCommentByEmail(String email) {
        Comment[] comments = restTemplate.getForObject(API_URL + "email=" + email, Comment[].class);

        return comments;
    }

    public Comment[] getCommentByPostId(Integer postId) {
        Comment[] comments = restTemplate.getForObject(API_URL + "postId=" + postId, Comment[].class);

        return comments;
    }
}
