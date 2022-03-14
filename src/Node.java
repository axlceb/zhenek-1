import java.util.ArrayList;

public class Node {
    public int relable;
    public static int lengthConnection;
    public int numNode;

    public Node(int numNode, int relable){
        this.numNode = numNode;
        this.relable = relable;
    }
    public static void SetlengthConnection(int lengthConn){
        if (lengthConnection == 0) {
            lengthConnection = lengthConn;
        }
    }
    public int GetNumNode(){
        return this.numNode;
    }

    public static ArrayList GetChildNodes(Node node, Node arrNodes[]){
        ArrayList<Node> childNodes = new ArrayList<>();
        //node = (Node) node;
        int ParentNumNode = node.GetNumNode();
        Node chldNode;

         for (int i = ParentNumNode + 1; i <= ParentNumNode + lengthConnection; i++){
             chldNode = (Node) arrNodes[i];
             if (chldNode.relable == 1){
                 childNodes.add(chldNode);
             }
         }return childNodes;
    }

}
