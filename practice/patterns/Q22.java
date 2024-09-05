/*
n=4
4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4
*/ 


package patterns;

class Q22{
    public static void main(String... args) {
        System.out.println("Enter no. of lines: ");
        int n = Integer.parseInt(System.console().readLine());
        for(int i=n; i>0; i--){
            int k=n;;
            for(int j=n; j>0; j--){
                if(k!=j && k!=i)
                    k--;
                System.out.print(k + " ");
            }
            for(int j=1; j<n; j++){
                if(j>=i)
                    k++;
                System.out.print(k + " ");
            }
            System.out.println();
        }
        for(int i=2; i<n+1; i++){
            int k=n;
            for(int j=n; j>0; j--){
                if(k!=j && k!=i)
                    k--;
                System.out.print(k + " ");
            }
            for(int j=1; j<n; j++){
                if(j>=i)
                    k++;
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}