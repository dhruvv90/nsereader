package nsereader.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

abstract class CommaDeserializer<T> extends JsonDeserializer<T> {

    abstract T fromString(String s);

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String s = p.getText();
        if (s.contains(",")) {
            s = s.replace(",", "");
        }
        return this.fromString(s);
    }
}


class DoubleCommaDeserializer extends CommaDeserializer<Double> {
    @Override
    Double fromString(String s) {
        return Double.valueOf(s);
    }
}


class IntegerCommaDeserializer extends CommaDeserializer<Integer> {
    @Override
    Integer fromString(String s) {
        return Integer.valueOf(s);
    }
}
