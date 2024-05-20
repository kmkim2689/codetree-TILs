import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[] tab = new int[n + 1];

    public static void main(String[] args) {
        if(n == 2 || n == 3) {
            System.out.println(1);
            return;
        }
        tab[2] = 1;
        tab[3] = 1;

        for(int i = 4; i <= n; i++) {
            tab[i] = (tab[i-3] + tab[i-2]) % 10007;
        }
        System.out.println(tab[n]);
    }
}