package IPA_Ques_2;
/*
 Q.2 Create class Movie with below attributes: 

movieName - String 
company - String 
genre - String 
budget - int
Create class Solution and implement static method "getMovieByGenre" in the Solution class. This method will take array of Movie objects and a searchGenre String as parameters. And will return another array of Movie objects where the searchGenre String matches with the original array of Movie object's genre attribute (case insensitive search).
Write necessary getters and setters.
Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the attributes in above sequence along with a String searchGenre. Then call the "getMovieByGenre" method and write logic in main method to print "High Budget Movie",if the movie budget attribute is greater than 80000000 else 
print "Low Budget Movie".


Input
---------
aaa
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action

Output
-------------------
High Budget Movie
High Budget Movie

 */


import java.util.Scanner;

class Movie{
    String movieName;
    String company;
    String genere;
    int budget;

    Movie(String movieName,String company,String genere,int budget){
        this.movieName = movieName;
        this.company = company;
        this.genere = genere;
        this.budget = budget;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movie[] arr = new Movie[4];

        for(int i=0;i<4;i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();

            arr[i] = new Movie(a,b,c,d);
        }
        String searchGenre = sc.nextLine();

       Movie[] ans = getMovieByGenre(arr,searchGenre);
       for(int i=0;i<ans.length;i++){
        if(ans[i].budget > 80000000){
            System.out.println("High Budget Movie");
        }else{
            System.out.println("Low Budget Movie");
        }
       }

    }

    static Movie[] getMovieByGenre(Movie[] arr,String s){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].genere.equalsIgnoreCase(s)){
                count++;
            }
        }

        Movie[] obj = new Movie[count];
        int idx=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].genere.equalsIgnoreCase(s)){
                obj[idx++] = arr[i];
            }
        }
        return obj;
    }
}
