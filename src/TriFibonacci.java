import java.util.HashMap;

/*
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.
0,1,1,2,4,7,13,24,
*/
public class TriFibonacci {
    HashMap<Integer, Integer> cache = new HashMap<>();
    TriFibonacci(){
        cache.put(0,0);
        cache.put(1,1);
        cache.put(2,1);
    }
    public int tribonacci(int n) {
        if(n<=0) return 0;
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        int val = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        cache.put(n, val);
        return val;
    }

    public static void main(String[] args){
        TriFibonacci triFibonacci = new TriFibonacci();

        System.out.println(triFibonacci.tribonacci(7));
    }
}
