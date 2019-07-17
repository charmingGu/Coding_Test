package stack_queue;

import java.util.LinkedList;
import java.util.Queue;


public class Stack_05_lv2 {
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> dayList = new LinkedList<Integer>();
        Queue<Integer> temp_answer = new LinkedList<Integer>();
        for (int i = 0; i < progresses.length; i++) {
        	int day = 0;
        	while(progresses[i] < 100) {
        		progresses[i] += speeds[i];
        		day += 1;
        	}
        	dayList.add(day);
		}
        while(!dayList.isEmpty()) {
        	int project_amount = 1;
        	int check = dayList.poll();
        	while(!dayList.isEmpty()) {
        		if(check >= dayList.peek()) {
        			project_amount += 1;
        			dayList.poll();
        		}
        		else {
        			break;
        		}
        	}
        	temp_answer.add(project_amount);
        }
        answer = new int[temp_answer.size()];
        int i = 0;
        while(!temp_answer.isEmpty()) {
        	answer[i] = temp_answer.poll();
        	System.out.println(answer[i]);
        	i += 1;
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = {30, 30, 55};
		int[] speeds = {30, 30, 5};
		System.out.println(solution(progresses, speeds));

	}

}
