package nsereader.model;

import java.math.BigDecimal;
import java.util.Date;

public class StockQuote {
    private BigDecimal pricebandupper;
    private String symbol;
    private BigDecimal applicableMargin;
    private Date bcEndDate;
    private Integer totalSellQuantity;
    private BigDecimal adhocMargin;
    private String companyName;
    private String marketType;
    private Date exDate;
    private Date bcStartDate;
    private String css_status_desc;

    private BigDecimal dayHigh;

    private BigDecimal basePrice;

    private BigDecimal securityVar;

    private BigDecimal pricebandlower;
    private Integer sellQuantity5;
    private Integer sellQuantity4;
    private Integer sellQuantity3;
    private Date cm_adj_high_dt;
    private Integer sellQuantity2;

    private BigDecimal dayLow;
    private Integer sellQuantity1;
    private Integer quantityTraded;

    private BigDecimal pChange;

    private BigDecimal totalTradedValue;

    private BigDecimal deliveryToTradedQuantity;
    private Integer totalBuyQuantity;

    private BigDecimal averagePrice;

    private BigDecimal cm_ffm;
    private String purpose;

    private BigDecimal buyPrice2;
    private Date secDate;
    private String indexVar;

    private BigDecimal buyPrice1;

    private BigDecimal high52;

    private BigDecimal previousClose;
    private Date ndEndDate;

    private BigDecimal low52;

    private BigDecimal buyPrice4;

    private BigDecimal buyPrice3;
    private Date recordDate;
    private Integer deliveryQuantity;

    private BigDecimal buyPrice5;
    private String priceBand;

    private BigDecimal extremeLossMargin;
    private Date cm_adj_low_dt;

    private BigDecimal varMargin;
    private Integer totalTradedVolume;

    private BigDecimal change;
    private String series;

    private BigDecimal faceValue;

    private BigDecimal sellPrice1;

    private BigDecimal sellPrice2;

    private BigDecimal closePrice;

    private BigDecimal sellPrice3;

    private BigDecimal sellPrice4;

    private BigDecimal sellPrice5;

    private BigDecimal open;
    private String surv_indicator;
    private Date ndStartDate;
    private Integer buyQuantity4;
    private Boolean isExDateFlag;
    private Integer buyQuantity3;
    private Integer buyQuantity2;
    private Integer buyQuantity1;
    private String isinCode;

    private BigDecimal lastPrice;
    private Integer buyQuantity5;

    public BigDecimal getPricebandupper() {
        return pricebandupper;
    }

