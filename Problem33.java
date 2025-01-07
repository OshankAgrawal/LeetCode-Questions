import java.util.Scanner;

public class Problem33 {
    // Search in Roated Sorted Array
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        String input=obj.nextLine();
        String inputArray[]=input.split(" ");
        int nums[]=new int[inputArray.length];
        for(int i=0;i<inputArray.length;i++){
            nums[i]=Integer.parseInt(inputArray[i]);
        }
        int target=obj.nextInt();
        System.out.println(Solution33B.search(nums,target));
        obj.close();
    }
}
class Solution33A{
    // Naive Approach "Linear Searching"
    public static int search(int nums[],int target){
        int idx=-1;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                idx=i;
                break;
            }
        }
        return idx;
    }
}
class Solution33B{
    // Expected approach Binary Search Twice
    public static int search(int nums[],int target){
        int n=nums.length-1;
        int idx=findMinimumIdx(nums);
        System.out.println("IDX= "+idx);
        if(nums[idx]==target){
            return idx;
        }else if(idx==0){
            return binarySearch(nums,0,n,target);
        }else if(nums[0]<=target){
            return binarySearch(nums, 0, idx-1, target);
        }else{
            return binarySearch(nums, idx, n, target);
        }
    }
    public static int binarySearch(int nums[],int low,int high,int target){
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
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