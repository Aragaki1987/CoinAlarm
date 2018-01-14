package net.san.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by aragaki on 1/13/2018.
 */
public class BittrexCoin {
    @JsonProperty("MarketCurrency")
    private String marketCurrency;

    @JsonProperty("BaseCurrency")
    private String baseCurrency;

    @JsonProperty("MarketCurrencyLong")
    private String marketCurrencyLong;

    @JsonProperty("BaseCurrencyLong")
    private String baseCurrencyLong;

    @JsonProperty("MinTradeSize")
    private Double minTrade;

    @JsonProperty("MarketName")
    private String market_name;

    @JsonProperty("IsActive")
    private boolean isActive;

    @JsonProperty("Created")
    private Date created;

    @JsonProperty("Notice")
    private String notice;

    @JsonProperty("IsSponsored")
    private boolean isSponsored;

    @JsonProperty("LogoUrl")
    private String logoUrl;

    public String getMarketCurrency() {
        return marketCurrency;
    }

    public void setMarketCurrency(String marketCurrency) {
        this.marketCurrency = marketCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getMarketCurrencyLong() {
        return marketCurrencyLong;
    }

    public void setMarketCurrencyLong(String marketCurrencyLong) {
        this.marketCurrencyLong = marketCurrencyLong;
    }

    public String getBaseCurrencyLong() {
        return baseCurrencyLong;
    }

    public void setBaseCurrencyLong(String baseCurrencyLong) {
        this.baseCurrencyLong = baseCurrencyLong;
    }

    public Double getMinTrade() {
        return minTrade;
    }

    public void setMinTrade(Double minTrade) {
        this.minTrade = minTrade;
    }

    public String getMarket_name() {
        return market_name;
    }

    public void setMarket_name(String market_name) {
        this.market_name = market_name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public boolean isSponsored() {
        return isSponsored;
    }

    public void setSponsored(boolean sponsored) {
        isSponsored = sponsored;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
