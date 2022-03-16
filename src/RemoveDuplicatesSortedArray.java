public class RemoveDuplicatesSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return nums.length;
        }
        int n = nums.length;
        int j = 0;
        for(int i=0; i< n ; i++){
            if((i<n-1)&&(nums[i]==nums[i+1])) {
                continue;
            }
            nums[j++] = nums[i];
        }
        return j;
    }
    public static void main(String[] args){
        //int[] nums = new int[]{1,1,1,2};
        int[] nums = new int[]{1, 2,2,2,2,2,2,2, 3, 4, 4, 5, 6, 6, 7};
        int k = removeDuplicates(nums);
        System.out.println("unique "+k);
        for(int i = 0; i <k; i++){
            System.out.println(nums[i]);
        }
    }
}
