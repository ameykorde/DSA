/*
    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA
*/ 


package patterns;

class Q17{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i;j++){
                System.out.print("_");
            }
            char c = 'A';
            for(int j=1; j<i*2; j++){
                if(i==j)
                    System.out.print(c);
                else if(j<i)
                    System.out.print(c++);
                else
                    System.out.print(--c);
            }
            System.out.println();
        }
    }
}