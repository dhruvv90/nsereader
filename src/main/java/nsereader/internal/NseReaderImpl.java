package nsereader.internal;

import nsereader.NseReader;
import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.internal.datafetcher.IDataFetcher;
import nsereader.model.AdvanceDeclineStats;
import nsereader.model.GainerLoserStats;
import nsereader.model.Index;
import nsereader.model.Stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

class NseReaderImpl extends NseReader {

    private final IDataFetcher dataFetcher;
    private final Map<String, Stock> stocksMap;
    private final Map<String, Index> indexMap;


    NseReaderImpl(NseReaderBuilderImpl builder) {
        this.dataFetcher = IDataFetcher.getCurrentInstance();
        this.stocksMap = new HashMap<>();
        this.indexMap = new HashMap<>();
    }

    private List<Stock> ingestStocksData() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        List<Stock> stockList = this.dataFetcher.getStocks();
        this.stocksMap.clear();
        for (Stock s : stockList) {
            this.stocksMap.put(s.getSymbol(), s);
        }
        return stockList;
    }

    @Override
    public List<Stock> getStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        List<Stock> stockList = this.ingestStocksData();
        return stockList;
    }

    @Override
    public boolean isValidStock(String stockSymbol) throws NseTimeoutException, NseDataParsingException, NseResponseFailureException {
        if (this.stocksMap.isEmpty()) {
            this.ingestStocksData();
        }
        return this.stocksMap.containsKey(stockSymbol.toUpperCase());
    }

    private List<Index> ingestIndicesData() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        List<Index> indexList = this.dataFetcher.getIndices();
        this.indexMap.clear();
        for (Index i : indexList) {
            this.indexMap.put(i.getName(), i);
        }
        return indexList;
    }

    @Override
    public List<Index> getIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        List<Index> indexList = this.ingestIndicesData();
        return indexList;
    }

    @Override
    public boolean isValidIndex(String indexName) throws NseTimeoutException, NseDataParsingException, NseResponseFailureException {
        if (this.indexMap.isEmpty()) {
            this.ingestIndicesData();
        }
        return this.indexMap.containsKey(indexName.toUpperCase());
    }

    @Override
    public List<GainerLoserStats> getTopGainers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        List<GainerLoserStats> stats = this.dataFetcher.getTopGainers();
        return stats;
    }

    @Override
    public List<GainerLoserStats> getTopLosers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        List<GainerLoserStats> stats = this.dataFetcher.getTopLosers();
        return stats;
    }

    @Override
    public List<AdvanceDeclineStats> getAdvancesDeclines() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        List<AdvanceDeclineStats> stats = this.dataFetcher.getAdvancesDeclines();
        return stats;
    }

    @Override
    public Index getIndexQuote(String indexName) throws NoSuchElementException, NseTimeoutException, NseResponseFailureException, NseDataParsingException {
        if (this.indexMap.isEmpty()) {
            this.ingestIndicesData();
        }
        Index idx = this.indexMap.get(indexName.toUpperCase());
        if (idx == null) {
            throw new NoSuchElementException("Invalid indexName: Not found");
        }
        return idx;
    }
}
