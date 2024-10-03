/*
 Q.3 Create a class called Employee with the below attributes:

employeeld - int
name - String
branch - String
rating - double
company Transport - boolean
The above attributes should be private. write getters, setters and parameterized constructor as required.

Create class MyClass with main method.
Implement two static methods findCountOfEmployeesUsingCompTransport and findEmployeeWithSecondHighestRating in MyClass class.

findCountOfEmployeesUsingCompTransport method: 
----------------------------------------------
This method will take an array of Employee object and a String parameter as input parameters. 
This method will calculate and return the count of Employees who are all using company transport in the given branch (String parameter passed).
If no Employee in the given branch using company transport in the array of Employee objects, then the method should return 0.


findEmployeeWithSecondHighestRating method: 
--------------------------------------------
This method will take an array of Employee objects as an input parameter. This method will return the object of the second highest rating employee from the array of Employee objects who are not using company transport.
If all Employees using company transport in the array of Employee objects, then the method should return null.

Note: All the searches should be case sensitive, companyTransport and rating combination of each Employee is unique.
For findCountOfEmployeesUsingCompTransport method, The main method should print the returned count as it is if the returned value is greater than 0, else it should print "No such Employees".
Ex: 2 , where 2 is the count
For findEmployeeWithSecondHighestRating method: The main method should print the employeeld and name from the returned object if the returned value is not null. If the returned value is null, then it should print "All Employees using company transport".
Ex: 1003
    Uma
where 1003 is the employeeld and Uma is the name.
Before calling these static methods in main, use Scanner object to read the values of four Employee objects referring attributes in the above mentioned attributes sequence. Next, read the value of String parameter for capturing branch.





Input : 
1001
Ashwa
IT
5
true
1002
Preeti
IT
4
true
1003
Uma
Admin
3
false
1004
Akash
Hardware
4.5
false
IT
Output : 
2
1003
Uma

 */

import java.util.Scanner;
class Employee{
    int empId;
    String name;
    String branch;
    double rating;
    boolean comp_transport;

    Employee(int empId,String name,String branch,double rating,boolean comp_transport){
        this.empId = empId;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.comp_transport = comp_transport;
    }

    double getRating(){
        return this.rating;
    }
}

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] emp = new Employee[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            boolean e = sc.nextBoolean();

            emp[i] = new Employee(a, b, c, d, e);
        }
        sc.nextLine();
        String branch = sc.nextLine();

        int empCount = findCountOfEmployeesUsingCompTransport(emp,branch);
        if(empCount > 0){
            System.out.println(empCount);
        }else{
            System.out.println("No such Employees");
        }

        Employee ans = findEmployeeWithSecondHighestRating(emp);
        if(ans != null){
            System.out.println(ans.empId + "\n" + ans.name);
        }else{
            System.out.println("All Employees using company transport");
        }
    }

    static int findCountOfEmployeesUsingCompTransport(Employee[] arr,String branch){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].comp_transport){
                if(arr[i].branch.equalsIgnoreCase(branch)){
                    count++;
                }
            }
        }
        return count;
    }

    static Employee findEmployeeWithSecondHighestRating(Employee[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(!arr[i].comp_transport){
                count++;
            }
        }

        if(count ==0 || count == 1){
            return null;
        }

        //sort arr obj 
        Employee temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].getRating() > arr[j].getRating())
                {
                    //swap
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        Employee[] obj = new Employee[count];
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(!arr[i].comp_transport){
                obj[idx++] = arr[i];
            }
        }

       return obj[count-2];
    }
}

