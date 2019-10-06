package mao.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class NumberDivide {
	public static void main(String[] args) {
		NumberDivide nd = new NumberDivide();
		List<List<Integer>> result = nd.numberDivide(2);
		for (List<Integer> r : result) {
			StringBuffer sb = new StringBuffer("[");
			for (int i : r) {
				sb.append(i).append(",");
			}
			sb.append("]");
			System.out.println(sb.toString());
		}
	}
	List<List<Integer>> allResult = new ArrayList<List<Integer>>();
	public List<List<Integer>> numberDivide(int n) {
		List<Integer> arrays = new ArrayList<Integer>();
		divide(n, arrays);
		return allResult;
	}
	private void divide(int n, List<Integer> result) {
		if (n == 0) {
		} else {
			result.add(n);
			List<Integer> nr = new ArrayList<Integer>();
			divide(n-1, nr);
		}
		allResult.add(result);
	}
	private int sum(List<Integer> result) {
		int sum = 0;
		for (int r : result) {
			sum += r;
		}
		return sum;
	}
}
