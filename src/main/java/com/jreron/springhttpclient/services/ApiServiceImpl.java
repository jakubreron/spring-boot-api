package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.Comment;
import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {
//    public String STOCKS_API_URL = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete?q=tesla&region=US";
//    public String STOCKS_API_KEY = "a38dd1a056mshc2973d87df3f49fp17e092jsn1263c3c278ab";
    public String PLACEHOLDER_API_URL = "http://jsonplaceholder.typicode.com/comments?postId=1";

//    public HttpEntity request;

    public RestTemplate restTemplate;
    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Comment[] getComments() {
        Comment[] comments = restTemplate.getForObject(PLACEHOLDER_API_URL, Comment[].class);

        return comments;
    }

//    @Override
//    public String getStock() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-rapidapi-key", STOCKS_API_KEY);
//
//        request = new HttpEntity(headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                STOCKS_API_URL,
//                HttpMethod.GET,
//                request,
//                String.class
//        );
//
//        return response.getBody();
//    }
}
