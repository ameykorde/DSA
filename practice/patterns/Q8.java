/*
*********
 *******
  *****
   ***
    *
*/ 

package patterns;

class Q8{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=1; i<=n; i++){
            for(int k=1; k<i; k++){
                System.out.print(" ");
            }
            for(int j=0; j<(n*2)-(i*2-1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}