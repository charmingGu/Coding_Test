package hash;
//프로그래머스 코딩 문제. hash lv3 문제. 베스트앨범.
//어떻게? 1. 일단 해쉬에 누적하면서 넣음 -> 각 장르별 누적 합계가 구해짐.
//2. 누적 합계를 바탕으로 장르의 출력 순서를 정함
//3. 장르의 출력 순서가 정해지면 장르 안에서 내림차순으로 출력

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class hash_04_lv3 {
	
	public static int[] solution(String[] genres, int[] plays) {
		Integer[] pre_answer = {};
        int[] answer = {};
        HashMap<String, Integer> sum_gen = new HashMap<String, Integer>();
        for (int i = 0; i < genres.length; i++) {
        	if(sum_gen.containsKey(genres[i])) {
        		sum_gen.put(genres[i], (sum_gen.get(genres[i]))+plays[i]);
        	}
        	else {
        		sum_gen.put(genres[i], plays[i]);
        	}
		}
        String[] temp_test = sort_gen(sum_gen);
        pre_answer = get_song(temp_test, genres, plays);
        answer = Arrays.stream(pre_answer).mapToInt(Integer::intValue).toArray();
        return answer;
    }
	public static String[] sort_gen(HashMap<String, Integer> sum_gen) {
		HashMap<String, Integer> gen_temp = new HashMap<String, Integer>();
        gen_temp.putAll(sum_gen);
        ArrayList<String> sort_genres = new ArrayList<String>();
        	for(Entry<String, Integer> entry : sum_gen.entrySet()) {
        		String max_gen = "";
        		for(Entry<String, Integer> entry2 : gen_temp.entrySet()) {
        			if(sum_gen.containsKey(max_gen)) {
        				if(entry2.getValue() > sum_gen.get(max_gen)) {
        					max_gen = entry2.getKey();
        				}
        			}
        			else {
        				max_gen = entry2.getKey();
        			}
        		}
        		sort_genres.add(max_gen);
        		gen_temp.remove(max_gen);
        	}
    	System.out.println(sort_genres);
    	return sort_genres.toArray(new String[sort_genres.size()]);
    }
	
	public static Integer[] get_song(String[] sort_gen, String[] genres, int[] plays ) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < sort_gen.length; i++) {
			int max = 0;
			int cycle = 0;
			int max_index = 0;
			while(cycle < 2) {
				for (int j = 0; j < genres.length; j++) {
					if(sort_gen[i].equals(genres[j])) {
//						System.out.println("진입 전"+sort_gen[i]+j+"번째");
						if(!result.contains(j) && plays[j] > max) {
							max = plays[j];
							max_index = j;
//							System.out.println("진입"+max_index);
						}
					}
				}
				cycle+=1;
				if(!result.contains(max_index)) {
					result.add(max_index);
				}
				max = 0;
			}
		}
		return result.toArray(new Integer[result.size()]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] genres = {"classic","pop","classic","classic","pop","k-pop", "k-pop"};
		int[] plays = {500,600,150,800,2500,3200,1500};
		System.out.println(solution(genres, plays));

	}

}
