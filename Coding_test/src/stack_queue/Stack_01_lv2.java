package stack_queue;

import java.util.Stack;

//프로그래머스 코딩 테스트. 스택/큐. 1번 문제. 쇠막대기 자르기. 레벨2
public class Stack_01_lv2 {
	
	public static int solution(String arrangement) {
        int answer = 0;
        int check = 0;
        int cuting = 0;
        Stack<String> cut = new Stack<String>();
        String[] stack_ary = arrangement.split("");
        for (int i = 0; i < stack_ary.length; i++) {
        	System.out.println(stack_ary[i]);
        	try {
        		if(stack_ary[i].equals("(")) {
        			System.out.println("add 전"+cut.size());
        			cut.add(stack_ary[i]);
        			System.out.println("add 후"+cut.size());
        			check = 0;
        		}
        		else if(stack_ary[i].equals(")") && cut.peek().equals("(") && check==0) {
        			System.out.println("pop 전"+cut.size());
        			cut.pop();
        			System.out.println("pop 후"+cut.size());
        			answer += cut.size()*1;
        			check = 1;
        			System.out.println("컷팅 수"+answer);
        		}
        		else if(stack_ary[i].equals(")") && cut.peek().equals("(") && check==1){
        			cut.pop();
        			answer += 1;
        			System.out.println("종말이다"+cut.size());
        		}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String arrangement = "()(((()())(())()))(())";
		String arrangement = "()(((()())(())()))(())";
		System.out.println(Integer.toString(solution(arrangement)));
		

	}

}
