/*
*****
****
***
**
*
*/ 

package patterns;

class Q5{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=0; i<n; i++){
            for(int j=n-i; j>0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}