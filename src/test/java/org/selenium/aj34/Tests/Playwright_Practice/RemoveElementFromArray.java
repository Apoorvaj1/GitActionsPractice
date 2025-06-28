package org.selenium.aj34.Tests.Playwright_Practice;

import java.util.Arrays;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        String[] arr = {"ele","gerg","rghj","wwetwe"};
        String[] arr1 = extractElement(arr,"ele");
        System.out.println(Arrays.toString(arr1));
    }

    public static String[] extractElement(String[] arr,String ele){
        return Arrays.stream(arr).filter(value -> !value.equals(ele)).toArray(String[]::new);
    }
}
