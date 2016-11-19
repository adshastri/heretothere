package minecrafthelper;

import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SmsSender {

    /* Find your sid and token at twilio.com/user/account */
    public static final String ACCOUNT_SID = "AC15c9cfa125c5e1374411b1ab5d99a595";
    public static final String AUTH_TOKEN = "b1d0e86011257f15f1862e4f015c4546";


    public SmsSender(){



    }

    public void send(String i, String j) throws TwilioRestException {

        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        Account account = client.getAccount();

        i = i.replaceAll("\\s","+");
        j = j.replaceAll("\\s","+");

        //String s = "https://www.google.com/maps/dir/"+i+"/Campbell+Hall+nj/"+j;
        String s = "https://www.google.com/maps/dir/"+i+"/"+j;

        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //params.add(new BasicNameValuePair("To", "+16099068543")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("To", "+16099068543"));
        params.add(new BasicNameValuePair("From", "+16093372224")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("Body", s));
        Message sms = messageFactory.create(params);
    }
}
