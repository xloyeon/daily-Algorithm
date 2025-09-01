import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        // 합성 카드의 레벨이 높아야 함
        // 골도는 합성할 때마다 누적됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        //card 배열 만듦
        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        //카드 레벨 내림차순 정렬
        Integer[] reverseCards = Arrays.stream(cards).boxed()
                .toArray(Integer[]::new);

        Arrays.sort(reverseCards, Collections.reverseOrder());

        int level = reverseCards[0];
        int gold = 0;

        for(int i = 1; i<n; i++){
            gold += level + reverseCards[i];
            reverseCards[i] = level;
        }

        System.out.println(gold);
    }
}