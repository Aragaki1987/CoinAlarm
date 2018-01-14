package net.san.service;

import net.san.entity.Exchange;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;
import java.util.Map;

/**
 * Created by aragaki on 1/13/2018.
 */
public class TrackerService implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Map<String, List<Exchange>> exchanges = (Map<String, List<Exchange>>) jobExecutionContext.get("exchanges");
        Map<String, List<Exchange>> liveExchanges = ExchangeService.loadAllExchange();

        for(String key : exchanges.keySet()) {
            List<Exchange> exchange = exchanges.get(key);
            List<Exchange> liveExchange = liveExchanges.get(key);

            if(exchange.get(0).getCoins().size() != liveExchange.get(0).getCoins().size()) {
                alarms(key, exchange, liveExchange);
                exchange.clear();
                exchange.addAll(liveExchange);
            }
        }

    }

    private void alarms(String key, List<Exchange> exchange, List<Exchange> liveExchange) {

    }
}
