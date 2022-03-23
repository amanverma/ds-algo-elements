import java.nio.channels.ScatteringByteChannel;
import java.util.HashMap;

//Fibonacci numbers and Optimization
//print nth Fibonacci number
public class Fibonacci {
    public static int fib(int n) {
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args){
        //System.out.println(fib(10));
        System.out.println(getFib(10));
    }

    static HashMap<Integer, Integer> cache = new HashMap<>();
    //Optimised
    public static int getFib(int n){
        if(n<2){
            return n;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int val = fib(n-1)+fib(n-2);
        cache.put(n, val);
        return val;
    }
}
