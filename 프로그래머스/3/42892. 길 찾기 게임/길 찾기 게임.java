import java.util.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    int val;
    Node left;
    Node right;
    
    public Node(int x, int y, int val, Node left, Node right){
        this.x = x;
        this.y = y;
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public int compareTo(Node n){
        if(this.y == n.y)
            return this.x - n.x;
        return n.y-this.y;
            
    }
    
}

class Solution {
    int[][] result;
    int idx = 0;
    
    public void makeTree(Node parent, Node n){
        if(parent.x > n.x){
            if(parent.left == null)
                parent.left = n;
            else
                makeTree(parent.left, n);
        }else{
            if(parent.right == null)
                parent.right = n;
            else
                makeTree(parent.right, n);
        }
    }
    
    public void preorder(Node n){
        if(n!= null){
            result[0][idx++] = n.val;
            preorder(n.left);
            preorder(n.right);
        }
    }
    
    public void postorder(Node n){
        if(n!= null){
            postorder(n.left);
            postorder(n.right);
            result[1][idx++] = n.val;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        //레벨 = y값
        //Node를 넣고 .. 루트를 찾아 전위 , 후위순회
        
        //먼저 노드 만들기
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i = 0; i<nodeinfo.length; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }
        
        Arrays.sort(nodes);
        
        //트리 잇기
        for(int i = 1; i<nodes.length; i++){
            makeTree(nodes[0], nodes[i]);
        }
        
        //결과 넣을 배열(전위순회 결과, 후위순회 결과)
        result = new int[2][nodes.length];
        preorder(nodes[0]);
        idx = 0;
        postorder(nodes[0]);
        
        return result;
        
    }
}