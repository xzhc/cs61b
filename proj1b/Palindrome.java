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
}
