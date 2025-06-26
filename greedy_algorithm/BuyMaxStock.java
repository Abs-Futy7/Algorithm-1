// Algo: 
// 1. Read the number of stock prices and their values.
// 2. Read the available money.
// 3. Create an array of `Stock` objects, each containing the price and the day (1-based index).
// 4. Sort the stocks by price in ascending order.
// 5. Iterate through the sorted stocks:
//    - If the available money can buy all stocks of that price, buy them.
//    - If not, buy as many as possible with the remaining money.
// 6. Return the total number of stocks bought.



import java.util.Arrays;
import java.util.Scanner;

public class BuyMaxStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0 ; i < n ; i++){
            prices[i] = sc.nextInt();
        }
        int money = sc.nextInt();
        System.out.println("Maximum stocks that can be bought: " + maxStocks(prices, n, money));
        sc.close();
    }

    static int maxStocks(int[] prices, int n, int money){
        Stock[] stockArr = new Stock[n];
        int stocks = 0;
        for(int i = 0; i < n ; i++){
            stockArr[i] = new Stock(prices[i], i + 1);
        }
        Arrays.sort(stockArr, (a,b) -> Integer.compare(a.price, b.price));
        
        for(int i = 0; i < n ; i++){
            if(money >= stockArr[i].price * stockArr[i].day){
                stocks += stockArr[i].day;
                money -= (stockArr[i].day * stockArr[i].price);
            }
            else{
                int maxStocksToday = money / stockArr[i].price;
                stocks += maxStocksToday;
                money -= (maxStocksToday * stockArr[i].price);
            }
        }
        return stocks;
    }

    static class Stock{
        int price;
        int day;
        Stock(int price, int day){
            this.price = price;
            this.day = day;
        }
    }
}

