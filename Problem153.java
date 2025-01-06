import java.util.Scanner;

public class Problem153 {
    // Find Minimum in Rotated Sorted Array
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt(); // t -> Number of test cases
        obj.nextLine();
        while(t-->0){ // More than one test cases
            String input=obj.nextLine();
            String inputArray[]=input.split(" ");
            int nums[]=new int[inputArray.length];
            for(int i=0;i<inputArray.length;i++){
                nums[i]=Integer.parseInt(inputArray[i]);
            }
            // Method 1
            System.out.print("Index of the minimum element is:- ");
            int k=Solution153A.findMinimumIdx(nums);
            System.out.println(k);
            System.out.println("Minimum element is:- "+nums[k]);
            // Method 2
            System.out.print("Index of the minimum element is:- ");
            int p=Solution153B.findMinimumIdx(nums);
            System.out.println(p);
            System.out.println("Minimum element is:- "+nums[p]);
        }
        obj.close();
    }
}
class Solution153A{
    // Naive Approach "Linear Searching"
    public static int findMinimumIdx(int nums[]){
        int idx=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(min>=nums[i]){
                min=nums[i];
                idx=i;
            }
        }
        return idx;
    }
}
class Solution153B{
    // Expected Approach "Binary Searching"
    public static int findMinimumIdx(int nums[]){
        int low=0,high=nums.length-1;
        if(low==high){
            // It means array has only one element
            return low;
        }
        while(low < high){
            if(nums[low] <nums [high]){
                // It means array is not roated
                return low;
            }
            int mid=(low+high)/2;
            if(nums[mid]>nums[high]){
                // The right half is not sorted. So 
                // the minimum element must be in the
                // right half.
                low=mid+1;
            }else{
                // The right half is sorted. Note that in 
                // this case, we do not change high to mid - 1
                // but keep it to mid. As the mid element
                // itself can be the smallest
                high=mid;
            }
        }
        return low;
    }
}