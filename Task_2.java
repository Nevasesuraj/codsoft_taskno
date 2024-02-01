
package Internship;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sub1, sub2, sub3, sub4, sub5, sum;
        double avg;
        System.out.println("Enter marks of first subject:");
        sub1 = sc.nextInt();
        System.out.println("Enter marks of second subject:");
        sub2 = sc.nextInt();
        System.out.println("Enter marks of third subject:");
        sub3 = sc.nextInt();
        System.out.println("Enter marks of forth subject:");
        sub4 = sc.nextInt();
        System.out.println("Enter marks of fifth subject:");
        sub5 = sc.nextInt();
        sum = sub1 + sub2 + sub3 + sub4 + sub5;
        avg = sum / 5;
        System.out.println("Total marks is:" + sum);
        System.out.println("Obtained percentage is:" + avg);
        if (avg >= 80) {
            System.out.println("Distinction..");
        } else if (avg >= 60 && avg < 80) {
            System.out.println("first class..");
        } else if (avg >= 50 && avg < 60) {
            System.out.println("second class..");
        } else if (avg >= 35 && avg < 50) {
            System.out.println("Pass class..");
        } else {
            System.out.println("Fail..");
        }
    }
}
