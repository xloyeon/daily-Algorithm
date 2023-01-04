package n2960;

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[n+1];
		
		for(int i = 2; i<=n; i++) {
			arr[i] = true;
		}
		
		int count = 0;
		
		for(int i = 2; i<=n; i++) {
			for(int j = i; j<=n; j+=i) {
				if(arr[j] == true) {
					arr[j] = false;
					count++;
					
					if(count ==k) {
						System.out.println(j);
						System.exit(0);
					}
				}
			}
		}
	}
}