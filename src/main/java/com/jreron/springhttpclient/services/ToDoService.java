package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.ToDo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ToDoService {

    public String API_URL = "https://jsonplaceholder.typicode.com/todos?";

    public RestTemplate restTemplate;

    public ToDoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ToDo[] getToDosByCompleted(Boolean completed) {
        ToDo[] todos = restTemplate.getForObject(API_URL + "completed=" + completed.toString(), ToDo[].class);

        return todos;
    }

    public ToDo[] getToDosById(Integer id) {
        ToDo[] todos = restTemplate.getForObject(API_URL + "id=" + id , ToDo[].class);

        return todos;
    }
}
