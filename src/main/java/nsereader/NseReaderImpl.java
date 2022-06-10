package nsereader;

import nsereader.exception.NseConnectionException;
import nsereader.exception.NseDataException;
import nsereader.exception.NseResponseFailureException;
import nsereader.http.CloseableHttpResponse;
import nsereader.http.HttpStreamer;
import nsereader.model.*;
import nsereader.parser.Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class UrlStore {
    static final String ROOT_URL = "http://www1.nseindia.com";
    static final String ALL_STOCKS = ROOT_URL + "/content/equities/EQUITY_L.csv";
    static final String ALL_INDICES = ROOT_URL + "/homepage/Indices1.json";
    static final String TOP_GAINER_STOCKS = ROOT_URL + "/live_market/dynaContent/live_analysis/gainers/niftyGainers1.json";
    static final String TOP_LOSER_STOCKS = ROOT_URL + "/live_market/dynaContent/live_analysis/losers/niftyLosers1.json";
    static final String ADVANCES_DECLINES = ROOT_URL + "/common/json/indicesAdvanceDeclines.json";
    static final String STOCK_QUOTE = ROOT_URL + "/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?";

    static String getQuoteUrlForStock(String stockSymbol) {
        return STOCK_QUOTE + "symbol=" + stockSymbol.toUpperCase() + "&illiquid=0&smeFlag=0&itpFlag=0";
    }
}

class NseReaderImpl extends NseReader {

    private final Map<String, Stock> stockSymbolMap;
    private final Map<String, Index> indexNameMap;
    private final HttpStreamer httpStreamer;
    private final Parser parser;

    NseReaderImpl(NseReaderBuilder builder) {
        this.stockSymbolMap = new HashMap<>();
        this.indexNameMap = new HashMap<>();
        this.httpStreamer = new HttpStreamer.HttpStreamerBuilder()
                .setTimeout(builder.timeout)
                .setUserAgent(builder.userAgent)
                .build();
        this.parser = new Parser();
    }

    @Override
    public StockQuote getStockQuote(String stockSymbol) throws NseDataException, NseResponseFailureException, NseConnectionException {
        String url = UrlStore.getQuoteUrlForStock(stockSymbol);
        StockQuote quote;
        try (CloseableHttpResponse response = this.httpStreamer.get(url)) {
            quote = this.parser.parseStockQuote(response.getStream());
        }
        return quote;
    }

    @Override
    public List<Stock> getStocks() throws NseDataException, NseResponseFailureException, NseConnectionException {
        String url = UrlStore.ALL_STOCKS;
        this.stockSymbolMap.clear();
        List<Stock> stockList;
        try (CloseableHttpResponse response = this.httpStreamer.get(url)) {
            stockList = this.parser.parseAllStocks(response.getStream());
        }
        for (Stock s : stockList) {
            this.stockSymbolMap.put(s.getSymbol(), s);
        }
        return stockList;
    }

    @Override
    public boolean isValidStock(String stockSymbol) throws NseConnectionException, NseDataException, NseResponseFailureException {
        if (this.stockSymbolMap.isEmpty()) {
            this.getStocks();
        }
        return this.stockSymbolMap.containsKey(stockSymbol.toUpperCase());
    }

    @Override
    public List<Index> getIndices() throws NseDataException, NseResponseFailureException, NseConnectionException {
        String url = UrlStore.ALL_INDICES;
        this.indexNameMap.clear();
        List<Index> indexList;
        try (CloseableHttpResponse response = this.httpStreamer.get(url)) {
            indexList = this.parser.parseAllIndices(response.getStream());
        }
        for (Index i : indexList) {
            this.indexNameMap.put(i.getName(), i);
        }
        return indexList;
    }

    @Override
    public boolean isValidIndex(String indexName) throws NseConnectionException, NseDataException, NseResponseFailureException {
        if (this.indexNameMap.isEmpty()) {
            this.getIndices();
        }
        return this.indexNameMap.containsKey(indexName.toUpperCase());
    }

    @Override
    public List<GainerLoserStats> getTopGainers() throws NseDataException, NseResponseFailureException, NseConnectionException {
        String url = UrlStore.TOP_GAINER_STOCKS;
        List<GainerLoserStats> stats;
        try (CloseableHttpResponse response = this.httpStreamer.get(url)) {
            stats = this.parser.parseTopGainers(response.getStream());
        }
        return stats;
    }

    @Override
    public List<GainerLoserStats> getTopLosers() throws NseDataException, NseResponseFailureException, NseConnectionException {
        String url = UrlStore.TOP_LOSER_STOCKS;
        List<GainerLoserStats> stats;
        try (CloseableHttpResponse response = this.httpStreamer.get(url)) {
            stats = this.parser.parseTopLosers(response.getStream());
        }
        return stats;
    }

    @Override
    public List<AdvanceDeclineStats> getAdvancesDeclines() throws NseDataException, NseResponseFailureException, NseConnectionException {
        String url = UrlStore.ADVANCES_DECLINES;
        List<AdvanceDeclineStats> stats;
        try (CloseableHttpResponse response = this.httpStreamer.get(url)) {
            stats = this.parser.parseAdvancesDeclines(response.getStream());
        }
        return stats;
    }

    @Override
    public Index getIndexQuote(String indexName) throws NseConnectionException, NseResponseFailureException, NseDataException {
        if(isValidIndex(indexName)){
            return this.indexNameMap.get(indexName.toUpperCase());
        }
        else{
            throw new NseDataException("Invalid indexName");
        }
    }
}
