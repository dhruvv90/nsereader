package nsereader;

class NseReaderBuilderImpl implements NseReader.Builder {

    NseReaderBuilderImpl() {
    }

    @Override
    public NseReader build() {
        return new NseReaderImpl(this);
    }
}
