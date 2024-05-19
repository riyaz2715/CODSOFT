import java.util.*;
public class studentgradecalculator
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of subjects:");
        int numsubjects=sc.nextInt();
        int totalmarks=0;
        for(int i=1;i<=numsubjects;i++)
        {
            System.out.println("enter the marks in subject "+i +" :");
            int marks=sc.nextInt();
            totalmarks+=marks;
        }
        double avgpercentage=(double) totalmarks/numsubjects;
        char grade;
        if(avgpercentage >= 90)
        {
            grade = 'A';
        }
        else if(avgpercentage >= 80)
        {
            grade = 'B';
        }
        else if(avgpercentage >= 70)
        {
            grade = 'C';
        }
        else if(avgpercentage >= 60)
        {
            grade = 'D';
        }
        else if(avgpercentage >= 50)
        {
            grade = 'E';
        }
        else{
            grade = 'F';
        }
        System.out.println("total marks:"+ totalmarks);
        System.out.println("average percentage "+ avgpercentage + "%");
        System.out.println("Grade : " +grade);
    }

}