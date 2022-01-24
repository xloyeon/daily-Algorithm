import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int[] arr = new int[9];
		int max = 0;
		 
		for(int i = 0; i<n.length(); i++) {
			int k = n.charAt(i)-'0';
			
			if(k == 9)
				arr[6]++;
			else
				arr[k]++;
		}
		
		if(arr[6]%2 == 0)
			arr[6] = arr[6]/2;
		else
			arr[6] = arr[6]/2 + 1;
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]>max)
				max = arr[i];
		}
		
		System.out.println(max);
	}
}