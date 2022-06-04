package nsereader.datafetcher;

import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.Index;
import nsereader.model.Stock;

import java.util.List;

public interface IDataFetcher {

    static IDataFetcher getCurrentInstance() {
        return OkHttpDataFetcher.getInstance();
    }

    List<Stock> getStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    List<Index> getIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;
}

