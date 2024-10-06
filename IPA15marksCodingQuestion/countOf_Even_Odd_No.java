/*
 Input :- arr[] = {5,8,2,4,1,3,6};
 Output :- evenCount = 4
           oddCount = 3
           even_Count_Sum = 20 
           odd_Count_Sum = 9
 */

import java.util.Scanner;

public class countOf_Even_Odd_No {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int evenCount=0,oddCount=0;
        int evenCount_sum=0,oddCount_sum=0;

        for(int i=0;i<n;i++){
            //even
            if(arr[i]%2 == 0){
                evenCount++;
                evenCount_sum += arr[i];
            }else{ //odd
                oddCount++;
                oddCount_sum += arr[i];
            }
        }
        System.out.println("Even count :- " + evenCount);
        System.out.println("Odd Count :- " + oddCount);
        System.out.println("Even Count sum :- " + evenCount_sum);
        System.out.println("Odd Count sum:- " + oddCount_sum);

    }
}
