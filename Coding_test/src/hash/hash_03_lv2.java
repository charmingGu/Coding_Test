package hash;
//프로그래머스 코딩 문제. hash lv2 문제. 위장 문제.
import java.util.HashMap;
import java.util.Map.Entry;

public class hash_03_lv2 {
	 public static int solution(String[][] clothes) {
		HashMap<String, Integer> check = new HashMap<String, Integer>();
		int answer = 1;
		for (int i = 0; i < clothes.length; i++) {
			if(check.containsKey(clothes[i][1])) {
				check.put(clothes[i][1], check.get(clothes[i][1])+1);
				continue;
			}
			check.put(clothes[i][1], 1);
		}
		System.out.println(check);
		for(Entry<String, Integer> entry : check.entrySet()) {
			answer = answer * (entry.getValue()+1);
		}
		return answer-1;
	    }
	 
	 public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"},
		{"crow_mask","face"},{"blue_hat","headgear"},{"black_watch","face"}};
		System.out.println(solution(clothes));
	}

}
