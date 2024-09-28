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