import java.util.HashMap;
import java.util.Scanner;

public class Problem1400 {
    // Construct K Palindrome Strings
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        while(t-->0){
            obj.nextLine();
            String str=obj.nextLine();
            int k=obj.nextInt();
            Solution1400 sc=new Solution1400();
            if(sc.canConstruct(str, k)){
                System.out.println("It is possible to construct K palindrome string using the given string.");
            }else{
                System.out.println("It is not possible to construct K palindrome string using the given string.");
            }
        }
        obj.close();
    }
}
class Solution1400{
    public boolean canConstruct(String s,int k){
        if(s.length()==k){
            return true;
        }else if(s.length()<k){
            return false;
        }else{
            HashMap<Character,Integer> map=new HashMap<>();
            for(char ch:s.toCharArray()){
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
            int oddCount=0;
            for(HashMap.Entry<Character,Integer> ele:map.entrySet()){
                if(ele.getValue()%2!=0){
                    oddCount++;
                }
            }
            if(map.size()==k){
                return true;
            }else if(oddCount==k || oddCount<k){
                return true;
            }else{
                return false;
            }
        }
    }
}