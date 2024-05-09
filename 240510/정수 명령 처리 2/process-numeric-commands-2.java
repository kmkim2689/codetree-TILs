import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if(cmd.equals("push")){
                int item = sc.nextInt();
                queue.add(item);
            }else if(cmd.equals("pop")){
                System.out.println(queue.poll());
            }else if(cmd.equals("size")) {
                System.out.println(queue.size());
            }else if (cmd.equals("empty")) {
                if(queue.isEmpty()) {
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if (cmd.equals("front")){
                System.out.println(queue.peek());
            }
        }

    }
}