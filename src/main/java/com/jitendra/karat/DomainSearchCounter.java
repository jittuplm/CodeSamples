package com.jitendra.karat;

// You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

// counts = [ "900,google.com",
//      "60,mail.yahoo.com",
//      "10,mobile.sports.yahoo.com",
//      "40,sports.yahoo.com",
//      "300,yahoo.com",
//      "10,stackoverflow.com",
//      "20,overflow.com",
//      "2,en.wikipedia.org",
//      "1,m.wikipedia.org",
//      "1,mobile.sports",
//      "1,google.co.uk"]

// Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

// Sample output (in any order/format):

// calculateClicksByDomain(counts)
// 1340    com
//  900    google.com
//   10    stackoverflow.com
//   20    overflow.com
//  410    yahoo.com
//   60    mail.yahoo.com
//   10    mobile.sports.yahoo.com
//   50    sports.yahoo.com
//    3    org
//    3    wikipedia.org
//    2    en.wikipedia.org
//    1    m.wikipedia.org
//    1    mobile.sports
//    1    sports
//    1    uk
//    1    co.uk
//    1    google.co.uk

// n: number of domains in the input
// (subdomains within a domain are constant)

import java.util.HashMap;
import java.util.Map;

public class DomainSearchCounter {


    public static void main(String[] argv) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        Map<String,Integer> map = getWords(counts);
        System.out.println(map.toString());

    }

    public static Map<String,Integer> getWords(String[] s){
        String temp = null;
        int count = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i< s.length; i++){
            String[] comma = s[i].split(",");
            if(map.containsKey(comma[1]))
                map.put(comma[1], map.get(comma[1]) + Integer.parseInt(comma[0]));
            else
                map.put(comma[1], Integer.parseInt(comma[0]));
            temp = comma[1];
            int in = 0;
            System.out.println(temp);
            while(temp.length() > 0 && (in=temp.indexOf(".")) != -1){
                temp = temp.substring(in+1, temp.length());
                if(map.containsKey(temp)){
                    count = map.get(temp) + Integer.parseInt(comma[0]);
                    map.put(temp, count);
                }
                else
                    map.put(temp, Integer.parseInt(comma[0]));
            }
        }
        return map;
    }
}
