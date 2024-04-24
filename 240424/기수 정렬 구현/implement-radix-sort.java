import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxNum = arr.max();
        int maxDigit = maxNum.toString().length(); // 4323 -> 4

        int exp = 1;

        for(int i = 0; i < maxDigit; i++){
            ArrayList<Integer>[] bucket = new ArrayList[10];
            for (int j = 0; j < 10; j++) {
                bucket[j] = new ArrayList<Integer>();
            }

            for(int item: arr){
                int idx = (item / exp) % 10;
                bucket[idx].append(item);
            }

            int idx = 0;
            for(List<Integer> b: bucket) {
                for(int item: b){
                    arr[idx++] = item;
                }
            }
        }
        for(int item: arr){
            System.out.print(item + " ");
        }
    }
}