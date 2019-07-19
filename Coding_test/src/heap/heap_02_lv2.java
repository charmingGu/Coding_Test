package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class heap_02_lv2 {
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int index = 0;
        PriorityQueue<Integer> sup_plus = new PriorityQueue<>(Comparator.reverseOrder());
 
        try {
        	for (int i = 0; i < k; i++) {
        		if(index < dates.length && i == dates[index]) {
        			sup_plus.add(supplies[index]);
        			index += 1;
        		}
        		
        		if(stock == 0) {
        			stock += sup_plus.poll();
        			answer += 1;
        		}
        		stock -= 1;
        	}
		} catch (Exception e) {
			// TODO: handle exception
		}
        return answer;
        
// 풀어지긴 하나 효율성 검사에서 실패가 나버림. while, for 가 너무 사용됐나봄. 아쉬움..
//        int answer = 0;
//        List<Integer> sup_data = new ArrayList<Integer>();
//    	for (int i = 0; i < supplies.length; i++) {
//			sup_data.add(supplies[i]);
//		}
//    	Collections.sort(sup_data);
//    	Collections.reverse(sup_data);
//    	while(stock < k) {
//    		int check = 0;
//    		for (Integer sup : sup_data) {
//    			if(!(stock < k)) {
//    				break;
//    			}
//    			for(int i = supplies.length-1; i >= 0; i--) {
//    				if(sup == supplies[i] && (stock-dates[i]) >= 0 && dates[i] != 0) {
//    					answer += 1;
//    					stock += sup;
//    					dates[i] = 0;
//    					check = 1;
//    					break;
//    				}
//    			}
//    			if(check == 1) {
//    				break;
//    			}
//    		}
//    	}
//        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stock = 4;
		int[] dates = {1, 3, 5, 7};
		int[] supplies = {60, 4, 5, 30};
		int k = 100;
		System.out.println(solution(stock, dates, supplies, k));

	}

}
