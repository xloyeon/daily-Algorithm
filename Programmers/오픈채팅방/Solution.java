package Programmers.오픈채팅방;

import java.util.*;

public class Solution {
    private final String ENTER = "님이 들어왔습니다.";
    private final String LEAVE = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        Map<String, String> nickNames = new HashMap<>();   //유저 아이디, 이름
        List<String[]> list = new ArrayList<>();  //유저 아이디, ENTER/LEAVE

        for(String chatings : record){
            String[] chat = chatings.split(" ");    //입출변경, 아이디, 닉네임

            if(chat[0].equals("Enter")) list.add(new String[]{chat[1], ENTER});
            else if(chat[0].equals("Leave")) list.add(new String[]{chat[1], LEAVE});

            if(chat.length>2){
                if(nickNames.containsKey(chat[1]) && nickNames.get(chat[1]).equals(chat[2]))
                    continue;

                nickNames.put(chat[1], chat[2]);
            }
        }

        String[] result = new String[list.size()];

        for(int i = 0; i<result.length; i++){
            String[] temp = list.get(i);
            result[i] = nickNames.get(temp[0]) + temp[1];
        }

        return result;
    }
}