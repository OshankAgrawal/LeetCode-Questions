import java.util.HashMap;
import java.util.Scanner;

public class Problem3223{
    // Minimum Length of String After Operation
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        obj.nextLine();
        while(t-->0){
            String str=obj.nextLine();
            Solution3223A sc=new Solution3223A();
            System.out.println(sc.minimumLength(str));
            Solution3223B scb=new Solution3223B();
            System.out.println(scb.minimumLength(str));
        }
        obj.close();
    }
}
class Solution3223A{
    public int minimumLength(String s){
        int count=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(HashMap.Entry<Character,Integer> ele:map.entrySet()){
            int x=ele.getValue();
            if (x%2!=0)
                map.put(ele.getKey(), 1);
            else
                map.put(ele.getKey(), 2);
        }
        for(HashMap.Entry<Character,Integer> ele:map.entrySet()){
            count+=ele.getValue();
        }
        return count;
    }
}
class Solution3223B{
    public int minimumLength(String s){
        int count=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(HashMap.Entry<Character,Integer> ele:map.entrySet()){
            int x=ele.getValue();
            if (x%2!=0)
                count+=1;
            else
                count+=2;
        }
        return count;
    }
}