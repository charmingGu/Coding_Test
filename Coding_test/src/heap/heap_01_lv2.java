package heap;
import java.util.PriorityQueue;
//프로그래머스 코딩 문제. heap 문제. 스코빌지수 문제. lv2
public class heap_01_lv2{
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        int K_value = 0;
        PriorityQueue<Integer> answers = new PriorityQueue<Integer>();
        
        for (int i : scoville) {
        	answers.add(i);
		}
        while(!answers.isEmpty()) {
        	try {
        		int temp = answers.poll();
        		if(temp < K) {
        			temp = temp+(answers.poll()*2);
        			answers.add(temp);
        			if(temp >= K) {
        				K_value += 1;
        			}
        			answer+=1;
        		}
        		System.out.println(temp);
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
        System.out.println(answers);
        if(K_value <= 0) {
        	answer = -1;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] scoville = {1, 2, 9, 3, 12, 10};
		int [] scoville = {0, 0, 0, 0, 0, 0, 0, 2, 2};
		int k = 7;
		int solve = solution(scoville, k);
		System.out.println(solve);
	}

}