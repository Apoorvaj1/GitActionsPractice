package org.selenium.aj34.Tests.Playwright_Practice;

import java.util.Arrays;

public class AddElementToArray {
    public static void main(String[] args) {
        String[] arr = {"ele","gerg","rghj","wwetwe"};
        String[] arr1 = extractElement(arr,"aj");
        System.out.println(Arrays.toString(arr1));
    }

    public static String[] extractElement(String[] arr,String ele){
        String[] updatedArray = new String[arr.length+1];
        System.arraycopy(arr,0,updatedArray,0,arr.length);
        updatedArray[arr.length]=ele;
        return updatedArray;
    }
}
