package BruteForce_recursion.n6603;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void recursion(ArrayList<Integer> testCase, boolean[] visited, int index, int n, int r){
        if(r==0) {
            for(int i = 0; i<n; i++){
                if(visited[i]) System.out.print(testCase.get(i) + " ");
            }
            System.out.println();
            return;
        }

        if(index == n) return;

        visited[index] = true;
        recursion(testCase, visited, index+1, n, r-1);

        visited[index] = false;
        recursion(testCase, visited, index+1, n, r);
    }
    public static void main(String[] args){
        List<ArrayList<Integer>> testCases = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true){
            int k = sc.nextInt();

            if(k==0) break;

            ArrayList<Integer> testCase = new ArrayList<>();
            for(int i = 0; i<k; i++){
                int s = sc.nextInt();
                testCase.add(s);
            }
            testCases.add(testCase);
        }

        for(ArrayList<Integer> testCase : testCases){
            List<Integer> result = new ArrayList<>();
            boolean[] visited = new boolean[testCase.size()];
            recursion(testCase, visited, 0, testCase.size(), 6);
            System.out.println();
        }

    }
}
