import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[] tab = new int[n+1];

    public static void main(String[] args) {
        if(n == 1) {
            System.out.println(1);
            return;
        }

        if(n == 2) {
            System.out.println(2);
            return;
        }

        tab[1] = 1;
        tab[2] = 2;

        for(int i = 3; i <= n; i++) {
            tab[i] = (tab[i-2] + tab[i-1]) % 10007;
        }
        System.out.println(tab[n]);
    }
}