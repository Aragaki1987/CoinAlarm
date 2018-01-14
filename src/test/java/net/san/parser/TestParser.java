package net.san.parser;

import net.san.entity.Bittrex;
import net.san.entity.BittrexCoin;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aragaki on 1/13/2018.
 */
public class TestParser {

    @Test
    public void testBittrexParser() {
        Bittrex bittrex = BittrexParser.getAllMarkets();
        System.out.println("Number of coins : " + bittrex.getResult().size());

        List<BittrexCoin> coins = bittrex.getResult();

        List<BittrexCoin> ukgs = new ArrayList<BittrexCoin>();
        for(BittrexCoin coin : coins) {
            if(coin.getMarket_name().toLowerCase().contains("ukg")) {
                ukgs.add(coin);
            }
        }


        for(BittrexCoin ukg : ukgs) {
            System.out.println(ukg.getMarketCurrencyLong() + " - " + ukg.getBaseCurrencyLong() + " : " + ukg.getMarket_name());
        }
    }


    @Test
    public void testFile() {
        File folder = new File("./");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            }
        }
    }

}
