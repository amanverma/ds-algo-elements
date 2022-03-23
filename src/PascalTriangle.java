import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PascalTriangle {
    public final class Pair {
        int row_;
        int col_;
        Pair(int row, int column){
            this.col_ = column;
            this.row_ = row;
        }
        @Override
        public int hashCode(){
            return row_^col_;
        }
        @Override
        public boolean equals(Object obj){
            if(this==obj) return true;
            if(obj == null || obj.getClass()!= this.getClass())
                return false;
            Pair p = (Pair)obj;
            if(row_==p.row_&&col_==p.col_){
                return true;
            }
            return false;
        }

    }
    HashMap<Pair, Integer> cache;
    PascalTriangle(){
        cache = new HashMap<>();
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascalRow = new ArrayList<>();
//        for(int i=0; i <= rowIndex; i++){
//            pascalRow.add(getPascalRow(rowIndex,i));
//        }

        //DP Solution
        for(int i=0; i <= rowIndex; i++){
            pascalRow.add(getNum(rowIndex,i));
        }


        return pascalRow;

    }

    private static Integer getPascalRow(int rowIndex, int columnIndex) {
        //recursive relation =>f(i,j) = f(i-1,j)+ f(i-1,j-1);,
        //base case
        if(rowIndex==0 || columnIndex==0 || rowIndex==columnIndex ){
            return 1;
        }
        return (getPascalRow(rowIndex-1, columnIndex)+ getPascalRow(rowIndex-1, columnIndex-1));

    }



    private int getNum(int row, int col){
        Pair pair = new Pair(row,col);
        if(cache.containsKey(pair)){
            return cache.get(pair);
        }
        int val = (row==0 || col==0 || row==col)?1: (getNum(row-1,col)+getNum(row-1,col-1));
        cache.put(pair, val);
        return val;
    }
    public static void main(String[] args){
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.getRow(4));
    }



    //Solution using Dynamic Programming and Memoization
    //DO FURTHER OPTIMIZATION AT ROW LEVEL

}


