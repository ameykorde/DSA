/*
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
*/ 


package patterns;

class Q9{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=1; i<=n; i++){
            for(int k=0; k< n-i; k++){
                System.out.print(" ");
            }
            for(int j=0; j<(i*2)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0; i<n-1; i++){
            for(int j=0; j<=i ; j++){
                System.out.print(" ");
            }
            for(int k=0; k<((n-1)*2 -1) - (i*2); k++){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}