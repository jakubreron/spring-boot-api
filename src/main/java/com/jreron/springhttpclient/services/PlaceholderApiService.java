package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.Comment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlaceholderApiService {

    public String PLACEHOLDER_API_URL = "http://jsonplaceholder.typicode.com/comments?postId=";

    public RestTemplate restTemplate;
    public PlaceholderApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Comment[] getComments(Integer postId) {
        Comment[] comments = restTemplate.getForObject(PLACEHOLDER_API_URL + postId, Comment[].class);

        return comments;
    }
}
