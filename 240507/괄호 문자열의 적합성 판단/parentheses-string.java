import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static char[] str = sc.next().toCharArray();
    static Stack stack = new Stack<Character>();

    public static void main(String[] args) {
        if(validBraces()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean validBraces() {
        for(char item: str) {
            if(item == '(') {
                stack.push(item);
            } else if (item == ')'){
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}