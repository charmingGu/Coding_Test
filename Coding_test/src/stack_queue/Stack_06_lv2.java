package stack_queue;

public class Stack_06_lv2 {
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
        	int point = 0;
			if(i == prices.length-1) {
				answer[i] = point;
				break;
			}
			else {
				for (int j = i+1; j < prices.length; j++) {
					if(prices[i] <= prices[j]) {
						point += 1;
					}
					else {
						point += 1;
						break;
					}
				}
				answer[i] = point;
			}
		}
        for(int out : answer) {
        	System.out.println(out);
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,0,2,3};
		System.out.println(solution(prices));

	}

}
