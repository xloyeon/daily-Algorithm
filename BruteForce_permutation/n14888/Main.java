package BruteForce_permutation.n14888;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static boolean next_perm(int[] operators){
        int i = operators.length-1;

        while(i>0 && operators[i-1]>=operators[i]) i--;

        if(i<=0) return false;

        int j = operators.length-1;

        while(operators[j]<=operators[i-1])
            j--;

        swap(i-1, j, operators);
        j = operators.length-1;

        while(i<j){
            swap(i, j, operators);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int i, int j, int[] arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int cal(int[] nums, int[] operators){
        int result = 0;

        for(int i = 0; i<nums.length-1; i++){
            if(i==0) result = nums[i];
            if(operators[i] == 0)
                result += nums[i+1];
            else if(operators[i] == 1)
                result -= nums[i+1];
            else if(operators[i] == 2)
                result = result *nums[i+1];
            else if(operators[i] == 3)
                result /= nums[i+1];
        }
        return result;
    }

    public static void main(String[] args){
        List<Integer> results = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //숫자 배열
        int[] nums = new int[n];

        //연산자 배열
        int[] operators = new int[n-1];

        for(int i = 0; i<n; i++)
            nums[i] = sc.nextInt();

        int idx = 0;
        for(int i = 0; i<4; i++){
            int k = sc.nextInt();
            for(int j = 0; j<k; j++) {
                operators[idx] = i;
                idx++;
            }
        }


        do {
            results.add(cal(nums, operators));
        } while (next_perm(operators));

        System.out.println(Collections.max(results));
        System.out.println(Collections.min(results));
    }
}
