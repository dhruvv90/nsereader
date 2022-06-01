package com.nsereader;

import com.nsereader.datafetcher.IDataFetcher;
import com.nsereader.dataparser.IDataParser;

class NseReaderImpl extends NseReader {

    private final IDataFetcher dataFetcher;
    private final IDataParser dataParser;

    NseReaderImpl(NseReaderBuilderImpl builder) {
        this.dataFetcher = IDataFetcher.createDefault(builder.getDuration());
        this.dataParser = IDataParser.createDefault();
    }
}
