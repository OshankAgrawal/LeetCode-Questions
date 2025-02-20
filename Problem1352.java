import java.util.ArrayList;
class ProductOfNumbers {
    ArrayList<Integer> list=new ArrayList<>();
    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int ans=1;
        int n=list.size()-1;
        for(int i=1;i<=k;i++){
            ans=ans*list.get(n--);
        }
        return ans;
    }
}
public class Problem1352 {
    // Product of the Last K Numbers
    public static void main(String[] args) {
        ProductOfNumbers np=new ProductOfNumbers();
        np.add(3);
        np.add(0);
        np.add(2);
        np.add(5);
        np.add(4);
        System.out.println(np.getProduct(2));
        System.out.println(np.getProduct(3));
        System.out.println(np.getProduct(4));
        np.add(8);
        System.out.println(np.getProduct(2));
    } 
}
