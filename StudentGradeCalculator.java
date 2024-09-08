//------------------------------TASK 2------------------------------

import java.util.Scanner;

public class StudentGradeCalculator{
    public static String calculateGrade(double percentage){
        if(percentage >=90){
            return "Grade A";}
        else if(percentage >=80){
            return "Grade B";} 
        else if(percentage >=70){
            return "Grade C";}
        else if(percentage >=60){
            return "Grade D";}
        else{
            return "Grade F";}
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Subjects :");
        int numberOfSub = sc.nextInt();
        int [] marks = new int[numberOfSub];
        int totalMarks = 0;
        for (int i = 0 ;i<numberOfSub;i++){
            System.out.println("Enter number of Subjects"+ (i+1)+"(out of 100)");
            marks[i] = sc.nextInt();
            if(marks[i]<0||marks[i]>100){
                System.out.println("Invalid marks entered.Please enter no. between 1 to 100");
                i--;
            }else{
                totalMarks+=marks[i];
            }
        }
        double averagePercentage = (double)totalMarks/numberOfSub;
        String grade = calculateGrade(averagePercentage);
        System.out.println("\n-----Results------");
        System.out.println("Total Marks :"+ totalMarks);
        System.out.println("Average Percentage :"+averagePercentage+"%");
        System.out.println("Grade : " + grade);
        sc.close();
        }
    }
