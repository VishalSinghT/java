import java.util.Scanner;


    /* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    /* Name of the class has to be "Main" only if the class is public. */

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr1 = new int[t];
        int[] arr2 = new int[t];
        int []sum1 = new int[1];
        int []sum2=  new int[1];

        for (int i = 0; i < t; i++) {
            arr1[i]=sc.nextInt();
            arr2[i] = sc.nextInt();

            }
             for (int i = 0; i < t; i++) {

                    sum1[i]= arr1[i]-arr2[i];
                    sum2[i]= arr2[i]-arr1[i];

                }
        for (int i = 0; i < t; i++) {
            if(sum1[i]>sum2[i]){
                System.out.println("1 "+sum1[i]);
            }
            else{
                System.out.println("2"+ sum2[i]);
            }

        }
            }
}