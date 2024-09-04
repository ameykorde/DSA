/*
1
01
101
0101
10101
*/ 


package patterns;

class Q11{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        int i=1;
        while(i<=n){
            int j = (i%2==0) ? 0 : 1;
            for(int k=0; k<i;k++){
                System.out.print(j);
                j = (j==0) ? 1 : 0;
            }
            i++;
            System.out.println();
        }
    }
}