public class StockBuySell {
    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        int n = prices.length;
        System.out.println("Maximum profit from stock buy and sell: " + maxProfit(prices, n));
    }

    static int maxProfit(int[] prices, int n) {
        int res = 0;

        int minPrice = prices[0];

        for(int i = 1 ; i < n ; i++){
            // If the current price is less than the minimum price seen so far, update minPrice
            minPrice = Math.min(minPrice, prices[i]);
            res = Math.max(res, prices[i] - minPrice); // Calculate profit if we sell at current price
        }
        return res;
    }
}
