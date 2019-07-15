package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

//프로그래머스 코딩 테스트. 스택/큐 프린터 문제. LV 2

public class Stack_03_lv2 {
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        int target = priorities[location];
        int target_position = location;
        System.out.println("target = "+target);
        Queue<Integer> print_queue = new LinkedList<Integer>();
        for (int i = 0; i < priorities.length; i++) {
			print_queue.add(priorities[i]);
		}
        
        while(true) {
        	int check = 0;
        	int num = print_queue.poll();
        	for (Integer integer : print_queue) {
				if (integer > num) {
					print_queue.add(num);
					if(target_position == 0) {
						target_position = print_queue.size()-1;
					}
					else {
						target_position -= 1;
					}
					check = 1;
					break;
				}
			}
        	if(check == 0) {
        		if(num == target && target_position == 0) {
        			return answer+=1;
        		}
        		else {
        			target_position -= 1;
        			answer+=1;
        		}
        	}
        	if(print_queue.isEmpty()) {
        		break;
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = {2, 3, 4, 5};
		int location = 0;
		System.out.println(solution(priorities, location));

	}

}
