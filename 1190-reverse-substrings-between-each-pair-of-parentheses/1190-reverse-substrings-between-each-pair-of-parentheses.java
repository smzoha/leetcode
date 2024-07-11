class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> indexStack = new ArrayDeque<>();
        char[] buffer = new char[2001];
        int pointer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') indexStack.push(pointer);
            else if (s.charAt(i) != ')') buffer[pointer++] = s.charAt(i);
            else {
                int start = indexStack.pop(), end = pointer - 1;

                while (start < end) {
                    char tmp = buffer[start];
                    buffer[start++] = buffer[end];
                    buffer[end--] = tmp;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pointer; i++) builder.append(buffer[i]);

        return builder.toString();
    }
}