import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

    public static void main(String[] args) {
        for(int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        operation();
        System.out.println(deque.pollFirst());
    }

    static void operation(){
        while(deque.size() > 1) {
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }
    }

}