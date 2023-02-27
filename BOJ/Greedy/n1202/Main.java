package BOJ.Greedy.n1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewel implements Comparable<Jewel>{
    private int weight;
    private int price;

    Jewel(int weight, int price){
        this.weight = weight;
        this.price = price;
    }

    public int getWeight(){
        return this.weight;
    }

    public  int getPrice(){
        return this.price;
    }

    @Override
    public int compareTo(Jewel j){
        if(this.weight == j.weight)
            return j.price - this.price;
        return this.weight - j.weight;
    }

}

public class Main {

    public static void stealJewels(Jewel[] jewels, Integer[] bags){
        long maxPrice = 0L;
        int index = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2)-> Integer.compare(o2,o1));

        for(int bag : bags){
            while(index< jewels.length && jewels[index].getWeight()<=bag){
                q.add(jewels[index].getPrice());
                index++;
            }

            if(!q.isEmpty())
                maxPrice += q.poll();
        }

        System.out.println(maxPrice);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];
        Integer[] bags = new Integer[k];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, price);
        }

        for(int i = 0; i<k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);
        Arrays.sort(bags);

        stealJewels(jewels, bags);

    }
}
