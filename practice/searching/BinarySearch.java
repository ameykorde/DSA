package practice.searching;
import java.util.*;

class BinarySearch{
    public static int binarySearch(ArrayList<Integer> arr, int key){
        int low = 0;
        int high = arr.size() - 1;
        while(low<=high){
            int mid = (low + high)/2;
            if(key == arr.get(mid))
                return mid;
            if(key < arr.get(mid))
                high = mid - 1;
            if(key > arr.get(mid))
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.print("Enter no. of elements: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter elements in sorted manner: ");
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        System.out.println("Enter element to search: ");
        int key = sc.nextInt();
        int index = binarySearch(arr, key);
        if(index == -1)
            System.out.println("Element not found.");
        else
            System.out.println("Element found at index "+index);
    }
}