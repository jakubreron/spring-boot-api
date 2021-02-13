package com.jreron.springhttpclient.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class StockService {
    public String API_URL = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete?q=";
    public String API_KEY = "a38dd1a056mshc2973d87df3f49fp17e092jsn1263c3c278ab";

    public HttpEntity request;

    public RestTemplate restTemplate;
    public StockService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Stock[] getStocks(String name, String region) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", API_KEY);

        request = new HttpEntity(headers);

        String initialQuery = API_URL + name;
        String regionQuery = ((region != "") ? "&region=" + region : "");

        ResponseEntity<String> response = restTemplate.exchange(
                initialQuery + regionQuery,
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
