public class E4 {
    public static void windowPossSum(int[]a, int n){
        
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            if (a[i] > 0) {
                for (int j = i; j <= i + n; j++) {
                    if (j >= a.length) {
                        break;                        
                    }else{
                        sum = sum + a[j];
                    }
                }
                a[i] = sum;
            }else{
                continue;
            }   
            
        }
    }
    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n  = 3;
        windowPossSum(a, n);
        System.out.println(java.util.Arrays.toString(a));
    }
}
