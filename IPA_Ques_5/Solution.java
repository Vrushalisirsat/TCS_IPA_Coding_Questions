import java.util.*;

class Student {

    int id;
    String name;
    int totalmarkobt;

    public Student(int id, String name, int totalmarkobt) {
    this.id = id;
    this.name = name;
    this.totalmarkobt = totalmarkobt;
    }
}

public class Solution {

    static void findStudentWithhighestTotal(Student[] arr) {
        int max = -1;
        String name = "";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].totalmarkobt > max) {
                max = arr[i].totalmarkobt;
                name = arr[i].name;
            }
        }
        System.out.println(name.toUpperCase());
    }

    static ArrayList<Integer> searchStudentByPercentage(Student[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int count=0;
        for(int i=0;i<arr.length;i++){
            int percentage = arr[i].totalmarkobt/4;
            if (percentage >= 70) {
            ans.add(arr[i].id);
            count++;
           }
        }
        if(count==0)
        return null;

        Collections.sort(ans);
        return ans;
}


public static void main(String args[]) {

// Enter your code here. Read input from STDIN. Print output to STDOUT
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for(int i=0;i<n;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c= sc.nextInt();
            arr[i] = new Student(a,b,c);
        }
        System.out.println();
        
        findStudentWithhighestTotal(arr);

        ArrayList<Integer> ans = searchStudentByPercentage(arr); 
            if(ans != null) {
               for(int i=0;i<ans.size();i++){
                   System.out.println(ans.get(i));
                }
            }else{
                System.out.println("No Student found with mentioned attribute.");
            }

   }
}

