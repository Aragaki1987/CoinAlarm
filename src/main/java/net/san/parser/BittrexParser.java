package net.san.parser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.san.entity.Bittrex;

import java.io.IOException;
import java.net.URL;

/**
 * Created by aragaki on 1/13/2018.
 */
public class BittrexParser {
    public static String URL = "https://bittrex.com";

    public static Bittrex getAllMarkets() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Bittrex bittrex = null;
        try {
            bittrex = objectMapper.readValue(new URL(URL + "/api/v1.1/public/getmarkets"), Bittrex.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bittrex;
    }
}
