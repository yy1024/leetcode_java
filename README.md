###leetcode的Java解决方式
###author:littleapple

# 1.Two Sum
##Subject
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Subscribe to see which companies asked this question

##Answer
###
		public class Solution {
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

# 2.Add Two Numbers
##Subject
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Subscribe to see which companies asked this question

Show Tags
Show Similar Problems
##Answer
###
		/**
		 * Definition for singly-linked list.
		 * public class ListNode {
		 *     int val;
		 *     ListNode next;
		 *     ListNode(int x) { val = x; }
		 * }
		 */
		public class Solution {
		    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		        int carry =0;
				 
		        ListNode newHead = new ListNode(0);
		        ListNode p1 = l1, p2 = l2, p3=newHead;
		 
		        while(p1 != null || p2 != null){
		            if(p1 != null){
		                carry += p1.val;
		                p1 = p1.next;
		            }
		 
		            if(p2 != null){
		                carry += p2.val;
		                p2 = p2.next;
		            }
		 
		            p3.next = new ListNode(carry%10);
		            p3 = p3.next;
		            carry /= 10;
		        }
		 
		        if(carry==1) 
		            p3.next=new ListNode(1);
		 
		        return newHead.next;
		    }
		}

# 3.Longest Substring Without Repeating Characters
##Subject
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

Subscribe to see which companies asked this question
##Answer
###
		public class Solution {
		    public int lengthOfLongestSubstring(String s) {
		 	if(s == null || s.equals(""))
		            return 0;
		        Map<String,Integer> sets = new HashMap<String,Integer>();
		        byte[] bytes =  s.getBytes();
		        int result = 0;
		        int now = 0;
		        int remove = 0;
		        for(int i = 0; i < bytes.length ; i++)
		        {
		            if(sets.containsKey(""+bytes[i]))
		            {
		                int temp = sets.get(""+bytes[i]);
		                for(int j = remove ; j < temp; j++)
		                {
		                	sets.remove(""+bytes[j]);
		                }
		                sets.put(""+bytes[i], i);
		                now = i - temp;
		                remove = temp + 1;
		            }
		            else
		            {
		                now++;
		                if(result < now)
		                	result = now;
		                sets.put(""+bytes[i], new Integer(i));
		            }
		        }
		        return result;
		    }
		}

# x.Model Tile
##Subject
##Answer
###
