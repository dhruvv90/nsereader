package nsereader;

import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.Index;
import nsereader.model.Stock;

import java.util.List;

public abstract class NseReader {
    public static NseReader createDefault() {
        return getBuilder().build();
    }

    public static Builder getBuilder() {
        return new NseReaderBuilderImpl();
    }

    public abstract List<Stock> getStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    public abstract List<Index> getIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    public interface Builder {
        NseReader build();
    }
}


