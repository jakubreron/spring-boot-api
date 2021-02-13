package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {

    public String API_URL = "https://jsonplaceholder.typicode.com/posts?";

    public RestTemplate restTemplate;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Post[] getPostsByTitle(String title) {
        Post[] posts = restTemplate.getForObject(API_URL + "title=" + title, Post[].class);

        return posts;
    }

    public Post[] getPostsById(Integer id) {
        Post[] posts = restTemplate.getForObject(API_URL + "id=" + id, Post[].class);

        return posts;
    }
}
