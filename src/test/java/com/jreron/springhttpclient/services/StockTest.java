package com.jreron.springhttpclient.services;

import com.jreron.springhttpclient.api.domain.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.not;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StockTest {
    @Autowired
    StockService stockService;

    @Test
    public void testGetStocks() throws Exception {
        Stock[] items = stockService.getStocks("tesla", "US");
        Assertions.assertEquals(7, items.length);
    }

    @Test
    public void testStockIndex() throws Exception {
        Stock[] items = stockService.getStocks("tesla", "US");
        Assertions.assertEquals("quotes", items[0].index);
    }

    @Test
    public void testStockRegion() throws Exception {
        Stock[] AmericanScore = stockService.getStocks("tesla", "US");
        Stock[] GermanScore = stockService.getStocks("tesla", "DE");

        Assertions.assertNotSame(GermanScore[0].score, AmericanScore[0].score);
        Assertions.assertNotSame(AmericanScore[0].score, GermanScore[0].score);
    }
}
