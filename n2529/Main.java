package n2529;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String[] sign = new String[k];
        int[] result = new int[k+1];
        String max_result = "";
        String min_result = "";

        for(int i=0; i<k; i++){
            sign[i] = sc.next();
        }

        //큰 수 찾기
        for(int i = 9; i>=9-k; i--){
            result[9-i] = i;
        }


        while(true){
            if(check(result, sign)) break;
            prev_perm(k, result);
        }

        //큰 수 출력
        for(int i = k; i>=0; i--){
            max_result = max_result.concat(Integer.toString(result[k-i]));
        }

        //작은 수 찾기
        for(int i = 0; i<=k; i++){
            result[i] = i;
        }

        while(true){
            if(check(result, sign)) break;
            next_perm(k, result);
        }

        for(int i = k; i>=0; i--){
            min_result = min_result.concat(Integer.toString(result[k-i]));
        }

        System.out.println(max_result);
        System.out.println(min_result);
    }

    private static void prev_perm(int k, int[] max){

        int i = k;
        while(i>0 && max[i-1]<=max[i])
            i--;

        if(i<=0) return;

        int j = k;
        while(max[j] >=max[i-1])
            j--;

        change(i-1, j, max);
        j = k;
        while(i<j){
            change(i, j, max);
            i++;
            j--;
        }
    }

    private static void next_perm(int k, int[] min){

        int i = k;
        while(i>0 && min[i-1]>=min[i])
            i--;

        if(i<=0) return;

        int j = k;
        while(min[j] <= min[i-1])
            j--;

        change(i-1, j, min);
        j = k;
        while(i<j){
            change(i, j, min);
            i++;
            j--;
        }
    }

    private static boolean check(int[] arr, String[] sign){
        for(int i = 0; i<arr.length-1; i++){
            if(sign[i].equals("<") && arr[i]>=arr[i+1]) return false;
            if(sign[i].equals(">") && arr[i] <= arr[i+1]) return false;
        }
        return true;
    }

    private static void change(int i, int j, int[] result){
        int tmp = result[i];
        result[i] = result[j];
        result[j] = tmp;
    }
}

