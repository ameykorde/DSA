package practice.patterns;
import java.util.*;
/*

n=4
****
****
****
****

 */
public class Q1 {

    public static void main(String[] args) {
        System.out.println("Enter no. of lines: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}