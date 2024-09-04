/*
1
23
456
78910
*/ 


package patterns;

class Q13{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        int k=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print(k++);
            }
            System.out.println();
        }
    }
}