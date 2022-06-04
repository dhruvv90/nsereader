package nsereader;

import nsereader.datafetcher.IDataFetcher;
import nsereader.model.Index;
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
    void getAllStocks() throws Exception {
        List<Stock> stockList = nseReader.getStocks();
        assertTrue(stockList.size() > 0);
    }

    @Test
    void getAllIndices() throws Exception {
        List<Index> indexList = nseReader.getIndices();
        assertTrue(indexList.size() > 0);
    }

    @Test
    void ICsvParser_Build() {
        ICsvParser first = ICsvParser.getCurrentInstance();
        ICsvParser second = ICsvParser.getCurrentInstance();
        assertEquals(first, second);
        assertSame(first, second);
    }

    @Test
    void IDataFetcher_Build() {
        IDataFetcher first = IDataFetcher.getCurrentInstance();
        IDataFetcher second = IDataFetcher.getCurrentInstance();
        assertEquals(first, second);
        assertSame(first, second);
    }
}