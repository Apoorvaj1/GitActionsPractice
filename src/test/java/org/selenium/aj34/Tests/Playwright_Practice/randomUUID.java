package org.selenium.aj34.Tests.Playwright_Practice;

import java.awt.*;
import java.util.Arrays;
import java.util.UUID;

public class randomUUID {
    public static void main(String[] args) {
        String abc = UUID.randomUUID().toString();
        System.out.println(abc);
        String[] abcd = abc.split("-");
        System.out.println(Arrays.toString(abcd));
        System.out.println("user"+abcd[0]+"@gmail.com");
    }
}
