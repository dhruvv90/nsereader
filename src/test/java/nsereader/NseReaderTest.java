package nsereader;

import nsereader.datafetcher.IDataFetcher;
import nsereader.model.Stock;
import nsereader.parser.ICsvParser;
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
    void getAllStocks() {
        try {
            List<Stock> stockList = nseReader.getStocks();
            assertTrue(stockList.size() > 0);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void ICsvParser_Build() {
        var first = ICsvParser.getCurrentInstance();
        var second = ICsvParser.getCurrentInstance();

        assertEquals(first, second);
        assertSame(first, second);
    }

    @Test
    void IDataFetcher_Build() {
        var first = IDataFetcher.getCurrentInstance();
        var second = IDataFetcher.getCurrentInstance();

        assertEquals(first, second);
        assertSame(first, second);
    }
}