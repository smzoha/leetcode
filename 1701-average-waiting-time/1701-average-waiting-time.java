class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time = 0;
        double average = 0;

        for (int[] customer : customers) {
            time = (time > customer[0] ? time : customer[0]) + customer[1];
            average += (time - customer[0]);
        }

        return average / customers.length;
    }
}