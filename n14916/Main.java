package n14916;

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int countA = (int)n/5, countB = 0;
		
		while(countA>=0){
			if((n-countA*5)%2 != 0) {
				countA--;
			}else{
				countB = (int)(n-countA*5)/2;
				break;
			}
		}
		
		if(countA<0) 
			System.out.println(-1);
		else
			System.out.println(countA+countB);
	}	
}