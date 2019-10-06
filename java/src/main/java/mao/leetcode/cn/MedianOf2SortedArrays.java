package mao.leetcode.cn;

//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
//插值法，对比两个数组插入到一个长度为((m+n)/2)+1数组中
public class MedianOf2SortedArrays {
	public static void main(String[] args) {
		Solution s = new MedianOf2SortedArrays().new Solution();
		System.out.println(s.findMedianSortedArrays(new int[]{}, new int[]{1}));
	}
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int m = nums1.length;
	        int n = nums2.length;
	        
	        int mLen = (m+n)/2+1;
	        int l = 0;
	        int mNums[] = new int[mLen];
	        int mv ,nv;
	        int i=0, j=0;
	        while (l < mLen) {
	        	
	        	//nums1 shorter than nums2
	        	if (i == m) {
	        		while (l < mLen && j < n) {
	        			mNums[l] = nums2[j];
	        			l ++;
	        			j++;
	        		}
	        		break;
	        	}
	        	
	        	//nums2 shorter than nums1
	        	if (j == n) {
	        		while (l < mLen && i < m) {
	        			mNums[l] = nums1[i];
	        			l++;
	        			i++;
	        		}
	        		break;
	        	}
	        	
	        	mv = nums1[i];
	        	nv = nums2[j];
	        	if (mv <= nv) {
	        		mNums[l] = mv;
	        		if (i < m) {
	        			i++;
	        		} else {
	        			j++;
	        		}
	        		
	        	} else {
	        		mNums[l] = nv;
	        		if (j < n) {
	        			j++;
	        		} else {
	        			i++;
	        		}
	        	}
	        	l++;
	        }
	        
	        if ((m+n)%2 == 0){
	        	return ((double)mNums[mLen-1] + (double)mNums[mLen-2])/2;
	        } else {
	        	return mNums[mLen-1];
	        }
	    }
	}
}
