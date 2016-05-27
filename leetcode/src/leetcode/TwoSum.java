package leetcode;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] result = {0,0};
		if(nums == null || nums.length < 2)
        {
        	//
			return result;
        }
        int length = nums.length;
        for(int i = 0; i < length; i++)
        {
        	for(int j = i + 1 ; j < length ; j++)
        	{
        		if(nums[i] + nums[j] == target)
        		{
        			result[0] = i + 1;
        			result[1] = j + 1;
        			return result;
        		}
        	}
        }
        return result;
    }
}
