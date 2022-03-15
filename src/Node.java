import java.util.ArrayList;

public class Node {
    public int relable;
    public static int lengthConnection;
    public int numNode;

    public Node(int numNode, int relable) {
        this.numNode = numNode;
        this.relable = relable;
    }

    public static void SetlengthConnection(int lengthConn) {
        if (lengthConnection == 0) {
            lengthConnection = lengthConn;
        }
    }

    public int GetNumNode() {
        return this.numNode;
    }

    public static ArrayList GetChildNodes(Node node, Node arrNodes[], int numbersOfNodes) {
        ArrayList<Node> childNodes = new ArrayList<>();
        int ParentNumNode = node.GetNumNode();
        Node chldNode;
        int valIteratorTo;

        if (ParentNumNode + lengthConnection > numbersOfNodes) {
            valIteratorTo = numbersOfNodes;
        }else{
            valIteratorTo = ParentNumNode + lengthConnection;
        }
        for (int i = ParentNumNode; i < valIteratorTo; i++) {
            chldNode = (Node) arrNodes[i];
            childNodes.add(chldNode);
        }
        return childNodes;
    }

    public static String RecursionVerifyWay(ArrayList<Node> arrNodes, Node[] FullarrNodes, Node DestinationElement, int numbersOfNodes){
        String str;
        boolean repeatSearch = false;

        if (arrNodes.contains(DestinationElement)) {
            return "YES";
        }

        for(Node tmpNode : arrNodes){
            if (tmpNode.relable == 1) {
                repeatSearch = true;
            }
        }
        if (!repeatSearch){
            return "";
        }

        for(Node tmpNode : arrNodes){
            if (tmpNode.relable == 1) {
                ArrayList<Node> arrChildNodes = Node.GetChildNodes(tmpNode, FullarrNodes, numbersOfNodes);
                if (arrChildNodes.contains(DestinationElement)) {
                    return "YES";
                }
                str = RecursionVerifyWay(arrChildNodes, FullarrNodes, DestinationElement, numbersOfNodes);
                if (str == "YES"){
                    return str;
                }
            }
        }
        return "";
    }
}