import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(); // 6
    static int[] arr = new int[n+1];
    
    public static void main(String[] args) {
        for(int i =1; i<=n; i++){
            arr[i] = sc.nextInt(); // 5 2 6 1 3 8
        }

        heapSort(n/2);

        show();
    }

    static void heapSort(int pos){
        // make maxHeap
        for(int i = pos; i >= 1; i--) {
            heapify(i, n);
        }

        // sort
        for(int i = n; i >= 2; i--) {
            swap(1, i);
            heapify(1, i-1);
        }

    }

    static void heapify(int pos, int size) {
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
            swap(pos, maxIdx);
            heapify(maxIdx, size);
        }
    }

    static void swap(int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void show() {
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}