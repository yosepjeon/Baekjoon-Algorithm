package Tree.p1991트리순회;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int N = scr.nextInt();
        Map<String, Node> nodes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String id = String.valueOf((char) ('A' + i));

            nodes.putIfAbsent(id, new Node(id));
        }

        for (int i = 0; i < N; i++) {
            String rootId = scr.next();
            String leftNodeId = scr.next();
            String rightNodeId = scr.next();

            Node root = nodes.get(rootId);
            Node left = null;
            Node right = null;

            if (!leftNodeId.equals(".")) {
                left = nodes.get(leftNodeId);
            }
            if (!rightNodeId.equals(".")) {
                right = nodes.get(rightNodeId);
            }

            root.left = left;
            root.right = right;
        }

        Tree tree = new Tree(nodes.get("A"));

        tree.visitPreOrder(tree.root);
        System.out.println();
        tree.visitInOrder(tree.root);
        System.out.println();
        tree.visitPostOrder(tree.root);
    }
}

class Node {
    String id;
    Node left = null;
    Node right = null;

    public Node(String id) {
        this.id = id;
    }

    public void connectLeftNode(Node left) {
        this.left = left;
    }

    public void connectRightNode(Node right) {
        this.right = right;
    }
}

class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void visitInOrder(Node node) {
        if (node != null) {
            if (node.left != null) visitInOrder(node.left);
            System.out.print(node.id);
            if (node.right != null) visitInOrder(node.right);
        }
    }

    public void visitPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.id);
            if (node.left != null) visitPreOrder(node.left);
            if (node.right != null) visitPreOrder(node.right);
        }
    }

    public void visitPostOrder(Node node) {
        if (node != null) {
            if (node.left != null) visitPostOrder(node.left);
            if (node.right != null) visitPostOrder(node.right);
            System.out.print(node.id);
        }
    }
}
