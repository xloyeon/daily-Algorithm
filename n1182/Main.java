package n1182;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void recursion(boolean[] visited, int[] nums, int idx, int i, List<Integer> results){
        if(i==0){
            int result = 0;
            for(int j = 0; j<visited.length; j++){
                if(visited[j]) result+= nums[j];
            }
            results.add(result);
            return;
        }

        if(idx == nums.length) return;

        visited[idx] = true;
        recursion(visited, nums, idx+1, i-1, results);

        visited[idx] = false;
        recursion(visited, nums, idx+1, i, results);
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        List<Integer> results = new ArrayList<Integer>();
        for(int i =1; i<=n; i++){
            boolean[] visited = new boolean[n];
            recursion(visited, nums, 0, i, results);
        }

        int cases = 0;
        for(Integer i: results)
            if(i==s) cases++;

        System.out.println(cases);
    }
}
