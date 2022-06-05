package nsereader;

import nsereader.datafetcher.IDataFetcher;
import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.AdvanceDeclineStats;
import nsereader.model.GainerLoserStats;
import nsereader.model.Index;
import nsereader.model.Stock;

import java.util.List;

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
    public boolean isValidStockCode(String code) {
        try {
            List<Stock> stocks = this.getStocks();
            for (Stock s : stocks) {
                if (s.getSymbol().equals(code.toUpperCase())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isValidIndexCode(String code) {
        try {
            List<Index> indices = this.getIndices();
            for (Index i : indices) {
                if (i.getName().equals(code.toUpperCase())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
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
}
