import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class messageAlert {

    public static final String ACCOUNT_SID = "AC096b1d7da075d6e85c198c10c5d7442b";
    public static final String AUTH_TOKEN = "76906ad45901e7466b5602e8d3483378";
    public static final String FROM_NUMBER = "+15076051940";
    public static final String TO_NUMBER = "+33641853051";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(TO_NUMBER),
                new PhoneNumber(FROM_NUMBER), "Alerte Grêle! Consultez nos recommandations de sécurité ici : http://localhost/liste_grele.html").create();
        System.out.println(message.getSid());
    }
}


