import java.util.Scanner;

public class Problem1769 {
    // Minimum Number of Operation to Move All Balls to Each Box
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        String boxes=obj.nextLine();
        int answer[]=new int[boxes.length()];
        Solution1769 sc=new Solution1769();
        answer=sc.minOperations(boxes);
        for(int i=0;i<boxes.length();i++){
            System.out.print(answer[i]+" ");
        }
        obj.close();
    }
}
class Solution1769{
    public int[] minOperations(String boxes){
        int n=boxes.length();
        int answer[]=new int[n];
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(boxes.charAt(j)=='1'){
                        count += Math.abs(i-j);
                    }
                }
            }
            answer[i]=count;
        }
        return answer;
    }
}