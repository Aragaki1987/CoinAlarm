package net.san.service;

import net.san.constant.Constant;
import net.san.entity.Exchange;
import net.san.parser.BittrexParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aragaki on 1/14/2018.
 */
public class ExchangeService {

    public static Map<String, List<Exchange>> loadAllExchange() {
        Map<String, List<Exchange>> result = new HashMap<>();

        List<Exchange> bittrex = new ArrayList<>();
        bittrex.add(BittrexParser.getAllMarkets());
        result.put(Constant.BITTREX, bittrex);
        
        return result;
    }
}
