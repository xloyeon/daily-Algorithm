import java.util.*;

class Node implements Comparable<Node> {
    int x;
    int y;
    int v;
    Node left;
    Node right;
    
    public Node(int x, int y, int v, Node left, Node right) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.left = left;
        this.right = right;
    }
    
    public int compareTo(Node n) {
        if(this.y == n.y)
            return this.x - n.x;
        return n.y - this.y;
    }
}

class Solution {
    public static int idx = 0;
    public static int[][] result;
    
    public void addNode(Node parent, Node n) {
        if(parent.x > n.x) {
            if(parent.left == null) parent.left = n;
            else addNode(parent.left, n);
        }else {
            if(parent.right == null) parent.right = n;
            else addNode(parent.right, n);
        }
    }
    
    public void preorder(Node a) {
        if(a != null) {
            result[0][idx++] = a.v;
            preorder(a.left);
            preorder(a.right);
        }
    }
    
    public void postorder(Node a) {
        if(a != null) {
            postorder(a.left);
            postorder(a.right);
            result[1][idx++] = a.v;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];   //전체 노드
        
        for(int i=0; i<nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }
        
        Arrays.sort(nodes);
        
        Node root = nodes[0];   //루트 노드
        
        for(int i = 1; i<nodes.length; i++) {
            addNode(root, nodes[i]);    //하위 노드로 넣기
        }
        
        result = new int[2][nodes.length];
        
    
        preorder(root);
        idx = 0;
        postorder(root);
        return result;
    }
}