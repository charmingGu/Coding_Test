package stack_queue;

import java.util.Stack;

//프로그래머스 코딩 테스트. 스택/큐 2번. 탑 문제. LV 2.
//
//1.heights 의 배열을 스택에 모두 넣는다.
//2.스택에서 pop을 하여 변수에 저장한다.
//3.스택에서 peek을 하여 변수와 비교한다.

public class Stack_02_lv2 {
	
	 public static int[] solution(int[] heights) {
		 	int heights_size = heights.length;
		 	int[] answer = new int[heights_size];
	        Stack<Integer> top_stack = new Stack<Integer>();
	        for (int i = 0; i < heights.length; i++) {
				top_stack.add(heights[i]);
			}
	        System.out.println("size = "+heights_size);
	        for (int i = 0; i < heights_size; i++) {
	        	int check = 0;
	        	check = top_stack.pop();
	        	if(!top_stack.isEmpty()) {
	        		if(top_stack.peek() > check) {
	        			answer[top_stack.size()] = top_stack.size();
	        		}
	        		else if (top_stack.peek() < check){
	        			int mark = 0;
	        			for (int j = top_stack.size()-1; j >= 0; j--) {
	        				if(heights[j] > check) {
	        					answer[top_stack.size()] = j+1;
	        					mark = 1;
	        					break;
	        				}
	        			}
	        			if(mark != 1) {
	        				answer[top_stack.size()] = 0;
	        			}
	        		}
	        	}
			}
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] heights = {6,9,5,7,4};
//		int[] heights = {3,9,9,3,5,7,2};
		int[] heights = {11,5,3,6,7,6,5};
		int[] result = solution(heights);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

}
