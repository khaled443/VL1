import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
public class NtpTesting {

    public static void main(String[] args) {
        try {
            String time_SERVER = "time-a.nist.gov";
            String ntpDatetime = null;
            InetAddress inetAddress = null;
            TimeInfo timeInfo = null;
            NTPUDPClient timeClient = new NTPUDPClient();
            inetAddress = InetAddress.getByName(time_SERVER);
            if(timeClient != null){
                if(inetAddress != null){
                    timeInfo = timeClient.getTime(inetAddress);
                    if(timeInfo != null){
                        long returnTime = timeInfo.getReturnTime();
                        ntpDatetime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS").format(new java.util.Date(returnTime));
                        String systemDatetime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS").format(new java.util.Date());
                        System.out.println("Time from NTP  = "+ ntpDatetime);
                        System.out.println("systemDatetime = "+systemDatetime);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}