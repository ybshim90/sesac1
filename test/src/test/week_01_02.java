package test;

import java.util.ArrayList;

public class week_01_02 {

	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds  = {1,30,5};
		
		int[] ret = {};
		
		ret = solution(progresses,speeds);
		
		for (int i : ret) {
			System.out.println(i);
		}
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer> plist = new ArrayList<Integer>();
        ArrayList<Integer> slist = new ArrayList<Integer>();
        ArrayList<Integer> alist = new ArrayList<Integer>();
        
        for (int i : progresses) {
			plist.add(i);
		}
        for (int i : speeds) {
			slist.add(i);
		}
        
        int cnt = 0;
        
        while(true) {
        	if(plist.size() == 0) {
    			alist.add(cnt);
        		break;        		
        	}
        	if(plist.get(0)<100) {
        		if(cnt !=0) {
        			alist.add(cnt);
	        		cnt = 0;
        		}else {
	        		for (int i = 0; i < plist.size(); i++) {
	    				plist.set(i, plist.get(i)+slist.get(i));
	    			}
        		}
        	}else if(plist.get(0)>=100){
				plist.remove(0);
				slist.remove(0);
        		cnt++;
        	}
        }
        
        answer = new int[alist.size()];
        
        int size = 0;
        for (int i : alist) {
			answer[size++] = i;
		}
        
        return answer;
    }

}
