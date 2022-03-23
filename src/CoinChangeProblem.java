import java.util.Arrays;

public class CoinChangeProblem {
    /**
     * Given an array of change with unlimited supply and a given sum, count the total number of ways
     * in which change can be created for given sum.
     */

    public static void main(String[] args){
        int[] arr = {1,2,5,10,20};
        int m = arr.length;
        int sum = 47;
        System.out.println(getCoinChangeCount(arr,m,sum));
        System.out.println("===COUNT WAYS===RECURSIVE===MEMOIZATION");

        int[] count = new int[sum+1];
        Arrays.fill(count,0);
        System.out.println(recursiveCountWays(arr,sum,count));

        System.out.println("===COUNT WAYS===ITERATIVE===MEMOIZATION");
        System.out.println(countWays(arr,m,sum));
    }

    private static int getCoinChangeCount(int[] arr, int m, int s) {
        if(s==0)
            return 1;
        if(s<0 ||(m<=0 && s>0))
            return 0;

        return getCoinChangeCount(arr,m-1,s) + getCoinChangeCount(arr, m, s-arr[m-1]);

    }

    //Above function is computing same problem again and again -> Overlapping Subproblems
    //Use Dynamic Programming - recomputations of same subproblems can be avoided by
    // constructing a temporary array table[][] in bottom up manner.
    //Recursive Memoize

    // TODO: 17/03/22 Memoize Using recursive code
    private static int recursiveCountWays(int[] coinsArray, int amount, int[] count){
        if(amount<0) return 0;
        if(amount==0 ) return 1;
        if(count[amount]!=0) return count[amount];
        int min = Integer.MAX_VALUE;
        for(int coin: coinsArray){
            int res = recursiveCountWays(coinsArray, amount-coin, count);
            if(res >= 0 && res < min){
                min = 1+res;
            }
        }

        count[amount] = min == Integer.MAX_VALUE ? -1 : min;

        return count[amount];
    }

    public static int countWays(int[] arr, int m,int s){
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)

        int[] table = new int[s+1];
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for(int i=0; i<m; i++){
            for (int j=arr[i]; j <=s ; j++){
                table[j] +=table[j-arr[i]];
            }
        }
        return table[s];
    }
}
