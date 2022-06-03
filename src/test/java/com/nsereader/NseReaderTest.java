package com.nsereader;

import nsereader.NseReader;
import nsereader.model.Stock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class NseReaderTest {

    private static NseReader nseReader;

    @BeforeAll
    static void setUp() {
        nseReader = NseReader.createDefault();
    }


    @Test
    void getAllStocks() {
        try {
            List<Stock> stockList = nseReader.getStocks();
            assertTrue(stockList.size() > 0);
            System.out.println(stockList);
        } catch (Exception e) {
            fail(e);
        }
    }

}