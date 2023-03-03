package Programmers.키패드누르기;

import java.util.*;

class Solution {
    static final String LEFT = "L";
    static final String RIGHT = "R";
    static String hand;
    static List<String> result = new ArrayList<>();
    static int[][] pad = new int[3][4];
    static int[] positionLeft = new int[]{0, 3};
    static int[] positionRight = new int[]{2, 3};

    public void touchKeypad(int[] numbers){

        for(int x: numbers){
            //키패드에서의 숫자 k의 좌표
            int[] positionXY = getPositionPad(x);

            if(x==1 || x ==4 || x ==7) {
                positionLeft = positionXY.clone();
                result.add(LEFT);
            }else if(x == 3 || x == 6 || x == 9){
                positionRight = positionXY.clone();
                result.add(RIGHT);
            }else{
                result.add(chooseHand(positionXY));
            }

        }
    }

    public static int[] getPositionPad(int k){
        int positionX = 0;
        int positionY = 0;

        for(int i = 0; i<4; i++){
            for(int j = 0; j<3; j++){
                if(pad[j][i] == k){
                    return new int[]{j, i};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static String chooseHand(int[] positionXY){

        int distanceLeft = Math.abs(positionXY[0] - positionLeft[0])
                + Math.abs(positionXY[1] - positionLeft[1]);

        int distanceRight = Math.abs(positionXY[0] - positionRight[0])
                + Math.abs(positionXY[1] - positionRight[1]);

        //거리가 같으면 왼손 혹은 오른손이 되도록 거리를 변경함
        if(distanceLeft == distanceRight){
            if(hand.equals("right")) distanceRight = distanceLeft-1;
            else distanceLeft = distanceRight-1;
        }

        //더 짧은 거리에 위치한 손으로 누름
        if(distanceLeft>distanceRight) {
            positionRight = positionXY.clone();
            return RIGHT;
        }else {
            positionLeft = positionXY.clone();
            return LEFT;
        }
    }

    public String solution(int[] numbers, String hand) {
        //어느손잡이인지 저장
        this.hand = hand;

        //pad 만들기, 저장
        int idx = 1;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                pad[j][i] = idx++;
            }
        }
        pad[0][3] = -1;
        pad[2][3] = -1;

        touchKeypad(numbers);
        return String.join("", result);

    }
}