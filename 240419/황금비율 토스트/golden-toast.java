import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 식빵 개수
        int m = sc.nextInt(); // 암호문의 개수(커맨드 개수)

        char[] pw = sc.next().toCharArray();
        LinkedList<Character> ll = new LinkedList<Character>();
        for(int i = 0; i < n; i++){
            ll.addLast(pw[i]);
        }

        ListIterator<Character> iter = ll.listIterator(ll.size());

        for(int i = 0; i < m; i++){
            char[] cmd = sc.next().toCharArray();
            switch(cmd[0]){
                case 'L':
                    if(iter.hasPrevious()){
                        iter.previous();
                    }
                            // System.out.println(ll);

                    break;
                
                case 'R':
                    if(iter.hasNext()){
                        iter.next();
                    }
                            // System.out.println(ll);

                    break;

                case 'P':
                    char[] x = sc.next().toCharArray();
                    iter.add(x[0]);
                    // iter.next();
                            // System.out.println(ll);

                    break;

                case 'D':
                    if(iter.hasNext()){
                        iter.next();
                        iter.remove();
                    }
                    
                    // System.out.println(ll);

                    break;
                default:
                    break;
            }
        }

        for(char item : ll){
            System.out.print(item);
        }
    }
}