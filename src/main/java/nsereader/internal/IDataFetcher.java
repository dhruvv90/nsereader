package nsereader.internal;

import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.*;

import java.util.List;

public interface IDataFetcher {

    static IDataFetcher getCurrentInstance() {
        return OkHttpDataFetcher.getInstance();
    }

    List<Stock> getStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    List<Index> getIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    List<GainerLoserStats> getTopGainers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    List<GainerLoserStats> getTopLosers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    List<AdvanceDeclineStats> getAdvancesDeclines() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    StockQuote getStockQuote(String stockSymbol) throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;
}

