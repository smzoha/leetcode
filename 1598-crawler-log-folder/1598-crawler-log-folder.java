class Solution {
    public int minOperations(String[] logs) {
        int op = 0;

        for (String log : logs) {
            if ("./".equals(log)) continue;
            else if ("../".equals(log)) op -= op > 0 ? 1 : 0;
            else op++;
        }

        return op;
    }
}