import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i++){
            int j = i - 1; // sorted part index
            int key = arr[i]; // 앞과 비교해서 삽입할 값

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        for(int item: arr){
            System.out.print(item + " ");
        }
    }
}