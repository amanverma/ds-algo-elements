import java.util.*;

/*Algorithm Paradigm: Backtracking

Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time \
to print a permutation.*/
public class PermutationsofString {
    //permutations = n!
    public static void  permutations(String str, int start, int end, HashSet<String> strings){
        if(!strings.contains(str)){
            if(start==end){
                System.out.println(str);
                strings.add(str);
            }else{
                for(int i=start; i<=end;i++){
                    str = swapChar(str,start,i);
                    permutations(str,start+1,end, strings);
                    str = swapChar(str, start,i);
                }
            }
        }
    }
    public static String swapChar(String str, int i, int j){
        char[] a = str.toCharArray();
        char temp = str.charAt(i);
        a[i] = a[j];
        a[j] = temp;
        return String.valueOf(a);
    }
    public static void main(String[] args){
        String str = "abc";
        permutations(str, 0, str.length()-1, new LinkedHashSet<String>());
        System.out.println("RECURSIVE");
        recursive(str,"");
    }

    public static void recursive(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
        }
        for(int i=0; i< str.length();i++){
            char c = str.charAt(i);
            String ros  = str.substring(0,i)+str.substring(i+1);
            recursive(ros,ans+c);
        }

    }
}
