import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int k = sc.nextInt();
    static Queue<Integer> q = new LinkedList<Integer>();
    static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        while(!q.isEmpty()) {
            for(int i = 1; i < k; i++) {
                q.add(q.poll());
            }
            result.add(q.poll());
        }

        for(int item: result) {
            System.out.print(item + " ");
        }

    }
}

/*
1 2 3 4 5 6
2 3 4 5 6 1
3 4 5 6 1 2
4 5 6 1 2 3
*/