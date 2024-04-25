import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i =0; i <n; i++){
            arr[i] = sc.nextInt();
        }

        mergeSort(0, n-1);


    }

    void mergeSort(int lowIdx, int largeIdx) {
        if(lowIdx < largeIdx) {
            int midIdx = (lowIdx + largeIdx) / 2;
            mergeSort(lowIdx, midIdx);
            mergeSort(midIdx+1, largeIdx);
            merge(lowIdx, midIdx, largeIdx);
        }
    }

    void merge(int lowIdx, int midIdx, int largeIdx) {
        ArrayList<Int> newList = new ArrayList();
        int l = lowIdx;
        int r = midIdx + 1;
        while(l <= midIdx && r <= largeIdx) {
            if(arr[l] < arr[r]) {
                newList.add(arr[l++]);
            }else {
                newList.add(arr[r++]);
            }
        }

        while(l <= midIdx) {
            newList.add(arr[l++]);
        }

        while(r <= largeIdx) {
            newList.add(arr[r++]);
        }

        int pos = lowIdx;

        for(int item: newList) {
            arr[pos] = item;
        }
    }
}