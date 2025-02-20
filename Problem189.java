import java.util.Scanner;

public class Problem189 {
    // Rotate Array
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        String str=obj.nextLine();
        int nums[]=new int[str.length()];
        for(int i=0;i<str.length();i++){
            nums[i]=Integer.parseInt(str.substring(i, i+1));
        }
        int k=obj.nextInt();
        System.out.println("Original Array");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println("\nRotated Array:-");
        Solution189 sc=new Solution189();
        sc.rotate(nums, k);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        obj.close();
    }
}
class Solution189{
    // This Solution gives us TLE
    public void rotate(int nums[],int k){
        int n=nums.length;
        k=k%n;
        while(k-->0){
            int temp=nums[n-1];
            for(int i=n-1;i>0;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=temp;
        }
    }
}
class Solution189B{
    public void rotate(int nums[],int k){
        int n=nums.length;
        k=k%n;
        int temp[]=new int[k];
        for(int i=0;i<k;i++){// Extract the 'k' element in the temp array
            temp[i]=nums[n-k+i];
        }
        for(int i=n-k-1;i>=0;i--){// Shift the remaining element
            nums[i+k]=nums[i];
        }
        for(int i=0;i<k;i++){// Copy the element from the temp array to main array
            nums[i]=temp[i];
        }
    }
}