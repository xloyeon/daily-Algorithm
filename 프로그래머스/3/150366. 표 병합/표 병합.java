import java.util.*;

class Solution {
    public static String[] cells = new String[50*50+1];    //셀의 문자열 저장할 배열
    public static int[] parents = new int[50*50+1];    //셀의 부모 저장할 배열
    
    public static int calCellNum(int r, int c){
        return (r-1)*50 + c;
    }    
    
    public static boolean merge(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return false;
        
        parents[y] = x;
        
        //x 위치에 값이 없으면 y 위치 값이 부모 값
        if(cells[x] == null)
            cells[x] = cells[y];
        return true;
    }
    
    public static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
        
    public void unmerge(int x){
        int root = find(x);
        String value = cells[root];
        
        //병합 풀 대상들
        List<Integer> targets = new ArrayList<>();
        
        for(int i = 1; i<cells.length; i++){
            if(find(i) == root){
                targets.add(i);
            }
        }
        
        for(int i : targets){
            parents[i] = i;
            cells[i] = null;
        }
        
        cells[x] = value;
    }
    
    public String printCell(int x){
        return cells[find(x)] == null ? "EMPTY" : cells[find(x)];
    }
    
    public void updateWithCellNum(int cellNum, String value){
        int p = find(cellNum);
        cells[p] = value;
    }
    
    public void updateWithValue(String value1, String value2){
        for(int i = 1; i<cells.length; i++){
            int p = find(i);
            
            if(cells[p]!= null){
                if(cells[p].equals(value1))
                    cells[p] = value2;
            }
        }
    }
    
    public String[] solution(String[] commands) {
        
        // 셀 부모배열 초기화
        for(int i = 0; i<parents.length; i++)
            parents[i] = i;
        
        // print 결과 담을 리스트
        List<String> resultList = new ArrayList<>();
        
        // 명령어 하나씩 돌면서 기능
        for(String command : commands){
            String[] sArr = command.split(" ");
            
            if(sArr[0].equals("UPDATE")){
                if(sArr.length == 4){
                    int cellNum = calCellNum(Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]));
                    updateWithCellNum(cellNum, sArr[3]);
                } else {
                    updateWithValue(sArr[1], sArr[2]);
                }
            }else if(sArr[0].equals("MERGE")){
                int x = calCellNum(Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]));
                int y = calCellNum(Integer.parseInt(sArr[3]), Integer.parseInt(sArr[4]));
                merge(x, y);
            }else if(sArr[0].equals("UNMERGE")){
                int cellNum = calCellNum(Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]));
                unmerge(cellNum);
            }else{
                int cellNum = calCellNum(Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]));
                resultList.add(printCell(cellNum));
            }
        }
        
        
        //배열로 전환
        String[] result = new String[resultList.size()];
        
        for(int i = 0; i<resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}