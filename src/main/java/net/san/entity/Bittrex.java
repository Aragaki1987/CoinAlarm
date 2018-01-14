package net.san.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Created by aragaki on 1/13/2018.
 */
public class Bittrex implements Exchange{
    private boolean success;
    private String message;
    private List<BittrexCoin> coins;

    @JsonIgnore
    private Date loadTime;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BittrexCoin> getCoins() {
        return coins;
    }

    public void setCoins(List<BittrexCoin> coins) {
        this.coins = coins;
    }

    public Date getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Date loadTime) {
        this.loadTime = loadTime;
    }
}
