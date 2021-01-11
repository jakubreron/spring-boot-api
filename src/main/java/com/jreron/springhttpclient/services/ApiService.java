package com.jreron.springhttpclient.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jreron.springhttpclient.api.domain.Comment;
import com.jreron.springhttpclient.api.domain.Stock;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    public String STOCKS_API_URL = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete?q=";
    public String STOCKS_API_KEY = "a38dd1a056mshc2973d87df3f49fp17e092jsn1263c3c278ab";
    public String PLACEHOLDER_API_URL = "http://jsonplaceholder.typicode.com/comments?postId=";

    public HttpEntity request;
    public RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Comment[] getComments(Integer postId) {
        Comment[] comments = restTemplate.getForObject(PLACEHOLDER_API_URL + postId, Comment[].class);

        return comments;
    }

    public Stock[] getStocks(String name) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", STOCKS_API_KEY);

        request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                STOCKS_API_URL + name,
                HttpMethod.GET,
                request,
                String.class
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response.getBody());

        List<Stock> values = new ArrayList();
        json.get("quotes").forEach(entry -> values.add(mapper.convertValue(entry, Stock.class)));

        return values.toArray(new Stock[0]);
    }
}
