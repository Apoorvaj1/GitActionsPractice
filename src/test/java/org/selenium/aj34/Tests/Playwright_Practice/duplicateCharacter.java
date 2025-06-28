package org.selenium.aj34.Tests.Playwright_Practice;

import java.util.Arrays;

public class duplicateCharacter {
    public static void main(String[] args) {
        String name = "Great responsibility";
        char[] ch = name.toCharArray();
        char[] temp = new char[ch.length];
        int count =0;
        for(int i=0;i<ch.length;i++){
            for(int j=i+1;j<ch.length;j++){
                if(ch[i]==ch[j]){
                    boolean flag = false;
                    for(int k=0;k<count;k++){
                        if(temp[k]==ch[i]){
                            flag=true;
                            break;
                        }
                    }
                    if(!flag){
                        temp[count++]=ch[i];
                    }
                }
            }
        }
        char[] ch2 = Arrays.copyOf(temp,count);
        System.out.println(Arrays.toString(ch2));
    }
}
