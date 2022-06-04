package nsereader.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

public class Index {

    private String name;

    @JsonDeserialize(using = PriceDeserializer.class)
    private Double lastPrice;

    @JsonDeserialize(using = PriceDeserializer.class)
    private Double change;

    @JsonDeserialize(using = PriceDeserializer.class)
    private Double pChange;

    private String imgFileName;

    public Index() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getpChange() {
        return pChange;
    }

    public void setpChange(Double pChange) {
        this.pChange = pChange;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}


class PriceDeserializer extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String s = p.getText();
        if (s.contains(",")) {
            s = s.replace(",", "");
        }
        return Double.valueOf(s);
    }
}
