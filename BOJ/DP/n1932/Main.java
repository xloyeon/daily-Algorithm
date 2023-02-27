package BOJ.DP.n1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> triangle;
    static List<List<Integer>> result = new ArrayList<>();

    public static void Dp(int n){
        for(List<Integer> list : triangle){
            int len = list.size();

            if(len==1)
                result.add(list);
            else{
                List<Integer> temp = new ArrayList<>();
                for(int i = 0; i<len; i++){
                    int increase = 0;
                    if(i==0) {
                        temp.add(result.get(len - 2).get(0) + list.get(i));
                    }else if(i==len-1) {
                        temp.add(result.get(len - 2).get(len - 2) + list.get(i));
                    }else{
                        int max = Math.max(result.get(len-2).get(i-1), result.get(len-2).get(i));
                        temp.add(max + list.get(i));
                    }
                }
                result.add(temp);
            }
        }

        Collections.sort(result.get(n-1));
        System.out.println(result.get(n-1).get(n-1));

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        triangle = new ArrayList<>();

        for(int i = 0; i<n; i++){
            List<Integer> row = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<i+1; j++){
                row.add(Integer.parseInt(st.nextToken()));
            }
            triangle.add(row);
        }

        Dp(n);
    }
}
