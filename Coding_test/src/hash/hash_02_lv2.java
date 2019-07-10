package hash;
// 프로그래머스 코딩 문제. hash 활용 휴대폰 접두어 문제. lv2문제
public class hash_02_lv2 {
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length; i++) {
        	int k = phone_book[i].length();
        	String prefix = phone_book[i].substring(0, k);
        	for (int j = 0; j < phone_book.length; j++) {
        		try {
        			if(i!=j && phone_book[j].substring(0, k).equals(prefix)) {
        				answer = false;
        				return answer;
        			}
				} catch (Exception e) {
					// TODO: handle exception
				}
        	}
			
		}
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = {"97642","976424223", "119040903"};
		System.out.println(solution(phone_book));

	}

}
