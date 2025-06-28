package org.selenium.aj34.Tests.Playwright_Practice;

public class stringToInteger {
    public static void main(String[] args) {
        String name = "21343243";
        int result = 0;
        for(int i=0;i<name.length();i++){
            char ch = name.charAt(i);
            if(ch>='0' && ch<='9'){
                result = result*10 +(ch-'0');
            }
        }
        System.out.println(result);
    }
}
