import java.util.Scanner;

public class Problem125 {
    // Valid Palindrome
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        String s=obj.nextLine();
        Solution125 sc=new Solution125();
        System.out.println(sc.isPalindrome(s));
        obj.close();
    }
}
class Solution125{
    private String manipulate(String s){
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a'&& s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
    public boolean isPalindrome(String s){
        s=manipulate(s);
        System.out.println(s);
        int idx1=0;
        int idx2=s.length()-1;
        while(idx1<=idx2){
            if(s.charAt(idx1)!=s.charAt(idx2)){
                return false;
            }
            idx1++;
            idx2--;
        }
        return true;
    }
}