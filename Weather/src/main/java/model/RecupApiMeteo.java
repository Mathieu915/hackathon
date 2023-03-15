package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecupApiMeteo {

    List<Map<String,String>> evenementsMeteo;

    public RecupApiMeteo(){
        evenementsMeteo = new ArrayList<>();
        Map event1 = new HashMap();
        Map event2 = new HashMap();
        Map event3 = new HashMap();
        Map event4 = new HashMap();

        event1.put("meteo","pluie");
        event1.put("lieu","orleans");

        event2.put("meteo","soleil");
        event2.put("lieu","orleans");

        event3.put("meteo","grele");
        event3.put("lieu","orleans");

        event4.put("meteo","pluie");
        event4.put("lieu","paris");

        evenementsMeteo.add(event1);
        evenementsMeteo.add(event2);
        evenementsMeteo.add(event4);
        evenementsMeteo.add(event1);
        evenementsMeteo.add(event4);
        evenementsMeteo.add(event2);
        evenementsMeteo.add(event3);
        evenementsMeteo.add(event4);
    }

    public Map<String,String> getEvent(int index){
        return evenementsMeteo.get(index);
    }

    public List<Map<String,String>> getEvenementsMeteo(){
        return evenementsMeteo;
    }

}
