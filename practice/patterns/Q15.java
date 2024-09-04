/*
ABCDE
ABCD
ABC
AB
A
*/ 


package patterns;

class Q15{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=0; i<n; i++){
            char c = 'A';
            for(int j=0; j<n-i; j++){
                System.out.print(c++);
            }
            System.out.println();
        }
    }
}