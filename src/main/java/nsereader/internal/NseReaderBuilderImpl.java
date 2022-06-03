package nsereader.internal;

import nsereader.NseReader;

public class NseReaderBuilderImpl implements NseReader.Builder {

    public NseReaderBuilderImpl() {
    }

    @Override
    public NseReader build() {
        return new NseReaderImpl(this);
    }
}
