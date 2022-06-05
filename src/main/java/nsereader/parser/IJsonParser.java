package nsereader.parser;

import nsereader.exception.NseDataParsingException;
import nsereader.model.GainerLoserStats;
import nsereader.model.Index;

import java.io.InputStream;
import java.util.List;

public interface IJsonParser {

    static IJsonParser getCurrentInstance() {
        return JsonParserImpl.getInstance();
    }

    List<Index> parseAllIndices(InputStream iStream) throws NseDataParsingException;


    List<GainerLoserStats> parseTopGainers(InputStream iStream) throws NseDataParsingException;

    List<GainerLoserStats> parseTopLosers(InputStream iStream) throws NseDataParsingException;

}

