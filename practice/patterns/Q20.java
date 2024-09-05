/*
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *
*/ 


package patterns;

class Q20{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        int k=1;
        for(int i=0; i<n-1; i++,k++){
            for(int j=0; j<n*2; j++){
                if(j<k || j>(n*2-k-1) )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n*2; j++){
                if( j>=n-i && j<n+i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}