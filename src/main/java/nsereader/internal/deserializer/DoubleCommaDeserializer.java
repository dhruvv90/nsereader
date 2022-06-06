package nsereader.internal.deserializer;

public class DoubleCommaDeserializer extends ICommaDeserializer<Double> {
    @Override
    Double fromString(String s) {
        return Double.valueOf(s);
    }
}
