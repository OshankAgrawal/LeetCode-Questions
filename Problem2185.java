import java.util.Scanner;

public class Problem2185 {
    // Counting Words with a Given Prefix
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        obj.nextLine();
        while(t-->0){
            String input=obj.nextLine();
            String words[]=input.split(" ");
            String pref=obj.nextLine();
            Solution2185B sc=new Solution2185B();
            System.out.println(sc.prefixCount(words, pref));
            Solution2185A sca=new Solution2185A();
            System.out.println(sca.prefixCount(words,pref));
        }
        obj.close();
    }
}class Solution2185A{
    public int prefixCount(String words[],String pref){
        int ans=0;
        int len=pref.length();
        for(int i=0;i<words.length;i++){
            String str=words[i].substring(0, len);
            if(str.equals(pref)){
                ans++;
            }
        }
        return ans;
    }
}
class Solution2185B{
    public int prefixCount(String words[],String pref){
        int ans=0;
        for(String s:words){
            if(s.startsWith(pref)){
                ans++;
            }
        }
        return ans;
    }
}