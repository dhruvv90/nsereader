package nsereader;

import nsereader.internal.datafetcher.IDataFetcher;
import nsereader.internal.parser.ICsvParser;
import nsereader.model.AdvanceDeclineStats;
import nsereader.model.GainerLoserStats;
import nsereader.model.Index;
import nsereader.model.Stock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

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

    @Test
    void getIndexQuote() throws Exception {
        Index quote = nseReader.getIndexQuote("nifty 50");
        assertNotNull(quote);

        assertThrows(NoSuchElementException.class, () -> nseReader.getIndexQuote("nifty 501"));
    }
}