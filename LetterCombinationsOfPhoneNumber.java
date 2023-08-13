import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Whenever you have a problem where you need to generate all combinations/permutations of some group of letters/numbers,
// the first thought you should have is backtracking
public class LetterCombinationsOfPhoneNumber {
    static Map<Character, String> map = new HashMap<>();
    static{
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if(digits.length()==0){
            return output;
        }
        backtrack(digits, 0, new StringBuilder(), output);
        return output;

    }

    private void backtrack(String digits, int index, StringBuilder currentString, List<String> output) {
        if(currentString.length()==digits.length()){
            output.add(currentString.toString());
        }
        String letters = map.get(digits.charAt(index));
        for(char c : letters.toCharArray()){
            currentString.append(c);
            backtrack(digits, index+1, currentString,output);
            currentString.deleteCharAt(currentString.length()-1);
        }
    }
}
