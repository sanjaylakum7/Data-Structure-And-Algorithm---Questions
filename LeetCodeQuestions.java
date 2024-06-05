import java.util.*;

public class LeetCodeQuestions {
    public static int findNonMinOrMax(int[] nums) {
        if (nums.length < 3)
            return -1;
        int max = 0, min = Integer.MAX_VALUE;

        for (int index = 0; index < nums.length; index++) {
            if (max < nums[index])
                max = nums[index];
            if (min > nums[index])
                min = nums[index];
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != max && nums[index] != min)
                return nums[index];
        }
        return -1;
    }

    // ? I will Solve it at 5 pm
    public static int sumOfUnique(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int sumOfUnique = 0;

        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(nums[index]))
                map.put(nums[index], true);
            else
                map.put(nums[index], false);
        }

        for (int index = 0; index < nums.length; index++) {
            if (map.get(nums[index]) != true)
                sumOfUnique += nums[index];
        }

        return sumOfUnique;
    }

    private static int[] findMaxMinExcluding(int[] nums, int upper, int lower) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean ignoreMax = true, ignoreMin = true;

        for (int n : nums) {
            if (n == upper && ignoreMin) {
                ignoreMin = false;
                continue;
            }
            if (n == lower && ignoreMax) {
                ignoreMax = false;
                continue;
            }
            if (n < min)
                min = n;
            if (n > max)
                max = n;
        }
        return new int[] { max, min };
    }

    // ! 1913. Maximum Product Difference Between Two Pairs
    public static int maxProductDifference(int[] nums) {
        // ? -> its my own solution
        // Arrays.sort(nums);
        // return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
        // ? -> its Other solution
        int[] first = findMaxMinExcluding(nums, Integer.MAX_VALUE, Integer.MAX_VALUE);
        int[] second = findMaxMinExcluding(nums, first[0], first[1]);
        return first[0] * second[0] - first[1] * second[1];
    }

    public static int vowelStrings(String[] words, int left, int right) {
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int temp = 0;
        for (int index = left; index <= right; index++)
            if (vowels.contains(words[index].charAt(0))
                    && vowels.contains(words[index].charAt(words[index].length() - 1)))
                temp++;
        return temp;
    }

    public static int findMaxK(int[] nums) {
        ArrayList<Integer> pastOfNumbers = new ArrayList<>();
        int maxNumber = 0;

        for (int index = 0; index < nums.length; index++) {
            int current = Math.abs(nums[index]);
            if (pastOfNumbers.contains(nums[current]) && maxNumber < current) {
                maxNumber = current;
            } else {
                pastOfNumbers.add(current);
            }
        }
        return maxNumber;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ? I have to resolve the quetion cause the solution using high space.
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] blockSum = new int[mat.length][mat[0].length];
        matrixBlock(mat, blockSum, k, 0, 0);
        return blockSum;
    }

    private static void matrixBlock(int[][] mat, int[][] blockSum, int k, int row, int col) {
        if (row < 0 || col < 0 || row > mat.length - 1 || col > mat[row].length - 1 || blockSum[row][col] != 0)
            return;

        int rowStart = row - k, rowEnd = row + k, colStart = col - k, colEnd = col + k, sumBlock = 0;

        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (i >= 0 && j >= 0 && i <= mat.length - 1 && j <= mat[i].length - 1) {
                    sumBlock += mat[i][j];
                }
            }
        }
        blockSum[row][col] = sumBlock;
        matrixBlock(mat, blockSum, k, row, col + 1);
        matrixBlock(mat, blockSum, k, row + 1, col);
        matrixBlock(mat, blockSum, k, row, col - 1);
        matrixBlock(mat, blockSum, k, row - 1, col);
    }

    // ? 2482. Difference Between Ones and Zeros in Row and Column -> There is math
    // issue only
    public static int[][] onesMinusZeros(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int values = grid[i][j];
                rows[i] += values;
                cols[j] += values;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int m = grid.length - 1, n = grid[i].length - 1;
                grid[i][j] = (rows[i] + cols[j]) - (m - rows[i] - n - cols[j]);
            }
        }
        return grid;
    }

    private static int maxProfit(int[] price) {
        return solve(0, 1, price);
    }

    // ! 122. Best Time to Buy and Sell Stock II
    public static int solve(int index, int buy, int[] prices) {
        if (index == prices.length) {
            return 0;
        }
        int profit = 0;

        if (buy == 1) {
            int Buy = -prices[index] + solve(index + 1, 0, prices);
            int skip = 0 + solve(index + 1, 1, prices);
            profit = Math.max(Buy, skip);
        } else {
            int sell = prices[index] + solve(index + 1, 1, prices);
            int skip = 0 + solve(index + 1, 0, prices);
            profit = Math.max(sell, skip);
        }
        return profit;
    }

    // ! 122. Best Time to Buy and Sell Stock II
    public static int solveTab(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            int profit = 0;
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int Buy = -prices[index] + dp[index + 1][0];
                    int skip = 0 + dp[index + 1][1];
                    profit = Math.max(Buy, skip);
                } else {
                    int sell = prices[index] + dp[index + 1][1];
                    int skip = 0 + dp[index + 1][0];
                    profit = Math.max(sell, skip);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(sum < 0) sum = 0;
            sum = sum + nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }   

    public int[] productExceptSelf(int[] nums) {
        
    }
    public static void main(String[] args) {
        
    }
}