package org.selenium.aj34.Tests.Playwright_Practice;

public class reverseOnlyNumber {
    public static void main(String[] args) {
        String name = "df45g23";
        char[] ch = name.toCharArray();
        int start = 0;
        int end = ch.length-1;
        while(start<end){
            if(ch[start]==' '){
                start++;
            } else if (ch[end]==' ') {
                end--;
            } else if (Character.isLetter(ch[start])) {
                start++;
            } else if (Character.isLetter(ch[end])) {
                end--;
            } else{
                char temp = ch[start];
                ch[start]=ch[end];
                ch[end]=temp;
                start++;
                end--;
            }
        }
        System.out.println(new String(ch));
    }
}
