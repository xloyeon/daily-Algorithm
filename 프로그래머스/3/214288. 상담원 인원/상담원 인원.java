import java.util.*;

class Request {
    int reqTime;    //요청 시작 시간
    int required;   //상담 소요 시간
    int type;       //상담 유형
    
    public Request(int reqTime, int required, int type){
        this.reqTime = reqTime;
        this.required = required;
        this.type = type;
    }    
}

class Solution {
    public int[] mentos;    //멘토 분배
    public List<Request> requests;
    int minTime = Integer.MAX_VALUE;
    
    public void distribute(int depth, int n, int k){
        if(depth == k-1){
            mentos[depth] = n;
            simulate();
            return;
        }
        
        for(int i = 1; i<=n-(k-depth-1); i++){
            mentos[depth] = i;
            distribute(depth+1, n-i, k);
        }
    }
    
    //조합에 대해 시뮬레이션
    public void simulate(){
        //유형별 우선순위 큐
        PriorityQueue<Integer>[] queues = new PriorityQueue[mentos.length];
        
        for(int i = 0; i<mentos.length; i++){
            queues[i] = new PriorityQueue<>();  //큐 생성
            for(int j = 0; j<mentos[i]; j++){
                queues[i].add(0);   //초기 멘토들은 모두 상담자가 없음
            }
        }
        
        int total = 0;  //기다리는 시간
        
        for(Request r : requests){
            //지금 요청자의 유형에 맞는 멘토 큐
            PriorityQueue<Integer> q = queues[r.type-1];
            
            int possible = q.poll();
            
            int start = Math.max(r.reqTime, possible);
            
            total += (start - r.reqTime);
            q.add(start + r.required); //해당 멘토 시간 업데이트
        }
        
        minTime = Math.min(minTime, total);
    }
    
    public int solution(int k, int n, int[][] reqs) {
        //k명의 멘토를 총 n개의 유형(유형별로 최소 1명은 존재하게)으로 분배
        
        mentos = new int[n];
        requests = new ArrayList<>();
        
        for(int i = 0; i<reqs.length; i++){
            requests.add(new Request(reqs[i][0], reqs[i][1], reqs[i][2]));
        }

        distribute(0, n, k);
        return minTime;
    }
}