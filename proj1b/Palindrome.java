/**
 * @author 18389
 */
public class Palindrome {
    /**
     * 将一个字符串转换为一个字符的双向队列（Deque）。
     *
     * @param word 要转换的字符串
     * @return 转换后的字符双向队列
     */
    public Deque<Character> wordToDeque(String word) {
        // 创建一个字符双向队列
        Deque<Character> deque = new ArrayDeque<>();
        // 遍历字符串的每个字符
        for (int i = 0; i < word.length(); i++) {
            // 将字符添加到队列的尾部
            deque.addLast(word.charAt(i));
        }
        //返回转换后的字符双向队列
        return deque;
    }

    /**
     * 判断一个字符串是否为回文字符串。
     *
     * @param word 要判断的字符串
     * @return 如果是回文字符串则返回true，否则返回false
     */
    public boolean isPalindrome(String word) {
        // 如果字符串为空或长度为0或1，则认为是回文字符串
        if (word == null || word.length() <= 1) {
            return true;
        }
        // 遍历字符串的前半部分
        for (int i = 0; i < word.length() / 2; i++) {
            // 如果前半部分和后半部分的字符不相等，则不是回文字符串
            // 因为字符串是回文字符串，所以字符串的前半部分和后半部分的字符是相等的
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        // 如果遍历完字符串的前半部分后，没有发现不相等的字符，则认为是回文字符串
        return true;
    }

}
