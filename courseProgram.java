/*
 Q.1 create the class Course with the below Attributes.
courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int
The above methods should be private ,write getter and
setter and parametrized constructor as required.
create class courseProgram with main method.
implement two static methods-
findAvgOfQuizByAdmin method:
this method will take array of Course objects and a String  value as input parameters.This method will find out Average (as int) of Quiz questions
for given Course Admin (String parametre passed).This method will return Average if found.if there is no course , that matches then the method should return 0.
sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending order of their  handson which are less than the
given handson(int parameter passed) value. if there is no
such course then the method should return null.

The above mentioned static methods should be called from main methods
for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is 0 then it should print "No Course
found."
for sortCourseByHandsOn method:
the  main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."

Read all 5 input from scanner class.and also courseadmin and handson at last.

input1:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Nisha
17

output1:
35
kubernetes
Apache Spark
cassandra

 */

import java.util.*;

class Course{
    int courseid;
    String courseName;
    String courseAdmin;
    int quiz;
    int handson;

    //constructor
    Course(int courseid,String courseName,String courseAdmin,int quiz,int handson){
        this.courseid = courseid;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }

    //getter
     public int gethandson(){
        return this.handson;
     }
    //setter
}

class courseProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Course[] arr = new Course[4];

        for(int i=0;i<4;i++)
        {
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            int e = sc.nextInt();  sc.nextLine();

            arr[i] = new Course(a,b,c,d,e);
        }

        String courseadmin = sc.nextLine();
        int handson = sc.nextInt();

        int avg = findAvgOfQuizByAdmin (arr,courseadmin);
        if(avg != 0)
        {
            System.out.println(avg);
        }else{
            System.out.println("No Course found.");
        }

        Course[] ans = sortCourseByHandsOn(arr,handson);
        if(ans != null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].courseName);
            }
        }else{
            System.out.println("No Course found with mentioned attribute");
        }
    }

    static int findAvgOfQuizByAdmin(Course[] arr,String x)
    {
        int sum=0;
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].courseAdmin.equalsIgnoreCase(x)){
                sum += arr[i].quiz;
                count++;
            }
        }

        if(count > 0){
            int avg = sum/count;
            return avg;
        }

        return 0;
    }

    static Course[] sortCourseByHandsOn (Course[] arr,int h)
    {
        int count=0;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].handson < h)
            {
                count++;
            }
        }

        if(count <=0 )
        return null;

        Arrays.sort(arr,(a,b)->(a.gethandson()-b.gethandson()));

        Course[] obj = new Course[count];
          int p=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].handson < h){
                obj[p++] = arr[i];
            }
        }

        return obj;
    }
}