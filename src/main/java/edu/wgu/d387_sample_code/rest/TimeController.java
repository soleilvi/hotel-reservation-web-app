package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.time.ConvertTimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class TimeController {

    @RequestMapping("/time")
    public String getTimes() {
        JSONArray jsonArray = new JSONArray();

        ConvertTimeZone mountainTime = new ConvertTimeZone("MT");
        ConvertTimeZone universalTime = new ConvertTimeZone("UTC");
        ConvertTimeZone easternTime = new ConvertTimeZone("ET");

        String jsonString = "{hour: " + mountainTime.getHourAtTimeZone() +
                            ", minutes: " + mountainTime.getMinutesAtTimeZone() +
                            ", code: " + mountainTime.getCode() + "}";
        JSONObject jsonObject = new JSONObject(jsonString);
        jsonArray.put(jsonObject);

        jsonString = "{hour: " + easternTime.getHourAtTimeZone() +
                     ", minutes: " + easternTime.getMinutesAtTimeZone() +
                     ", code: " + easternTime.getCode() + "}";
        jsonObject = new JSONObject(jsonString);
        jsonArray.put(jsonObject);

        jsonString = "{hour: " + universalTime.getHourAtTimeZone() +
                ", minutes: " + universalTime.getMinutesAtTimeZone() +
                ", code: " + universalTime.getCode() + "}";
        jsonObject = new JSONObject(jsonString);
        jsonArray.put(jsonObject);

        return jsonArray.toString();
    }
}
