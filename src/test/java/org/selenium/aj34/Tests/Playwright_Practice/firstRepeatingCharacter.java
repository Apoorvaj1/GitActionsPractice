package org.selenium.aj34.Tests.Playwright_Practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class firstRepeatingCharacter {
    public static void main(String[] args) {
        String name = "My name is Apoorv";
        name = name.toLowerCase();
        char repeatingCharacter = '\0';
        char[] ch = name.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char ch1:ch){
            if(ch1==' '){
                continue;
            }
            if(map.get(ch1)==null){
                map.put(ch1,1);
            }else{
                map.put(ch1,map.get(ch1)+1);
            }
        }
        System.out.println(map);
        for(Map.Entry<Character,Integer> map1:map.entrySet()){
            if(map1.getValue()>1){
                repeatingCharacter = map1.getKey();
                break;
            }
        }
        System.out.println(repeatingCharacter);
    }
}
