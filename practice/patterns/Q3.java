package practice.patterns;

/*
n=4
1
1 2
1 2 3
1 2 3 4
*/ 

public class Q3 {
    public static void main(String[] args){
        System.out.println("Enter the no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
