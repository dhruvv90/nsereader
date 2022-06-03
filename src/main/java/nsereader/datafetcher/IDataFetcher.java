package nsereader.datafetcher;


import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.Stock;

import java.util.List;

public interface IDataFetcher {

    List<Stock> getStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;
}

