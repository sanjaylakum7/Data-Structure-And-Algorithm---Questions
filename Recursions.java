public class Recursions{

    public static int fibonacci(int number){
        if(number < 3) return 1;
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    // Coins Problem
    public static int minCoins(int[] coins, int n){
        if(n == 0) return 0;
        int ans = Integer.MAX_VALUE;

        for(int index = 0; index < coins.length; index++){
            if(n - coins[index] >= 0){
                int subAns = minCoins(coins, n - coins[index]);
                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans){
                    ans = subAns + 1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] coins = {7,5,1};
        int total = 18;
        System.out.println(minCoins(coins, total));
    }
}