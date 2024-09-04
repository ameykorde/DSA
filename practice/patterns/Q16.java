/*
A
BB
CCC
DDDD
EEEEE
*/ 


package patterns;

class Q16{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        char c = 'A';
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print(c);
            }
            c++;
            System.out.println();
        }
    }
}