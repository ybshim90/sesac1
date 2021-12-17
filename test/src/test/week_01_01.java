package test;



public class week_01_01 {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		int[] ret = {};
		
		ret = solution(prices);
		
		for (int i : ret) {
			System.out.println(i);
		}
		
	}
	
    public static int[] solution(int[] prices) {
        int[] answer = {};
        
        answer = new int[prices.length];
        
        for (int i = 0; i < prices.length-1; i++) {
        	int cnt = 1;
			for (int j = i+1; j < prices.length; j++) {
				if(prices[i]>prices[j]) {
					answer[i] = cnt;
					break;
				}else {
					answer[i] = cnt;
					cnt++;
				}
				
			}
		}
        answer[prices.length-1] = 0; 
        
        return answer;
    }

}
