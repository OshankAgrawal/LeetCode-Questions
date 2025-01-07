import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class Problem1408 {
    // String Matching in an Array
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        obj.nextLine();
        while(t-->0){
            String input=obj.nextLine();
            String words[]=input.split(" ");
            Solution1408 sc=new Solution1408();
            ArrayList<String> list=new ArrayList<>();
            list=sc.stringMatching(words);
            System.out.println(list);
        }
        obj.close();
    }
}
class Solution1408{
    public ArrayList<String> stringMatching(String words[]){
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i!=j){
                    if(words[i].contains(words[j])){
                        set.add(words[j]);
                    }
                }
            }
        }
        ArrayList<String> list=new ArrayList<>(set);
        return list;
    }
}