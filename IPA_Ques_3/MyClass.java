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

