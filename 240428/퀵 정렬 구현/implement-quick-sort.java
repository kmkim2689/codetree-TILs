import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n-1);

        for(int item: arr){
            System.out.print(item + " ");
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int pos = partition(arr, low, high);

            quickSort(arr, low, pos -1);
            quickSort(arr, pos+1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int p = arr[high];

        // 먼저 오른쪽으로 가는 인덱스
        int r = low;
        // 왼쪽에서 따라가는 인덱스
        int b = low-1;

        for(int i = low; i < high; i++) {
            if(arr[i] < p) {
                b++;
                swap(arr, b, i);
            }
        }
        b++;
        swap(arr, b, high);

        return b;
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}