package BruteForce.BruteForce_permutation.n1339;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<String> words = new ArrayList<>(); // 단어 리스트
        Map<String, Integer> map = new HashMap<String, Integer>(); //알파벳과 자리숫자 map
        int result = 0; //결과 값 저장

        //단어 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i<n; i++) {
            words.add(sc.next());
        }

        //모든 단어 순회
        for(String word : words){
            for(int i = 0; i<word.length(); i++){
                int digit = (int)Math.pow(10, word.length()-i-1); //자릿수 확인
                String key = Character.toString(word.charAt(i)); //알파벳 확인
                if(map.containsKey(key)){ //알파벳 있을 때
                    int value = map.get(key);
                    map.put(key, value+digit);
                }else{                    //알파벳 없을 때
                    map.put(key, digit);
                }
            }
        }

        //자릿수 기준 내림차순 정렬
        List<Integer> valueList = new ArrayList<>(map.values());
        valueList.sort(Comparator.reverseOrder());

        //9부터 차례대로 곱하기
        int idx = 9;
        for(Integer i : valueList){
            result += idx *i;
            idx--;
        }

        //결과 값 출력
        System.out.println(result);
    }
}
