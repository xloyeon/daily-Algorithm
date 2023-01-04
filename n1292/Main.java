package n1292;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] makeArr(int b) {
		int[] arr = new int[b];
		int count = 0;
		
		for(int i = 0; count<arr.length; i++) {
			for(int j = 0; j<=i; j++) {
				arr[count] = i+1;
				count++;
				
				if(count == arr.length) return arr;
			}
		}
		return arr;
	}
	
	public static void printSum(int a, int b, int[] arr) {
		int sum = 0;
		for(int i = a-1; i<b; i++) {
			sum+= arr[i];
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		printSum(a, b, makeArr(b));
	}	
}