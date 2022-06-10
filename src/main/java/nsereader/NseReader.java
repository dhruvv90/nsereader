package nsereader;

import nsereader.exception.NseConnectionException;
import nsereader.exception.NseDataException;
import nsereader.exception.NseResponseFailureException;
import nsereader.model.*;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public abstract class NseReader {
    public static NseReader createDefault() {
        return getBuilder().build();
    }

    public static NseReaderBuilder getBuilder() {
        return new NseReaderBuilder();
    }

    public abstract StockQuote getStockQuote(String stockSymbol) throws NseDataException, NseResponseFailureException, NseConnectionException;

    public abstract List<Stock> getStocks() throws NseDataException, NseResponseFailureException, NseConnectionException;

    public abstract boolean isValidStock(String stockSymbol) throws NseConnectionException, NseDataException, NseResponseFailureException;

    public abstract List<Index> getIndices() throws NseDataException, NseResponseFailureException, NseConnectionException;

    public abstract boolean isValidIndex(String indexName) throws NseConnectionException, NseDataException, NseResponseFailureException;

    public abstract List<GainerLoserStats> getTopGainers() throws NseDataException, NseResponseFailureException, NseConnectionException;

    public abstract List<GainerLoserStats> getTopLosers() throws NseDataException, NseResponseFailureException, NseConnectionException;

    public abstract List<AdvanceDeclineStats> getAdvancesDeclines() throws NseDataException, NseResponseFailureException, NseConnectionException;

    public abstract Index getIndexQuote(String indexName) throws NseConnectionException, NseResponseFailureException, NseDataException;

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

