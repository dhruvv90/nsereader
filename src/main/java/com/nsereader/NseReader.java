package com.nsereader;

import java.time.Duration;


public abstract class NseReader {
    public static NseReader createDefault() {
        return getBuilder().build();
    }

    public static Builder getBuilder() {
        return new NseReaderBuilderImpl();
    }

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


