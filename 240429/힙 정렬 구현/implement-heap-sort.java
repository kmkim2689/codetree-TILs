import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(); // 6
    public static void main(String[] args) {
        int[] arr = new int[n+1];
        for(int i =1; i<=n; i++){
            arr[i] = sc.nextInt(); // 5 2 6 1 3 8
        }

        heapSort(arr, n/2);

        show(arr);
    }

    static void heapSort(int[] arr, int pos){
        // make maxHeap
        for(int i = pos; i >= 1; i--) {
            heapify(arr, i, n);
        }

        // sort
        for(int i = n; i >= 2; i--) {
            swap(arr, 1, i);
            heapify(arr, 1, i-1);
        }

    }

    static void heapify(int[] arr, int pos, int size) {
        int maxIdx = pos;
        int lIdx = pos * 2;
        int rIdx = pos * 2 + 1;

        if(size >= lIdx && arr[lIdx] > arr[maxIdx] ) {
            maxIdx = lIdx;
        }
        
        if(size >= rIdx && arr[rIdx] > arr[maxIdx] ) {
            maxIdx = rIdx;
        }

        if(maxIdx != pos) {
            swap(arr, pos, maxIdx);
            heapify(arr, maxIdx, size);
        }
    }

    static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void show(int[] arr) {
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}