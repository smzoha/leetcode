class Solution {
    public int passThePillow(int n, int time) {
        int round = time / (n - 1);
        int steps = time % (n - 1);

        return round % 2 == 0 ? steps + 1 : n - steps;
    }
}