package BOJ.BinarySearch.n2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void binarySearch(int[] houses, int k){
       long min= 1; //최소 간격
       long max = houses[houses.length-1]- houses[0]; //최대 간격
       long result = 0;

       while(min<=max){
           long mid = (min + max)/2; //중간 간격
           int count = 1;             //첫번째부터 시작하므로 1
           int start = houses[0];

           for(int house : houses){
               if(house-start>=mid){   //간격보다 크면 설치
                   count++;
                   start = house;      //다음 집은 여기랑 간격 체크
               }
           }

           if(count>=k){   //공유기 설치가 많이 되어있으면 간격 크게 함
               result = mid;
               min = mid+1;
           }else{          //곻유기 설치가 덜 되어있으면 간격 줄여야 함
               max = mid -1;
           }

       }
       System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];

        for(int i = 0; i<n; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);
        binarySearch(houses, k);
    }
}
