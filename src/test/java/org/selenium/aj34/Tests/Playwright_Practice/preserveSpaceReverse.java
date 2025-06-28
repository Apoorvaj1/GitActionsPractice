package org.selenium.aj34.Tests.Playwright_Practice;

public class preserveSpaceReverse {
    public static void main(String[] args) {
        String name = "My name is Apoorv";
        char[] ch = name.toCharArray();
        int start = 0;
        int end = ch.length-1;
        while(start<end){
            if(ch[start]==' '){
                start++;
            } else if (ch[end]==' ') {
                end--;
            }
            else{
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
