package net.muroc;

/**
 * Created by Brendan on 7/31/2017.
 */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /*@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
    */


    @Scheduled(fixedRate =5000)
    public void reportCurrentMessage() throws JSONException, IOException
    {
        JSONObject json = JsonReader.readJsonFromUrl("http://192.168.0.6:8080/data/aircraft.json");
        JSONArray flightAircraft = json.getJSONArray("aircraft");
        ArrayList<FLTrackPoint> trackList=new ArrayList<FLTrackPoint>();

        for(int i = 0; i < flightAircraft.length(); i++)
        {
            JSONObject flightObj = flightAircraft.getJSONObject(i);
            if (flightObj.has("squawk") && flightObj.has("flight"))
            {
                FLTrackPoint currentTrackPoint = new FLTrackPoint(flightObj);
                //System.out.println("Squawk: " + flightObj.get("squawk"));
                log.info("Squawk: " + flightObj.get("squawk"));
            }
        }
        //log.info(quote.toString());
    }
}
