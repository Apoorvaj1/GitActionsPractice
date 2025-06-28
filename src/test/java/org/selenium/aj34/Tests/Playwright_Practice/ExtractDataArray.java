package org.selenium.aj34.Tests.Playwright_Practice;

import java.util.Arrays;

public class ExtractDataArray {

    public static void main(String[] args) {
        String[] arr = {"A","B","C"};
        String[] arr2 = addNew(arr,"A");
        System.out.println(Arrays.toString(arr2));
    }

    public static String[] addNew(String[] arr,String value){
        return Arrays.stream(arr).filter(item -> !item.equals(value)).toArray(String[]::new);
    }
}
