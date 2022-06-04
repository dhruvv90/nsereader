package nsereader.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

class DoubleCommaDeserializer extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String s = p.getText();
        if (s.contains(",")) {
            s = s.replace(",", "");
        }
        return Double.valueOf(s);
    }
}

class IntegerCommaDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String s = p.getText();
        if (s.contains(",")) {
            s = s.replace(",", "");
        }
        return Integer.valueOf(s);
    }
}
