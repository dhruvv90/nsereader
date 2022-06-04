package nsereader;

import nsereader.datafetcher.IDataFetcher;
import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.Index;
import nsereader.model.Stock;

import java.util.List;

class NseReaderImpl extends NseReader {

    private final IDataFetcher dataFetcher;
    private List<Stock> stockList;
    private List<Index> indexList;

    NseReaderImpl(NseReaderBuilderImpl builder) {
        this.dataFetcher = IDataFetcher.getCurrentInstance();
    }

    @Override
    public List<Stock> getStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        if(this.stockList != null){
            return this.stockList;
        }
        List<Stock> stockList = this.dataFetcher.getStocks();
        this.stockList = stockList;
        return stockList;
    }

    @Override
    public List<Index> getIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        if(this.indexList != null){
            return this.indexList;
        }
        List<Index> indexList = this.dataFetcher.getIndices();
        this.indexList = indexList;
        return indexList;
    }
}
