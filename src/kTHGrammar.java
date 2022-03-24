//We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous
// row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

//total numbers in nth row = 2^(n-1)
public class kTHGrammar {
    public static boolean kthGrammar(int n, int k) {
        if(n==1&&k==1) return  false;

        int mid = (int) Math.round(Math.pow(2,n-1))/2;

        if(k<=mid){
            return kthGrammar(n-1,k);
        }
        else return !kthGrammar(n-1, k-mid);

    }

    public static void main(String[] args){
        System.out.println(getKthGrammar(2,1));
    }

    private static int getKthGrammar(int i, int i1) {
        if(kthGrammar(i,i1)) return 1;
        else return 0;
    }
}
