package org.selenium.aj34.Tests.Playwright_Practice;

import java.util.Arrays;

public class moveZeroRight {
    public static void main(String[] args) {
        int[] arr = {0,45,6,7,3,2,0,0,4,2};
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                if(i!=j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
