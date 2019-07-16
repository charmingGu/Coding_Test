package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_04_lv2 {
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;
        Queue<Integer> truck_queue = new LinkedList<Integer>();
        for (int i = 0; i < truck_weights.length; i++) {
        	int pass = 0;
        	while(pass == 0) {
        		if(bridge_weight + truck_weights[i] <= weight && truck_queue.size() < bridge_length) {
        			truck_queue.add(truck_weights[i]);
        			bridge_weight += truck_weights[i];
        			answer += 1;
        			pass = 1;
        			System.out.println(truck_queue);
        		}
        		else if(truck_queue.size() < bridge_length){
        			truck_queue.add(0);
        			answer += 1;
        			pass = 0;
        			System.out.println(truck_queue);
        		}
        		else if(truck_queue.size() >= bridge_length) {
        			bridge_weight -= truck_queue.poll();
        			pass = 0;
        			System.out.println(truck_queue);
        		}
        	}
		}
        System.out.println(truck_queue);
        return answer+bridge_length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {1,2,3,4};
		System.out.println(solution(bridge_length, weight, truck_weights));

	}

}
