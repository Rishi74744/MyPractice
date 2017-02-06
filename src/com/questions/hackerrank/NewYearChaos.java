package com.questions.hackerrank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NewYearChaos {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n];
            for(int q_i=0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            Map<Integer,Integer> m = new HashMap<Integer,Integer>();
            int totalBribes = 0;
            int noOfTwoMoves = 0;
            for(int i = 0; i < n; i++){
                if((i+1)!=q[i]){
                    if(!m.containsKey((i+1)) || !m.containsKey(q[i])){
                        //m.put((i+1),0);
                        //m.put(q[i],0);
                        int mov = Math.abs(q[i] - (i+1));
                        if(mov > 2){
                            totalBribes = 0;
                            break;
                        }else{
                        	int max = 0;
                        	int min = 0;
                        	if((i+1) > q[i]){
                        		max = (i+1);
                        		min = q[i];
                        	}else{
                        		max = q[i];
                        		min = (i+1);
                        	}
                        	for(int j = min; j <= max; j++){
                        		m.put(j, 0);
                        	}
                        }
                        totalBribes += mov;
                        if(mov == 2)
                        	noOfTwoMoves++;
                    }
                }
            }
            if(noOfTwoMoves - 2 < 0){
            	noOfTwoMoves = 0;
            }else{
            	noOfTwoMoves -= 2;
            }
            
            if(totalBribes == 0){
                System.out.println("Too chaotic");
            }else{
                System.out.println(totalBribes + noOfTwoMoves);
            }
        }
    }
}
