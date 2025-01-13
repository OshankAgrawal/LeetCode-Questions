import java.util.*;

public class Problem678{
    // Valid Paranthesis String
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        obj.nextLine();
        while(t-->0){
            String str=obj.nextLine();
            System.out.println(Solution678.valid(str));
        }
        obj.close();
    }
}
class Solution678{
    public static boolean valid(String s){
        Stack<Integer> open=new Stack<>();
        Stack<Integer> star=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open.push(i);
            }else if(s.charAt(i)=='*'){
                star.push(i);
            }else{
                if(!(open.isEmpty())){
                    open.pop();
                }else if(!(star.isEmpty())){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        while(!(open.isEmpty())){
            if(star.isEmpty()){
                return false;
            }else if(open.peek()<star.peek()){
                open.pop();
                star.pop();
            }else{
                return false;
            }
        }
        return open.isEmpty();
    }
}