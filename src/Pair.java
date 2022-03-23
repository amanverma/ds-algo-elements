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