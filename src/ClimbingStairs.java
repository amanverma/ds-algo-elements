/*You are climbing a staircase. It takes n steps to reach the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        1=1
        2=2
        3=3
        4= 1,1,1,1 || 2,2 || 1,1,2 || 1,2,1 ||2,1,1
        5= 1,1,1,1,1 || 1, f(4) ||
        */

import java.util.HashMap;

public class ClimbingStairs {
    static HashMap<Integer, Integer> cache = new HashMap();
    public static int climbStairs(int n) {
        if(n<=0) return 0;
        if(n==1 || n==2){
            return n;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int val =  climbStairs(n-1)+climbStairs(n-2);
        cache.put(n, val);
        return val;

    }

    public static void main(String[] args){
        System.out.println(climbStairs(10));
    }
}
