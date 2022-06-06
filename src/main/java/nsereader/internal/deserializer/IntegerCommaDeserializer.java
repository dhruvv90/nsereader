package nsereader.internal.deserializer;

public class IntegerCommaDeserializer extends ICommaDeserializer<Integer> {
    @Override
    Integer fromString(String s) {
        return Integer.valueOf(s);
    }
}
