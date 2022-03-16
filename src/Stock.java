public class Stock {
    public static int maxProfit(int[] prices) {
        int maxProfit =0;
        int j=0;
        for(int i=0; i < prices.length; i++){
            for(int k=0; k < i; k++){  //sell will only happen post buy
                if((prices[i]-prices[k] > maxProfit)){
                    maxProfit =  prices[i]-prices[k];
                }
            }
        }
        return maxProfit;
    }
    public static void main(String[] args){
        System.out.println("max profit"+ maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
