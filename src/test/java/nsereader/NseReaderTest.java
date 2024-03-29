package nsereader;

import nsereader.exception.NseDataException;
import nsereader.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NseReaderTest {

    private static NseReader nseReader;

    @BeforeAll
    static void setUp() {
        nseReader = NseReader.createDefault();
    }

    @Test
    void getAllStocks() throws Exception {
        List<Stock> stockList = nseReader.getStocks();
        assertTrue(stockList.size() > 0);
    }


    @Test
    void isValidStock() throws Exception {
        boolean check = nseReader.isValidStock("hdfc");
        boolean check1 = nseReader.isValidStock("abcd");
        boolean check2 = nseReader.isValidStock("hdFC");

        assertTrue(check);
        assertTrue(check2);
        assertFalse(check1);
    }

    @Test
    void getAllIndices() throws Exception {
        List<Index> indexList = nseReader.getIndices();
        assertTrue(indexList.size() > 0);
    }

    @Test
    void isValidIndex() throws Exception {
        boolean check = nseReader.isValidIndex("abcd");
        boolean check1 = nseReader.isValidIndex("NIFTY 50 Pre Open");
        boolean check2 = nseReader.isValidIndex("NiFtY 50 pre Open");

        assertTrue(check1);
        assertTrue(check2);
        assertFalse(check);
    }

    @Test
    void getTopGainers() throws Exception {
        List<GainerLoserStats> list = nseReader.getTopGainers();
        assertFalse(list.isEmpty());
    }

    @Test
    void getTopLosers() throws Exception {
        List<GainerLoserStats> list = nseReader.getTopLosers();
        assertFalse(list.isEmpty());
    }

    @Test
    void getAdvancesDeclines() throws Exception {
        List<AdvanceDeclineStats> list = nseReader.getAdvancesDeclines();
        assertFalse(list.isEmpty());
    }

    @Test
    void getIndexQuote() throws Exception {
        Index quote = nseReader.getIndexQuote("nifty 50");
        assertNotNull(quote);
        assertThrows(NseDataException.class, () -> nseReader.getIndexQuote("nifty 501"));
    }

    @Test
    void getStockQuote() throws Exception {
        StockQuote quote = nseReader.getStockQuote("hdfc");
        assertNotNull(quote);
        assertThrows(NseDataException.class, () -> nseReader.getStockQuote("abcd"));
    }
}