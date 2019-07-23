package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class disk_hash implements Comparable<disk_hash> {
	int key;
	int value;
	
	public disk_hash(int key, int value) {
        this.key = key;
        this.value = value;
    }
	
	@Override
	public int compareTo(disk_hash target) {
		if(this.value == target.value) {
			if(this.key < target.key) {
				return 1;
			}
			else {
				return -1;
			}
		}
		return this.value > target.value ? 1 : - 1;
	}
	@Override
	public String toString() {
        return "key : " + key + ", value : " + value;
    }
}

public class heap_03_lv3 {
	public static int solution(int[][] jobs) {
		int answer = 0;
        int sum = 0;
        PriorityQueue<disk_hash> disk = new PriorityQueue<>();
        ArrayList<Integer> pro_disk = new ArrayList<Integer>();
        
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                final Integer time1 = entry1[0];
                final Integer time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        int point = jobs[0][0];
        
        while(sum < jobs.length) {
        	int check_check = 0;
        	for (int i = 0; i < jobs.length; i++) {
        		if(!pro_disk.contains(i) && jobs[i][0] <= point) {
        			System.out.println("추가 = "+i);
        			disk.offer(new disk_hash(jobs[i][0], (jobs[i][1])+point));
        			check_check = 1;
        		}
        		if(!pro_disk.contains(i) && jobs[i][0] > point && check_check == 0) {
        			point+=1;
        			System.out.println("해당사항 없음 증가.");
        			sum--;
        			break;
        		}
        	}
        	if(!disk.isEmpty()) {
        		disk_hash temp = disk.poll();
        		disk.clear();
        		for (int i = 0; i < jobs.length; i++) {
        			if(jobs[i][0] == temp.key && jobs[i][1] == temp.value-point && !pro_disk.contains(i)) {
        				System.out.println(i+"번째,"+"key = "+jobs[i][0]+","+"value = "+jobs[i][1]);
        				pro_disk.add(i);
        				break;
					}
				}
        		answer += temp.value-temp.key;
        		System.out.println("추가 answer = "+temp.value);
        		System.out.println("추가 포인트 = "+(temp.value+temp.key-point));
        		System.out.println("현재까지 answer 양 = "+answer);
        		point += (temp.value-point);
        	}
        	sum++;
        }
        System.out.println("총 answer = "+answer);
        return answer/jobs.length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = {{2,1},{0,1},{3,1},{4,1},{5,1}};
		System.out.println(solution(jobs));

	}

}
