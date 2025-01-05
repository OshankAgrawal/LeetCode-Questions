import java.util.Scanner;
import java.util.ArrayList;
public class Problem26{
    // Remove Duplicates from Sorted Array
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        String input=obj.nextLine();
        String inputArray[]=input.split(" ");
        int nums[]=new int[inputArray.length];
        for(int i=0;i<inputArray.length;i++){
            nums[i]=Integer.parseInt(inputArray[i]);
        }
        // Method 1 
        int k=Solution26A.removeDuplicates(nums);
        System.out.println(k);
        for(int i=0;i<k;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        // Method 2
        int p=Solution26B.removeDuplicates(nums);
        System.out.println(p);
        for(int i=0;i<p;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        obj.close();
    }
}
class Solution26A{
    public static int removeDuplicates(int nums[]){
        int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
class Solution26B{
    public static int removeDuplicates(int nums[]){
        ArrayList<Integer> list=new ArrayList<>();
        for(int num : nums){
            if(!(list.contains(num))){
                list .add(num);
            }
        }
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        return list.size();
    }
}