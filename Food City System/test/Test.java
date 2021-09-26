
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishka
 */
public class Test {
   
    
    public static void main(String[] args) {
         String s = "172.31.255.220\n" +
"UDO:[ 172.31.255.220 ]:44095->[ 172.31.255.220]:162\n" +
"DISMAN-EVENT-MIB::sysUpTimeInstance10:0:31:35.05\n" +
"SNMPv2-MIB::snmpTrapOID.0.SNMPv2-SMI::enterprises.31731.6.1.3.1\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.1 4\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.2 \"Over-temperature Alarm\"\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.3 1\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.4 4\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.5 \"Master AU\"\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.6 \"#00000009#0\"\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.7 \"2020-10-28 20:09:54\"\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.8 \"2020-10-28 20:09:54\"\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.9 \"AU9 D17 8.9.18.21\"\n" +
"SNMPv2-MIB::enterprises.31731.6.1.3.1.10 \"UNIVERSITY OF SYDNEY - H69 BTS HOTEL\"";
         
        String[] split = s.split("\n");
        ArrayList<String> dataList = new ArrayList<>();
        
        String ip = split[0];
        String alarm = split[5].split("\"")[1];
        String device = split[8].split("\"")[1];
        String deviceid = split[9].split("\"")[1];
        String date1 = split[10].split("\"")[1];
        String date2 = split[11].split("\"")[1];
        String location = split[10].split("\"")[1];
        String site = split[13].split("\"")[1];
        
        System.out.println(ip);
        System.out.println(alarm);
        System.out.println(device);
        System.out.println(deviceid);
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(location);
        System.out.println(site);
    }
}
