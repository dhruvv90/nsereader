package nsereader.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Index {

    private String name;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double lastPrice;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double change;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double pChange;

    private String imgFileName;

    public Index() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
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


