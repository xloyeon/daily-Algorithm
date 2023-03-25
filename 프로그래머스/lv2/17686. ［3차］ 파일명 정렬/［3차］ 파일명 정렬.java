import java.util.*;

class FileName implements Comparable<FileName>{
    String name;
    String head;
    int number;
    String tail;
    
    public FileName(String file){
        this.name = file;
        splitName();
    }
    
    public void splitName(){
        int start = 0;
        int end = name.length();
            
        //숫자 시작 인덱스(start) 찾기
        for(int i = 0; i<name.length(); i++){
            char c = name.charAt(i);
            if(c>='0' && c<='9') { 
                start = i;
                break;
            }
        }
            
        //숫자 끝 인덱스(end) 찾기
        for(int i = start; i<name.length(); i++){
            char c = name.charAt(i);
            if(c<'0' || c>'9') {
                end = i;
                break;
            }
        }
        
        this.head = name.substring(0, start).toLowerCase();
        this.number = Integer.parseInt(name.substring(start, end));
        this.tail = name.substring(end, name.length());
    }
    
    public String getName(){
        return this.name;
    }
    
    public int compareTo(FileName f){
        if(this.head.equals(f.head)){
            return this.number - f.number;
        }else{
            return this.head.compareTo(f.head);
        }
    }
}


class Solution {
    public String[] solution(String[] files) {
        List<FileName> fileList = new ArrayList<>();
        
        for(String file : files){
            fileList.add(new FileName(file));
        }
        
        Collections.sort(fileList);
            
        String[] result = new String[fileList.size()];
        int idx = 0;
        
        for(FileName file : fileList){
            result[idx++] = file.getName();
        }
        
        return result;
    }
}