import java.util.Scanner;
import java.util.ArrayList;
public class Problem27 {
    // Remove Element
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        String input=obj.nextLine();
        String inputArray[]=input.split(" ");
        int nums[]=new int[inputArray.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(inputArray[i]);
        }
        int val=obj.nextInt();
        // Method 1
        // int k=Solution27A.removeElement(nums,val);
        // System.out.println(k);
        // for(int i=0;i<k;i++){
        //     System.out.print(nums[i]+" ");
        // }
        // System.out.println();
        // Method 2
        int p=Solution27B.removeElement(nums,val);
        System.out.println(p);
        for(int i=0;i<p;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        obj.close();
    }
}
class Solution27A{
    public static int removeElement(int nums[],int val){
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
}
class Solution27B {
    public static int removeElement(int[] nums, int val) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int num : nums){
            if(num!=val){
                list .add(num);
            }
        }
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        return list.size();
    }
}