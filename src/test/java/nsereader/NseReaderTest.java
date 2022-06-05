package nsereader;

import nsereader.datafetcher.IDataFetcher;
import nsereader.model.AdvanceDeclineStats;
import nsereader.model.GainerLoserStats;
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
    void getAllStocks_Caching() throws Exception {
        List<Stock> l1 = nseReader.getStocks();
        List<Stock> l2 = nseReader.getStocks();
        assertSame(l1, l2);
    }

    @Test
    void isValidStockCode()  {
        boolean check = nseReader.isValidStockCode("hdfc");
        boolean check1 = nseReader.isValidStockCode("abcd");
        boolean check2 = nseReader.isValidStockCode("hdFC");

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
    void getAllIndices_Caching() throws Exception {
        List<Index> l1 = nseReader.getIndices();
        List<Index> l2 = nseReader.getIndices();
        assertSame(l1, l2);
    }

    @Test
    void isValidIndexCode()  {
        boolean check = nseReader.isValidIndexCode("abcd");
        boolean check1 = nseReader.isValidIndexCode("NIFTY 50 Pre Open");
        boolean check2 = nseReader.isValidIndexCode("NiFtY 50 pre Open");

        assertTrue(check1);
        assertTrue(check2);
        assertFalse(check);
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
        System.out.println(list);
        assertFalse(list.isEmpty());
    }
}