/*
E
DE
CDE
BCDE
ABCDE
*/ 


package patterns;

class Q18{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
            char c = (char)('A'+n);
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print(c++);
            }
            c--;
            System.out.println();
        }
    }
}