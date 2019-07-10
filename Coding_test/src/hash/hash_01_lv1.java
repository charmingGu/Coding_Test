package hash;

import java.util.HashMap;
import java.util.Map.Entry;
//프로그래머스 코딩 문제. hash 활용 lv1 마라톤 문제.

public class hash_01_lv1 {
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> mb_check = new HashMap<String, Integer>();
        
        for (String string : participant) {
        	if(mb_check.containsKey(string)) {
        		mb_check.put(string, mb_check.get(string)+1);
        	}
        	else {
        		mb_check.put(string, 0);
        	}
		}
        for (String string : completion) {
			mb_check.put(string, mb_check.get(string)-1);
		}
        
        for(Entry<String, Integer> entry : mb_check.entrySet()){
        	if(entry.getValue()>=0) {
        		answer = entry.getKey();
        		return answer;
        	}
        }
        System.out.println(mb_check);
    	return answer;
    }
	
	public static void main(String[] args) {
		String[] participant = {"kiki", "kiki", "eden", "kiki"};
		String[] completion = {"kiki", "eden"};
		System.out.println(solution(participant, completion));
	}
}
