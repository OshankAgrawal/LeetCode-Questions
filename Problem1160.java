import java.util.HashMap;
import java.util.Scanner;

public class Problem1160 {
    // Find Words that can be Formed by Characters
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        String input=obj.nextLine();
        String words[]=input.split(",");
        String chars=obj.nextLine();
        Solution1160 sc=new Solution1160();
        System.out.println(sc.countCharacters(words, chars));
        obj.close();
    }
}
class Solution1160{
    public int countCharacters(String[] words, String chars) {
        int length=0;
        HashMap<Character,Integer> mainMap=new HashMap<>();
        for(char ch:chars.toCharArray()){
            mainMap.put(ch, mainMap.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<words.length;i++){
            HashMap<Character,Integer> Map=new HashMap<>();
            for(char ch:words[i].toCharArray()){
                Map.put(ch, Map.getOrDefault(ch, 0)+1);
            }
            if(isSubMap(mainMap,Map)){
                length=length+words[i].length();
            }
        }
        return length;
    }
    public boolean isSubMap(HashMap<Character,Integer> mainMap,HashMap<Character,Integer> subMap){
        for(HashMap.Entry<Character,Integer> ele:subMap.entrySet()){
            char ch=ele.getKey();
            Integer value=ele.getValue();
            // Check that the mainMap contains the key
            if(!(mainMap.containsKey(ch))) return false;
            // Check that mainMap's value is greater than or equal to subMap's value
            Integer mainValue=mainMap.get(ch);
            if(mainValue<value) return false;
        }
        return true;
    }
}