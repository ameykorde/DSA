/*
1      1
12    21
123  321
12344321
*/ 


package patterns;

class Q12{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=1;i<=n;i++){
            for(int k=1; k<=i; k++){
                System.out.print(k);
            }
            for(int j=0; j< (n-i)*2; j++){
                System.out.print(" ");
            }
            for(int k=i; k>0; k--){
                System.out.print(k);
            }
            System.out.println();
        }
        
    }
}