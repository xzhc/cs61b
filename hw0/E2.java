public class E2 {
    public static int max(int[] m){
        int L;
        L = m.length;
        int current_max = m[0];
        int i = 0;
        int j = 0;
        while (i < L-1) {
            j = i + 1;
            while (j < L) {
                if (m[i]>=m[j]) {
                    current_max = m[i];
                }else{
                    current_max = max[j];
                }
                j = j + 1;
            }
            i = i + 1 ;
        }
        return current_max;
    }
    public static void main(String[] args) {
        int max_val;
        int[] numbers = new int[]{12,23,45,2,6};
        max_val = max(numbers);
    }
}