    public void setPricebandupper(BigDecimal pricebandupper) {
        this.pricebandupper = pricebandupper;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getApplicableMargin() {
        return applicableMargin;
    }

    public void setApplicableMargin(BigDecimal applicableMargin) {
        this.applicableMargin = applicableMargin;
    }

    public Date getBcEndDate() {
        return bcEndDate;
    }

    public void setBcEndDate(Date bcEndDate) {
        this.bcEndDate = bcEndDate;
    }

    public Integer getTotalSellQuantity() {
        return totalSellQuantity;
    }

    public void setTotalSellQuantity(Integer totalSellQuantity) {
        this.totalSellQuantity = totalSellQuantity;
    }

    public BigDecimal getAdhocMargin() {
        return adhocMargin;
    }

    public void setAdhocMargin(BigDecimal adhocMargin) {
        this.adhocMargin = adhocMargin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public Date getExDate() {
        return exDate;
    }

    public void setExDate(Date exDate) {
        this.exDate = exDate;
    }

    public Date getBcStartDate() {
        return bcStartDate;
    }

    public void setBcStartDate(Date bcStartDate) {
        this.bcStartDate = bcStartDate;
    }

    public String getCss_status_desc() {
        return css_status_desc;
    }

    public void setCss_status_desc(String css_status_desc) {
        this.css_status_desc = css_status_desc;
    }

    public BigDecimal getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(BigDecimal dayHigh) {
        this.dayHigh = dayHigh;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getSecurityVar() {
        return securityVar;
    }

    public void setSecurityVar(BigDecimal securityVar) {
        this.securityVar = securityVar;
    }

    public BigDecimal getPricebandlower() {
        return pricebandlower;
    }

    public void setPricebandlower(BigDecimal pricebandlower) {
        this.pricebandlower = pricebandlower;
    }

    public Integer getSellQuantity5() {
        return sellQuantity5;
    }

    public void setSellQuantity5(Integer sellQuantity5) {
        this.sellQuantity5 = sellQuantity5;
    }

    public Integer getSellQuantity4() {
        return sellQuantity4;
    }

    public void setSellQuantity4(Integer sellQuantity4) {
        this.sellQuantity4 = sellQuantity4;
    }

    public Integer getSellQuantity3() {
        return sellQuantity3;
    }

    public void setSellQuantity3(Integer sellQuantity3) {
        this.sellQuantity3 = sellQuantity3;
    }

    public Date getCm_adj_high_dt() {
        return cm_adj_high_dt;
    }

    public void setCm_adj_high_dt(Date cm_adj_high_dt) {
        this.cm_adj_high_dt = cm_adj_high_dt;
    }

    public Integer getSellQuantity2() {
        return sellQuantity2;
    }

    public void setSellQuantity2(Integer sellQuantity2) {
        this.sellQuantity2 = sellQuantity2;
    }

    public BigDecimal getDayLow() {
        return dayLow;
    }

    public void setDayLow(BigDecimal dayLow) {
        this.dayLow = dayLow;
    }

    public Integer getSellQuantity1() {
        return sellQuantity1;
    }

    public void setSellQuantity1(Integer sellQuantity1) {
        this.sellQuantity1 = sellQuantity1;
    }

    public Integer getQuantityTraded() {
        return quantityTraded;
    }

    public void setQuantityTraded(Integer quantityTraded) {
        this.quantityTraded = quantityTraded;
    }

    public BigDecimal getpChange() {
        return pChange;
    }

    public void setpChange(BigDecimal pChange) {
        this.pChange = pChange;
    }

    public BigDecimal getTotalTradedValue() {
        return totalTradedValue;
    }

    public void setTotalTradedValue(BigDecimal totalTradedValue) {
        this.totalTradedValue = totalTradedValue;
    }

    public BigDecimal getDeliveryToTradedQuantity() {
        return deliveryToTradedQuantity;
    }

    public void setDeliveryToTradedQuantity(BigDecimal deliveryToTradedQuantity) {
        this.deliveryToTradedQuantity = deliveryToTradedQuantity;
    }

    public Integer getTotalBuyQuantity() {
        return totalBuyQuantity;
    }

    public void setTotalBuyQuantity(Integer totalBuyQuantity) {
        this.totalBuyQuantity = totalBuyQuantity;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getCm_ffm() {
        return cm_ffm;
    }

    public void setCm_ffm(BigDecimal cm_ffm) {
        this.cm_ffm = cm_ffm;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public BigDecimal getBuyPrice2() {
        return buyPrice2;
    }

    public void setBuyPrice2(BigDecimal buyPrice2) {
        this.buyPrice2 = buyPrice2;
    }

    public Date getSecDate() {
        return secDate;
    }

    public void setSecDate(Date secDate) {
        this.secDate = secDate;
    }

    public String getIndexVar() {
        return indexVar;
    }

    public void setIndexVar(String indexVar) {
        this.indexVar = indexVar;
    }

    public BigDecimal getBuyPrice1() {
        return buyPrice1;
    }

    public void setBuyPrice1(BigDecimal buyPrice1) {
        this.buyPrice1 = buyPrice1;
    }

    public BigDecimal getHigh52() {
        return high52;
    }

    public void setHigh52(BigDecimal high52) {
        this.high52 = high52;
    }

    public BigDecimal getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(BigDecimal previousClose) {
        this.previousClose = previousClose;
    }

    public Date getNdEndDate() {
        return ndEndDate;
    }

    public void setNdEndDate(Date ndEndDate) {
        this.ndEndDate = ndEndDate;
    }

    public BigDecimal getLow52() {
        return low52;
    }

    public void setLow52(BigDecimal low52) {
        this.low52 = low52;
    }

    public BigDecimal getBuyPrice4() {
        return buyPrice4;
    }

    public void setBuyPrice4(BigDecimal buyPrice4) {
        this.buyPrice4 = buyPrice4;
    }

    public BigDecimal getBuyPrice3() {
        return buyPrice3;
    }

    public void setBuyPrice3(BigDecimal buyPrice3) {
        this.buyPrice3 = buyPrice3;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getDeliveryQuantity() {
        return deliveryQuantity;
    }

    public void setDeliveryQuantity(Integer deliveryQuantity) {
        this.deliveryQuantity = deliveryQuantity;
    }

    public BigDecimal getBuyPrice5() {
        return buyPrice5;
    }

    public void setBuyPrice5(BigDecimal buyPrice5) {
        this.buyPrice5 = buyPrice5;
    }

    public String getPriceBand() {
        return priceBand;
    }

    public void setPriceBand(String priceBand) {
        this.priceBand = priceBand;
    }

    public BigDecimal getExtremeLossMargin() {
        return extremeLossMargin;
    }

    public void setExtremeLossMargin(BigDecimal extremeLossMargin) {
        this.extremeLossMargin = extremeLossMargin;
    }

    public Date getCm_adj_low_dt() {
        return cm_adj_low_dt;
    }

    public void setCm_adj_low_dt(Date cm_adj_low_dt) {
        this.cm_adj_low_dt = cm_adj_low_dt;
    }

    public BigDecimal getVarMargin() {
        return varMargin;
    }

    public void setVarMargin(BigDecimal varMargin) {
        this.varMargin = varMargin;
    }

    public Integer getTotalTradedVolume() {
        return totalTradedVolume;
    }

    public void setTotalTradedVolume(Integer totalTradedVolume) {
        this.totalTradedVolume = totalTradedVolume;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public BigDecimal getSellPrice1() {
        return sellPrice1;
    }

    public void setSellPrice1(BigDecimal sellPrice1) {
        this.sellPrice1 = sellPrice1;
    }

    public BigDecimal getSellPrice2() {
        return sellPrice2;
    }

    public void setSellPrice2(BigDecimal sellPrice2) {
        this.sellPrice2 = sellPrice2;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public BigDecimal getSellPrice3() {
        return sellPrice3;
    }

    public void setSellPrice3(BigDecimal sellPrice3) {
        this.sellPrice3 = sellPrice3;
    }

    public BigDecimal getSellPrice4() {
        return sellPrice4;
    }

    public void setSellPrice4(BigDecimal sellPrice4) {
        this.sellPrice4 = sellPrice4;
    }

    public BigDecimal getSellPrice5() {
        return sellPrice5;
    }

    public void setSellPrice5(BigDecimal sellPrice5) {
        this.sellPrice5 = sellPrice5;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public String getSurv_indicator() {
        return surv_indicator;
    }

    public void setSurv_indicator(String surv_indicator) {
        this.surv_indicator = surv_indicator;
    }

    public Date getNdStartDate() {
        return ndStartDate;
    }

    public void setNdStartDate(Date ndStartDate) {
        this.ndStartDate = ndStartDate;
    }

    public Integer getBuyQuantity4() {
        return buyQuantity4;
    }

    public void setBuyQuantity4(Integer buyQuantity4) {
        this.buyQuantity4 = buyQuantity4;
    }

    public Boolean getIsExDateFlag() {
        return isExDateFlag;
    }

    public void setIsExDateFlag(Boolean exDateFlag) {
        isExDateFlag = exDateFlag;
    }

    public Integer getBuyQuantity3() {
        return buyQuantity3;
    }

    public void setBuyQuantity3(Integer buyQuantity3) {
        this.buyQuantity3 = buyQuantity3;
    }

    public Integer getBuyQuantity2() {
        return buyQuantity2;
    }

    public void setBuyQuantity2(Integer buyQuantity2) {
        this.buyQuantity2 = buyQuantity2;
    }

    public Integer getBuyQuantity1() {
        return buyQuantity1;
    }

    public void setBuyQuantity1(Integer buyQuantity1) {
        this.buyQuantity1 = buyQuantity1;
    }

    public String getIsinCode() {
        return isinCode;
    }

    public void setIsinCode(String isinCode) {
        this.isinCode = isinCode;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Integer getBuyQuantity5() {
        return buyQuantity5;
    }

    public void setBuyQuantity5(Integer buyQuantity5) {
        this.buyQuantity5 = buyQuantity5;
    }
}
