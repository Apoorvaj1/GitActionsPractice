package org.selenium.aj34.Tests.Playwright_Practice;

import java.util.Arrays;

public class findDuplicate {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,6,73,3};
        int[] temp = new int[arr.length];
        int count =0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    boolean flag = false;
                    for(int k=0;k<count;k++){
                        if(temp[k]==arr[i]){
                            flag=true;
                            break;
                        }
                    }
                    if(!flag){
                        temp[count++]=arr[i];
                    }
                }

            }
        }
        int[] arr2 = Arrays.copyOf(temp,count);
        System.out.println(Arrays.toString(arr2));
    }
}
