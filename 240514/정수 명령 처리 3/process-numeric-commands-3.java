import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    public static void main(String[] args) {
        for(int i = 0; i < n; i++) {
            String cmd = sc.next();
            switch(cmd) {
                case "push_front":
                    deque.addFirst(sc.nextInt());
                    break;
                case "push_back":
                    deque.addLast(sc.nextInt());
                    break;
                case "pop_front":
                    System.out.println(deque.pollFirst());
                    break;
                case "pop_back":
                    System.out.println(deque.pollLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                        System.out.println(1);
                    }else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    System.out.println(deque.peekFirst());
                    break;
                case "back":
                    System.out.println(deque.peekLast());
                    break; 
            }
        }
    }
}