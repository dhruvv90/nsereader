package nsereader;

import nsereader.internal.NseReaderBuilderImpl;

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


