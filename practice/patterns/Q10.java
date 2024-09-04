/*

*
**
***
****
*****
****
***
**
*

*/ 


package patterns;

class Q10{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0; i<n-1; i++){
            for(int j=1; j<n-i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}