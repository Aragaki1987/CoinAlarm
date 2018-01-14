package net.san.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by aragaki on 1/13/2018.
 */
public interface Exchange extends Serializable {
    public Date getLoadTime();

    public void setLoadTime(Date loadTime);

    public List<BittrexCoin> getCoins();

    public void setCoins(List<BittrexCoin> coins);
}
