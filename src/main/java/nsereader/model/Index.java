package nsereader.model;

import java.math.BigDecimal;

public class Index {

    private String name;

    private BigDecimal lastPrice;

    private BigDecimal change;

    private BigDecimal pChange;

    private String imgFileName;

    public Index() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public BigDecimal getpChange() {
        return pChange;
    }

    public void setpChange(BigDecimal pChange) {
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


