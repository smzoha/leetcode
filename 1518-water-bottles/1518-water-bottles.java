class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int bottlesDrunk = 0, fullBottles = numBottles, emptyBottles = 0;

        while ((fullBottles + emptyBottles) >= numExchange) {
            // drink
            bottlesDrunk += fullBottles;
            emptyBottles = fullBottles + emptyBottles;

            // exchange
            fullBottles = emptyBottles / numExchange;
            emptyBottles -= fullBottles * numExchange;
        }

        return bottlesDrunk + fullBottles;
    }
}