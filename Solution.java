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
