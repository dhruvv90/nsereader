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

import java.util.List;
import java.util.NoSuchElementException;

class NseReaderImpl extends NseReader {

    private final IDataFetcher dataFetcher;
    private List<Stock> stocks;
    private List<Index> indices;

    NseReaderImpl(NseReaderBuilderImpl builder) {
        this.dataFetcher = IDataFetcher.getCurrentInstance();
    }

    @Override
    public List<Stock> getStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        if (this.stocks != null) {
            return this.stocks;
        }
        List<Stock> stockList = this.dataFetcher.getStocks();
        this.stocks = stockList;
        return stockList;
    }

    @Override
    public List<Index> getIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        if (this.indices != null) {
            return this.indices;
        }
        List<Index> indexList = this.dataFetcher.getIndices();
        this.indices = indexList;
        return indexList;
    }

    @Override
    public boolean isValidStock(String stockSymbol) {
        try {
            List<Stock> stocks = this.getStocks();
            for (Stock s : stocks) {
                if (s.getSymbol().equals(stockSymbol.toUpperCase())) {
                    return true;
                }
            }
            return false;
        } catch (NseDataParsingException | NseResponseFailureException | NseTimeoutException e) {
            return false;
        }
    }

    @Override
    public boolean isValidIndex(String indexName) {
        try {
            List<Index> indices = this.getIndices();
            for (Index i : indices) {
                if (i.getName().equals(indexName.toUpperCase())) {
                    return true;
                }
            }
            return false;
        } catch (NseDataParsingException | NseResponseFailureException | NseTimeoutException e) {
            return false;
        }
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
        List<Index> indexList = this.getIndices();
        for(Index i: indexList){
            if(i.getName().equals(indexName.toUpperCase())){
                return i;
            }
        }
        throw new NoSuchElementException("invalid indexName or fetch/parse error from NSE");
    }
}
