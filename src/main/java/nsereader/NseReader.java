package nsereader;

import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class NseReader {
    public static NseReader createDefault() {
        return getBuilder().build();
    }

    public static NseReaderBuilder getBuilder() {
        return new NseReaderBuilder();
    }

    public abstract StockQuote getStockQuote(String stockSymbol) throws NoSuchElementException, NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    public abstract List<Stock> getStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    public abstract boolean isValidStock(String stockSymbol) throws NseTimeoutException, NseDataParsingException, NseResponseFailureException;

    public abstract List<Index> getIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    public abstract boolean isValidIndex(String indexName) throws NseTimeoutException, NseDataParsingException, NseResponseFailureException;

    public abstract List<GainerLoserStats> getTopGainers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    public abstract List<GainerLoserStats> getTopLosers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    public abstract List<AdvanceDeclineStats> getAdvancesDeclines() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException;

    public abstract Index getIndexQuote(String indexName) throws NoSuchElementException, NseTimeoutException, NseResponseFailureException, NseDataParsingException;

    public static class NseReaderBuilder {
        Duration timeout;
        String userAgent;

        private NseReaderBuilder() {
        }

        public NseReaderBuilder setRequestUserAgent(String userAgent) {
            Objects.requireNonNull(userAgent);
            this.userAgent = userAgent;
            return this;
        }

        public NseReaderBuilder setRequestTimeout(Duration timeout) {
            Objects.requireNonNull(timeout);
            this.timeout = timeout;
            return this;
        }

        public NseReader build() {
            return new NseReaderImpl(this);
        }
    }
}

