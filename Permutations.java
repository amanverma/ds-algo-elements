import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length==0){
            return resultList;
        }
        backtrack(resultList, 0, Arrays.stream(nums).boxed().toList());
        return resultList;

    }
    public void backtrack(List<List<Integer>> resultList, int start, List<Integer> nums){
        if(start==nums.size()){
            resultList.add(new ArrayList<>(nums));
        }
        for(int i = start; i < nums.size(); i ++){
            Collections.swap(nums,start,i);
            backtrack(resultList, start+1, nums);
            Collections.swap(nums,start,i);
        }

    }
}
