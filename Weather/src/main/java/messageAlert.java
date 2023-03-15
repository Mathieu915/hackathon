import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.SneakyThrows;
import model.RecupApiMeteo;
import model.RecupAssure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class messageAlert {

    public static final String ACCOUNT_SID = "AC096b1d7da075d6e85c198c10c5d7442b";
    public static final String AUTH_TOKEN = "96161c969691ff80e13af2b0c5c3c08c";
    public static final String FROM_NUMBER = "+15076051940";

    @SneakyThrows
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger("SampleLogger");
        logger.atDebug();

        RecupApiMeteo recupApiMeteo = new RecupApiMeteo();
        System.out.println("################################################################");
        System.out.println("##############   Récupération données API méteo   ##############");
        System.out.println("################################################################");

        // recuperation des donnees reçues par la simulation de l'API
        for (int i=0; i<recupApiMeteo.getEvenementsMeteo().size(); i++){
            Thread.sleep(2000);
            System.out.println("Evenement meteo recu : " + recupApiMeteo.getEvent(i).get("meteo").toUpperCase()
                    + " à " + recupApiMeteo.getEvent(i).get("lieu").toUpperCase() + " \n");

            // vérification de la nature de l'événement reçu
            if(recupApiMeteo.getEvent(i).get("meteo").equals("grele")){
                System.out.println("     Récupération des habitants de " + recupApiMeteo.getEvent(i).get("lieu").toUpperCase() + " :");
                RecupAssure recupAssure = new RecupAssure();

                // recuperation assurés concernés
                for (int j=0; j<recupAssure.getAssures().size(); j++){
                    if (recupAssure.getAssure(j).get("lieu").equals(recupApiMeteo.getEvent(i).get("lieu"))){
                        System.out.print("           " + recupAssure.getAssure(j).get("nom").toUpperCase() + " " + recupAssure.getAssure(j).get("prenom"));
                        // envoie message
                        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                        Message message = Message.creator(new PhoneNumber(recupAssure.getAssure(j).get("numero")),
                                new PhoneNumber(FROM_NUMBER), "Alerte " + recupApiMeteo.getEvent(i).get("meteo").toUpperCase() + "! Consultez nos recommandations de sécurité ici : https://fascinating-cucurucho-7c712e.netlify.app/").create();
                        System.out.println(".............. message envoyé \n");

                    }
                }
            }

        }

    }
}


