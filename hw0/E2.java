public class E2 {
    public static int max(int[] m){
        int current_max = m[0];
        for (int i = 0; i < m.length; i++) {
            if (current_max<=m[i]) {
                current_max = m[i];
            }
        }
        return current_max;
    }
    public static void main(String[] args) {
        int max_val;
        int[] numbers = new int[]{9,2,15,12,2,22,10,6};
        max_val = max(numbers);
        System.out.println(max_val);
    }
}