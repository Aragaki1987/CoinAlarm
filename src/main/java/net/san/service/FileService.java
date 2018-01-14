package net.san.service;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import net.san.constant.Constant;
import net.san.entity.Bittrex;
import net.san.entity.Exchange;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aragaki on 1/13/2018.
 */
public class FileService {
    public static void save(String name, Exchange data) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        String finalName = data.getClass().getName() + "_" + name + "_" + new Date().getTime() + ".json";
        File file = new File(finalName);
        try {
            writer.writeValue(file, data);
        } catch (IOException e) {
            System.out.println("ERROR : Cannot write file at " + file.getPath());
        }
    }

    public static Map<String, List<Exchange>> loadExchangeFiles() throws IOException {
        List<String> allFiles = loadAllFile();

        Map<String, List<Exchange>> result = new HashMap<>();

        for(String name : allFiles) {
            String rawName = name.split(".")[0];
            String exchangeName = rawName.split("_")[0];

            List<Exchange> exchanges = result.get(exchangeName);
            if(exchanges == null) {
                exchanges = new ArrayList<>();
                result.put(exchangeName, exchanges);
            }

            ObjectMapper mapper = new ObjectMapper();
            if(exchangeName.equals(Constant.BITTREX)) {
                Bittrex bittrex = mapper.readValue(new File(name), Bittrex.class);
                exchanges.add(bittrex);
            }
        }

        return result;
    }

    private static List<String> loadAllFile() {
        File folder = new File("./");
        File[] listOfFiles = folder.listFiles();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String fileName = listOfFiles[i].getName();
                if(validateFileName(fileName)) {
                    result.add(fileName);
                }
            }
        }
        return result;
    }

    private static boolean validateFileName(String fileName) {
        String [] postFix = fileName.split(".");
        if(postFix.length < 2 || !postFix[1].toLowerCase().equals("json")) {
            return false;
        }
        return true;
    }
}
