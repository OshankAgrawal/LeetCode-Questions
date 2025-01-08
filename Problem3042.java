import java.util.Scanner;

public class Problem3042 {
    // Count Prefix and Suffix Pairs I
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        obj.nextLine();
        while(t-->0){
            String input=obj.nextLine();
            String words[]=input.split(" ");
            Solution3042 sc=new Solution3042();
            System.out.println(sc.countPrefixSuffixPairs(words));
        }
        obj.close();
    }
}
class Solution3042{
    public int countPrefixSuffixPairs(String[] words) {
        int ans=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i],words[j])){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean isPrefixAndSuffix(String s1,String s2){
        int len1=s1.length();
        int len2=s2.length();
        if(len2<len1){
            return false;
        }else if(len1==len2){
            if(s1.equals(s2)){
                return true;
            }else{
                return false;
            }
        }
        String t1=s2.substring(0, len1);
        String t2=s2.substring(len2-len1);
        if(t1.equals(t2) && t1.equals(s1)){
            return true;
        }else{
            return false;
        }
    }
    // Method 2
    // boolean isPrefixAndSuffix(String s1, String s2) {
    //     return s2.startsWith(s1) && s2.endsWith(s1);
    // }
    /*
     * In this solution i am using the in-build function
     * to check the string's prefix & suffix,
     * which reduce the run time from 4ms to 2ms.
     */
}