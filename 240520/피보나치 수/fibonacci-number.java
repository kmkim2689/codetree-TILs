import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[] tabDp = new int[n + 1]; 

    public static void main(String[] args) {
        if(n == 1) {
            System.out.println(1);
            return;
        }

        tabDp[1] = 1;
        for(int i = 2; i <= n; i++) {
            tabDp[i] = tabDp[i-2] + tabDp[i-1];
        }
        System.out.println(tabDp[n]);
    }
}