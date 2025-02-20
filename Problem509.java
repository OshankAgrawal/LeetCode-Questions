import java.util.Scanner;

public class Problem509 {
    // Fibonacci Number
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int num=obj.nextInt();
        Solution509 sc=new Solution509();
        System.out.println(sc.fib(num));
        obj.close();
    }
}
class Solution509{
    public int fib(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        else{
            int num1=0,num2=1,ans=0;
            for(int i=2;i<=n;i++){
                ans=num1+num2;
                num1=num2;
                num2=ans;
            }
            return ans;
        }
    }
}