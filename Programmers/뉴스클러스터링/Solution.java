package Programmers.뉴스클러스터링;

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> elements = new HashSet<>();

        for(int i = 0; i<str1.length()-1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            String temp = String.valueOf(c1)+String.valueOf(c2);

            if(c1>='a' && c1<='z' && c2>='a' && c2<='z'){
                if(!map1.containsKey(temp))
                    map1.put(temp, 1);
                else
                    map1.put(temp, map1.get(temp)+1);

                elements.add(temp);
            }
        }

        for(int i = 0; i<str2.length()-1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            String temp = String.valueOf(c1)+String.valueOf(c2);

            if(c1>='a' && c1<='z' && c2>='a' && c2<='z'){
                if(!map2.containsKey(temp))
                    map2.put(temp, 1);
                else
                    map2.put(temp, map2.get(temp)+1);

                elements.add(temp);
            }
        }

        int common = 0;
        int all = 0;

        Iterator<String> iter = elements.iterator();

        while(iter.hasNext()){
            String target = iter.next();

            if(map1.containsKey(target) && map2.containsKey(target)){
                common += Math.min(map1.get(target), map2.get(target));
                all += Math.max(map1.get(target), map2.get(target));
            }else if(map1.containsKey(target)){
                all += map1.get(target);
            }else{
                all+= map2.get(target);
            }
        }

        if(common ==0 && all==0) return 65536;
        else return (int)Math.floor((double)common/all*65536);

    }
}
