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

    NseReaderImpl(NseReaderBuilderImpl builder) {
        this.dataFetcher = IDataFetcher.getCurrentInstance();
    }

    @Override
    public List<Stock> getStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        List<Stock> stockList = this.dataFetcher.getStocks();
        return stockList;
    }

    @Override
    public List<Index> getIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        List<Index> indexList = this.dataFetcher.getIndices();
        return indexList;
    }
}
