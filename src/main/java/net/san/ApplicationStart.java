package net.san;

import net.san.entity.Exchange;
import net.san.service.ExchangeService;
import net.san.service.FileService;
import net.san.timer.Worker;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by aragaki on 1/13/2018.
 */
public class ApplicationStart{

    public static void main(String[] args) throws IOException {
        Map<String, List<Exchange>> exchanges = FileService.loadExchangeFiles();
        if(exchanges.isEmpty()) {
            exchanges = ExchangeService.loadAllExchange();
        }
        new Worker().start(exchanges);
    }
}
