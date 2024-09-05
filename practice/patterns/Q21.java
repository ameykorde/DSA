/*
*****
*   *
*   *
*   *
*****
*/ 


package patterns;

class Q21{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if((i>0 && i<n-1) && (j>0 && j<n-1) )
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}