package org.selenium.aj34.Tests.Playwright_Practice;

public class ReverseWord {
    public static void main(String[] args) {
        String name = "     I Love Java           ";
        name= name.trim();
        String[] str = name.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = str.length-1;i>=0;i--){
            builder.append(str[i]).append(" ");
        }
        System.out.println(builder);
    }
}
