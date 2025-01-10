import java.util.Scanner;

public class Problem7 {
    // Reverse Integer
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int x=obj.nextInt();
        Solution7 sc=new Solution7();
        System.out.println(sc.reverse(x));
        obj.close();
    }
}
class Solution7{
    public int reverse(int x){
        int revNum=0,rem=0;
        while(x!=0){
            rem=x%10;
            x /=10;
            // Check for overflow before multiplying
            if (revNum > Integer.MAX_VALUE / 10 || (revNum == Integer.MAX_VALUE / 10 && rem > 7)) {
                return 0; // Overflow for positive numbers
            }else if (revNum < Integer.MIN_VALUE / 10 || (revNum == Integer.MIN_VALUE / 10 && rem < -8)) {
                return 0; // Overflow for negative numbers
            }
            revNum=(revNum*10)+rem;
        }
        return revNum;
    }
}