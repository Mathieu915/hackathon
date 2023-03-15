package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecupAssure {

    List<Map<String,String>> assures;

    public RecupAssure(){
        assures = new ArrayList<>();
        Map event1 = new HashMap();
        Map event2 = new HashMap();
        Map event3 = new HashMap();
        Map event4 = new HashMap();

        event1.put("numero","+33641853051");
        event1.put("lieu","orleans");
        event1.put("nom","Yehya");
        event1.put("prenom","Jeremy");


        event2.put("numero","+336XXXXXXX");
        event2.put("lieu","paris");
        event2.put("nom","Clavie");
        event2.put("prenom","Mathieu");

        event3.put("numero","+336XXXXXXX");
        event3.put("lieu","tours");
        event3.put("nom","Mercurin");
        event3.put("prenom","Hugo");

        event4.put("numero","+336XXXXXXX");
        event4.put("lieu","tours");
        event4.put("nom","Dovillaire");
        event4.put("prenom","Hugo");

        assures.add(event1);
        assures.add(event2);
        assures.add(event3);
        assures.add(event4);

    }

    public Map<String,String> getAssure(int index){
        return assures.get(index);
    }

    public List<Map<String,String>> getAssures(){
        return assures;
    }

}
