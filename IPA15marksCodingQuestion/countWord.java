/*
 Input : str = "Home, Sweet Home"
        s = "Home"
 Output : Number of that word present in the sentence : 2
 */

import java.util.Scanner;

public class countWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = sc.nextLine();

        String[] arr = str.split(" ");
        String ch = "";
        int count=0;

        for(int i=0;i<arr.length;i++){
            String c = arr[i];
            for(int j=0;j<c.length();j++){
                if(Character.isLetter(c.charAt(j))){
                    ch = ch+c.charAt(j);
                }
            }
            if(ch.equals(s))
            count++;
            ch = "";
        }

        System.out.println("No. of that word present in the sen :- " + count);
    }
}
