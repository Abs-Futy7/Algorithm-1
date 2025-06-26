
/**
 * WineBuySell solves the "Wine Trading in Gergovia" problem using a greedy algorithm.
 * 
 * The problem involves an array where each element represents the net wine demand (positive for buy, negative for sell)
 * at each house in a row. The goal is to find the minimum total work (number of transactions times distance) required
 * to satisfy all demands, where work is defined as the amount of wine transported times the distance between buyer and seller.
 * 
 * The algorithm works by maintaining two pointers: one for buyers (positive values) and one for sellers (negative values).
 * It matches buyers and sellers greedily, always transferring as much wine as possible between the current buyer and seller,
 * and accumulates the total work done. The process continues until all demands are satisfied.
 * 
 * 
 */
class WineBuySell {
    public static void main(String[] args) {
        int[] arr = {5, -4, 1, -3, 1};
        int n = arr.length;

        System.out.println("Minimum number of transactions required: " + minTransactions(arr, n));
    }

    static int minTransactions(int[] arr, int n){
        int buy = 0;
        int sell = 0;
        int ans = 0;
        while(buy < n && sell < n){
            // Find the next buy point
            while(arr[buy] <= 0){
                buy++;
                if(buy == n) return ans; // No more buy points
            }
            while(arr[sell] >= 0){
                sell++;
                if(sell == n) return ans; // No more sell points
            }
            if(Math.abs(arr[buy]) >= Math.abs(arr[sell])){
                ans += Math.abs(buy-sell) * Math.abs(arr[sell]);
                arr[buy] += arr[sell];
                arr[sell] = 0; // Mark sell point as processed
            }
            else{
                ans += Math.abs(buy-sell) * Math.abs(arr[buy]);
                arr[sell] += arr[buy];
                arr[buy] = 0; // Mark buy point as processed
            }
        }
        return ans;
    }
}

