/*
 Q.4 Create a class AutonomousCar with the below attributes:

carld – int
brand – String 
noOfTestsConducted – int
noOfTestsPassed- int
environment – String

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence except grade.

Create class Solution with main method. Implement two static methods – findTestPassedByEnv and updateCarGrade in Solution class.

findTestPassedByEnv method:
This method will take two input parameters -array of AutonomousCar objects and string parameter environment. The method will return the sum of the noOfTestsPassed attribute from autonomousCar objects for the environment passed as parameter. 
If no autonomousCar with the given environment is present in the array of AutonomousCar objects, then the method should return 0.



updateCarGrade method:
This method will take a String parameter brand, along with the array of AutonomousCar objects. The method will return the autonomousCar object, if the input String parameter matches with the brand attribute of the autonomousCar object. 
Before returning the object, the grade should be derived based on the rating calculation mentioned below. This grade value should be assigned to the object. If any of the above conditions are not met, then the method should return null. 
The grade attribute should be calculated as follows: rating .(noOfTestsPassed * 100)/noOfTestsConducted 
If the rating > = 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.

The above mentioned static methods should be called from the main method. 
For findTestPassedByEnv method – The main method should print the totalTestPassed as it is, if the returned value is greater than 0, or it should print “There are no tests passed in this particular environment”.
For updateCarGrade method – The main method should print the brand and grade of the returned autonomousCar object. 
The brand and grade should be concatinated with :: while printing. eg:- Tesla::A1, where Tesla is the brand and Al is the grade.
If the returned value is null then it should print “No Car is available with the specified brand”. 
Before calling these static methods in main, use Scanner object to read the values of four autonomousCar objects referring attributes in the above mentioned attribute sequence (except grade attribute). Next, read the value for environment and brand.




Input
----------------
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez


Output
-----------
1900
Mercedez::B2

 */

import java.util.Scanner;

class AutonomousCar{
    private int id;
    private String brand;
    private int con;
    private int pass;
    private String env;

    public AutonomousCar(int id, String brand, int con, int pass, String env)
    {
        this.id = id;
        this.brand = brand;
        this.con = con;
        this.pass = pass;
        this.env = env;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getCon() {
        return con;
    }

   
    public int getPass() {
        return pass;
    }

    public String getEnv() {
        return env;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] arr = new AutonomousCar[4];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();

            arr[i] = new AutonomousCar(a,b,c,d,e);
        }
        String en = sc.nextLine();
        String br = sc.nextLine();

        int ans1 = findTestPassedByEnv(arr,en);
        if(ans1!=0)
        {
            System.out.println(ans1);
        }
        else
        {
            System.out.println("There are no tests passed in this particular environment");
        }

        AutonomousCar obj = updateCarGrade(arr,br);
        if(obj != null){
            int rating = (obj.getPass()*100)/obj.getCon();
            String grade;
            if(rating >= 80)
            grade = "A1";
            else
            grade = "B2";
            System.out.println(obj.getBrand() + "::" + grade);
        }else{
            System.out.println("No Car is available with the specified brand");
        }
    }

    static int findTestPassedByEnv(AutonomousCar[] arr,String env){
        int ans =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getEnv().equalsIgnoreCase(env)){
                ans += arr[i].getPass();
            }
        }
        return ans;
    }

    static AutonomousCar updateCarGrade(AutonomousCar[] arr,String brand){
        for(int i=0;i<arr.length;i++){
           if(arr[i].getBrand().equalsIgnoreCase(brand)){
            return arr[i];
           }
        }
        return null;
    }
    
}
