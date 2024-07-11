class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= n; i++) players.add(i);

        int currentPlayer = 0;

        for (int i = 0; i < n - 1; i++) {
            currentPlayer = (currentPlayer + k - 1) % players.size();
            players.remove(currentPlayer);
        }

        return players.get(0);
    }
}