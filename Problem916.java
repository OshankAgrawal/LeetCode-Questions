import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Problem916 {
    // Word Subsets
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        String input1=obj.nextLine();
        String words1[]=input1.split(" ");
        String input2=obj.nextLine();
        String words2[]=input2.split(" ");
        Solution916 sc=new Solution916();
        ArrayList<String> list=sc.wordSubsets(words1, words2);
        System.out.println(list);
        obj.close();
    }
}
class Solution916{
    public ArrayList<String> wordSubsets(String words1[],String words2[]){
        HashMap<Character,Integer> mainMap=new HashMap<>();
        for(String s:words2){
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch)+1);
                }else{
                    map.put(ch, 1);
                }
                mainMap.put(ch, Math.max(mainMap.getOrDefault(ch,0), map.get(ch)));
            }
        }
        ArrayList<String> list=new ArrayList<>();
        for(String s:words1){
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch)+1);
                }else{
                    map.put(ch, 1);
                }
            }
            boolean flag=true;
            for(HashMap.Entry<Character,Integer> ele:mainMap.entrySet()){
                char ch1=ele.getKey();
                int freq=ele.getValue();
                if(map.getOrDefault(ch1,0)<freq){
                    flag=false;
                    break;
                }
            }
            if(flag){
                list.add(s);
            }
        }
        return list;
    }
}