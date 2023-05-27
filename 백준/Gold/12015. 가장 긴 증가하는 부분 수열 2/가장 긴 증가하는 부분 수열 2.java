import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void binarySearch(List<Integer> results, int[] arr){
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>results.get(results.size()-1)){
                results.add(arr[i]);
            }else{
                int left = 0;
                int right = results.size()-1;

                while(left<right){
                    int mid = (left+right)/2;
                    if(results.get(mid)<arr[i])
                        left = mid+1;
                    else
                        right = mid;
                }
                results.set(right, arr[i]);
            }
        }
        System.out.println(results.size()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> results = new ArrayList<>();
        results.add(0);
        binarySearch(results, arr);
    }
}
