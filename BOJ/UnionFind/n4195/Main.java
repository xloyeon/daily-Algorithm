package BOJ.UnionFind.n4195;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, count;

    public static int union(int friend1, int friend2){
        friend1 = find(friend1);
        friend2 = find(friend2);

        if(friend1==friend2) return count[friend1];

        if(friend1<friend2) {
            parent[friend2]= friend1;
            return count[friend1] += count[friend2];
        } else {
            parent[friend1] = friend2;
            return count[friend2] += count[friend1];
        }
    }

    public static int find(int friend){
        if(parent[friend] == friend) return friend;
        else return parent[friend] = find(parent[friend]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++){
            int f = Integer.parseInt(br.readLine());
            Map<String, Integer> friends = new HashMap<>();
            parent = new int[2*f];
            count = new int[2*f];

            for(int j = 0; j< parent.length; j++){
                parent[j] = j;
                count[j] = 1;
            }

            int idx = 0;

            for(int j = 0; j<f; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                if(!friends.containsKey(friend1)){
                    friends.put(friend1, idx++);
                }
                if(!friends.containsKey(friend2)){
                    friends.put(friend2, idx++);
                }

                System.out.println(union(friends.get(friend1), friends.get(friend2)));
            }
        }
    }
}