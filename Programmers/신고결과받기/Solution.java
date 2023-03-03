package Programmers.신고결과받기;

import java.util.*;

public class Solution {
    static List<String> members = new ArrayList<>();
    static Map<String, List<String>> reportMap = new HashMap<>();
    static List<String> stopMember = new ArrayList<>();
    static int[] result;

    public static void checkReport(String[] report){
        for(String s : report){
            String[] tempReport = s.split(" ");
            List<String> tempList = new ArrayList<>();

            if(reportMap.containsKey(tempReport[1])){ //이미 신고당한 적 있는 유저이면
                tempList = reportMap.get(tempReport[1]);

                if(!tempList.contains(tempReport[0])){ //이미 해당 유저를 신고한 적 있는 경우 신고 횟수를 1번만
                    tempList.add(tempReport[0]);
                    reportMap.put(tempReport[1], tempList);
                }
            }else{                                     //신고한 유저가 없는 유저라면
                tempList.add(tempReport[0]);
                reportMap.put(tempReport[1], tempList);
            }
        }
    }

    public static void checkStopMember(int k){
        Iterator<String> keys = reportMap.keySet().iterator();

        while(keys.hasNext()){
            String key = keys.next();

            List<String> reportUsers = reportMap.get(key);
            if(reportUsers.size()>=k)
                stopMember.add(key);
        }
    }

    public static void checkResult(){
        for(String stop : stopMember){
            List<String> sendMembers = reportMap.get(stop);

            for(String send : sendMembers){
                int idx = members.indexOf(send);
                result[idx]++;
            }
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        for(String id : id_list){
            members.add(id);
        }

        result = new int[id_list.length];

        checkReport(report);
        checkStopMember(k);
        checkResult();

        return result;
    }
}
