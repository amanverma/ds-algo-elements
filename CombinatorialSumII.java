import java.util.*;

//Given a collection of candidate numbers and a target, find all unique combinations in candidates that sum to target. Each candidate number
// can only be used once
public class CombinatorialSumII {
    private static Set<List<Integer>> resultList = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0){
            return resultList.stream().toList();
        }
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<Integer>());
        return resultList.stream().toList();

    }

    private static void backtrack(int[] candidates, int start, int target, ArrayList<Integer> currentList) {
        if(target==0){
            List<Integer> listtoAdd = new ArrayList<>(currentList);
            Collections.sort(listtoAdd);
            resultList.add(listtoAdd);
            return;
        }

        for(int i = start; i < candidates.length; i ++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue; //skip duplicates
            }
            if(candidates[i]<=target){
                currentList.add(candidates[i]);
                backtrack(candidates, start+1, target-candidates[i], currentList);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    public static void main(String[] args) {

    }



}
