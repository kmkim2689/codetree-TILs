import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for (int i = 0; i < n; i++){
            String cmd = sc.next().toString();

            switch(cmd){
                case "push_front": 
                    int x = sc.nextInt();
                    linkedList.addFirst(x);
                    break;

                case "push_back":
                    int y = sc.nextInt();
                    linkedList.addLast(y);
                    break;
            
                case "pop_front": 
                    System.out.println(linkedList.pollFirst());
                    break;

                case "pop_back": 
                    System.out.println(linkedList.pollLast());
                    break;

                case "size": 
                    System.out.println(linkedList.size());
                    break;

                case "empty":
                    if(linkedList.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                

                case "front": 
                    System.out.println(linkedList.get(0));
                    break;

                case "back": 
                    System.out.println(linkedList.get(linkedList.size()-1));
                    break;

                default:
                    break;
            }
        }


    }
}