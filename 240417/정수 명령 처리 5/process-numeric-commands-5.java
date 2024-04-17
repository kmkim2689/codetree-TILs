import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for(int i = 0; i <n; i++){
            String cmd = s.next().toString();

            if(cmd.equals("push_back")){
                arrList.add(s.nextInt());
            }else if(cmd.equals("pop_back")){
                arrList.remove(arrList.size() - 1);
            }else if(cmd.equals("size")){
                System.out.println(arrList.size());
            }else if(cmd.equals("get")){
                System.out.println(arrList.get(s.nextInt() - 1));
            }

        }
    }
}