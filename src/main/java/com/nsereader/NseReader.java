package com.nsereader;

import com.nsereader.exception.NseTimeoutException;
import com.nsereader.exception.NseDataParsingException;
import com.nsereader.exception.NseResponseFailureException;

import java.io.IOException;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;
import java.util.Map;


public abstract class NseReader {
    public static NseReader createDefault() {
        return getBuilder().build();
    }

    public static Builder getBuilder() {
        return new NseReaderBuilderImpl();
    }

    public abstract Map<String, String> getAllStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException, IOException;

    public abstract boolean isValidStockCode(String stockCode);

    public abstract List<String> getAllIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException, IOException;

    public interface Builder {
        Builder setRequestTimeout(Duration duration);

        NseReader build();
    }
}


class NseReaderBuilderImpl implements NseReader.Builder {

    private Duration duration;

    NseReaderBuilderImpl() {
    }

    @Override
    public NseReader build() {
        return new NseReaderImpl(this);
    }

    @Override
    public NseReaderBuilderImpl setRequestTimeout(Duration duration) {
        this.duration = duration;
        return this;
    }

    public Duration getDuration() {
        return duration;
    }
}


