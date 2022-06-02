package com.nsereader;

public abstract class NseReader {
    public static NseReader createDefault() {
        return getBuilder().build();
    }

    public static Builder getBuilder() {
        return new NseReaderBuilderImpl();
    }

    public interface Builder {
        NseReader build();
    }
}


class NseReaderBuilderImpl implements NseReader.Builder {

    NseReaderBuilderImpl() {
    }

    @Override
    public NseReader build() {
        return new NseReaderImpl(this);
    }
}


