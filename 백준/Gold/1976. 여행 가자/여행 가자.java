import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static int[] parent;
    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return false;

        if(x<=y)
            parent[y] = x;
        else
            parent[x] = y;
        return true;
    }

    public static int find(int x){
        return parent[x] == x? x : find(parent[x]);
    }

    public static void main(String[] args) throws Exception {
        //입력값
        // 1. 도시의 수 : N   (200이하)
        // 2. 여행 게획에 속한 도시들 수 : M (1000 이하)
        // 3. N개의 줄에 N개의 정수
        // 4. 마지막 줄 -> 여행 게획

        // 경유해서 도시를 가기만 하면 되므로 .. 길이 있는지만 확인하면 됨 -> 전형적인 집합 문제 >> Union-find
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];

        //초기화
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(i+1, j+1);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int result = find(Integer.parseInt(st.nextToken()));

        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());

            if(find(tmp)!= result){
                result = 0;
                break;
            }
        }

        if(result == 0)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}