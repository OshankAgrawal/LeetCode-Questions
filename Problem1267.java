import java.util.Scanner;

public class Problem1267 {
    // Count Servers that Communicate
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        obj.nextLine();
        while(t-->0){
            int row=obj.nextInt();
            int col=obj.nextInt();
            int mat[][]=new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    mat[i][j]=obj.nextInt();
                }
            }
            Solution1267 sc=new Solution1267();
            System.out.println(sc.countServer(mat));
        }
        obj.close();
    }
}
class Solution1267{
    public int countServer(int mat[][]){
        int row=mat.length;
        int col=mat[0].length;
        int rowCount[]=new int[row];
        int colCount[]=new int[col];
        int totalServer=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    rowCount[i]++;
                    colCount[j]++;
                    totalServer++;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    if(!(rowCount[i]>1 || colCount[j]>1)){
                        totalServer--;
                    }
                }
            }
        }
        return totalServer;
    }
}