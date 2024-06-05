import java.util.*;

public class JavaScript{   
    public static int[] twoSum(int[] nums, int target) {    
        Hashtable<Integer, Integer> table = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= target){
                if(table.containsKey(target - nums[i])){
                    if(target - nums[i] + nums[i] == target) return new int[]{table.get(target - nums[i]), i};
                }else{
                    table.put(nums[i], i);
                }
            }
        }
        return new int[]{-1, -1};
    }   

    public static void main(String[] args) {
        
    }
}