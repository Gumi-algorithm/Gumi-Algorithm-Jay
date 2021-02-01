package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
    char alpha;
    Node left;
    Node right;

    Node(char alpha){
        this.alpha = alpha;
    }
}

class Tree{
    Node root;

    public void createNode(char alpha, char left, char right){
        if(root == null){   //루트가 없다면 생성해주자.
            root = new Node(alpha);

            if(left != '.'){    // 왼쪽 자식노드가 있을 경우
                root.left = new Node(left);
            }
            if(right != '.'){   // 오른쪽 자식노드가 있을 경우
                root.right = new Node(right);
            }
        }
        else{   // 초기에 루트가 있다면 순회 시작.
            tourNode(root, alpha, left, right);
        }
    }

    public void tourNode(Node root, char alpha, char left, char right){
        if(root == null){
            return;
        }
        else if(root.alpha == alpha){  // 추가할 위치를 찾았을 경우
            if(left != '.'){
                root.left = new Node(left);
            }
            else if(right != '.'){
                root.right = new Node(right);
            }
        }
        else{ // 추가할 위치를 못찾았을 때
            tourNode(root.left, alpha, left, right);
            tourNode(root.right, alpha, left, right);
        }
    }

    public void preorder(Node root){    //   전위 순회 (루트 -> 왼쪽 -> 오른쪽)
//        가운데 출력
        System.out.print(root.alpha);
        if(root.left != null)   // 왼쪽 출력
            preorder(root.left);
        if(root.right != null)  // 오른쪽 출력
            preorder(root.right);
    }

    public void inorder(Node root){     // 중위 순회 (왼쪽 -> 루트 -> 오른쪽)
        if(root.left != null)
            inorder(root.left);
        System.out.print(root.alpha);
        if(root.right != null)
            inorder((root.right));
    }

    public void postorder(Node root){   // 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
        if(root.left != null)
            postorder(root.left);
        if(root.right != null)
            postorder(root.right);
        System.out.print(root.alpha);
    }
}

public class no1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for(int i = 0; i < n; i++){
            char[] alpha = br.readLine().replaceAll(" ", "").toCharArray();
            tree.createNode(alpha[0], alpha[1], alpha[2]);
        }

//        전위 순회
        tree.preorder(tree.root);
        System.out.println();
//        중위
        tree.inorder(tree.root);
        System.out.println();
//        후위
        tree.postorder(tree.root);
        System.out.println();

        br.close();
    }
}
