import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack stack = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
            String cmd = sc.next();

            switch(cmd) {
                case "push": 
                    int item = sc.nextInt();
                    stack.push(item);
                    break;
                
                case "pop":
                    System.out.println(stack.pop());
                    break;
                
                case "size":
                    System.out.println(stack.size());
                    break;
                
                case "empty":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }else {
                        System.out.println(0);
                    }
                    break;
                case "top" :
                    System.out.println(stack.peek());
                    break;
            }
        }
    }
}