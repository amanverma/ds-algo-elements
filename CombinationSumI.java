
import java.util.*;

//Combination of candidates sum to target, each numnber can be used any number of times
// Combinations must be unique
public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> resultSet = new HashSet<>();
        if(candidates.length==0){
            return resultSet.stream().toList();
        }
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), resultSet );
        return resultSet.stream().toList();

    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> currentList, Set<List<Integer>> resultSet) {
        if(target==0){
            resultSet.add(new ArrayList<>(currentList));
            return;
        } else if(target < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i ++){
            currentList.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], currentList, resultSet);
            currentList.remove(currentList.size()-1);
        }
    }
}
