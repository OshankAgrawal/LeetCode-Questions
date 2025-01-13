import java.util.Scanner;

public class Problem2116 {
    // Check If a Parantheses String Can Be Valid
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        obj.nextLine();
        while(t-->0){
            String s=obj.nextLine();
            String lock=obj.nextLine();
            Solution sc=new Solution();
            System.out.println(sc.canBeValid(s, lock));
            Solution2116 sc1=new Solution2116();
            System.out.println(sc1.canBeValid(s, lock));
        }
        obj.close();
    }
}
class Solution2116{
    public boolean canBeValid(String s,String lock){
        int n=s.length();
        if(n%2!=0) return false;
        int open=0,close=0,card=0;
        for(int i=0;i<n;i++){
            if(lock.charAt(i)=='0'){
                card++;
            }else if(s.charAt(i)=='('){
                open++;
            }else{
                close++;
            }
            if((card+open)<close){
                return false;
            }
        }
        
        open=0;close=0;card=0;
        for(int i=n-1;i>=0;i--){
            if(lock.charAt(i)=='0'){
                card++;
            }else if(s.charAt(i)=='('){
                open++;
            }else{
                close++;
            }
            if((card+close)<open){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false; // Odd length can't be balanced
        }

        int opening = 0, closing = 0;
        int wildCard = 0;

        for (int i = 0; i < n; ++i) {
            if (locked.charAt(i) == '0') {
                wildCard++;
            } else if (s.charAt(i) == '(') {
                opening++;
            } else {
                closing++;
            }

            // Overbalanced ')' check
            if (wildCard < (closing - opening)) {
                return false;
            }
        }

        opening = closing = wildCard = 0;
        for (int i = n - 1; i >= 0; --i) { 
            if (locked.charAt(i) == '0') {
                wildCard++;
            } else if (s.charAt(i) == '(') {
                opening++;
            } else {
                closing++;
            }

            // Overbalanced '(' check
            if (wildCard < (opening - closing)) {
                return false;
            }
        }
        return true;
    }
}