package test;

import java.util.ArrayList;

public class week_01_03 {

	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
//		int[] truck_weights = {10};
		int answer =0;
		answer = solution(bridge_length,weight,truck_weights);
		
		System.out.println(answer);
		
	}
	
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        	
        ArrayList<Integer> tlist = new ArrayList<Integer>();
        
        for (int i : truck_weights) {
			tlist.add(i);
		}
        
        int[] br = new int[bridge_length];

        while(true) {
        	int sum=0;
        	
        	for (int j : br) {
				sum += j;
			}
        	
        	if(tlist.size() == 0 && sum == 0) {
        		return answer;
        	}
        	
        	for (int i = br.length-1; i > 0; i--) {
				br[i] = br[i-1];
			}
        	
        	sum=0;
        	
        	for (int i = 1; i < br.length; i++) {
				sum+=br[i];
			}
        	
        	if(tlist.size() != 0) {
        		if(sum+tlist.get(0) <= weight) {
        			br[0] = tlist.get(0);
        			tlist.remove(0);
        		}else {
        			br[0] = 0;
        		}
        	}else {
    			br[0] = 0;
    		}
        	
        	answer++;
        	
        	
        	
        }
        	
    }

}
