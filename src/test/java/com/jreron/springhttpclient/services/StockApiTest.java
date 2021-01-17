package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StockApiTest {
    @Autowired
    StockApiService stockApiService;

    @Test
    public void testGetStocks() throws Exception {
        Stock[] items = stockApiService.getStocks("tesla");
        Assertions.assertEquals(7, items.length);
    }

    @Test
    public void testStockIndex() throws Exception {
        Stock[] items = stockApiService.getStocks("tesla");
        Assertions.assertEquals("quotes", items[0].index);
    }
}
