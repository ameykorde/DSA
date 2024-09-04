package practice.patterns;

/*
1
22
333
4444
*/ 


public class Q4 {
    public static void main(String args[]){
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=1; i<=n; i++){
            for( int j=1; j<=i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
