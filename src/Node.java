import java.util.ArrayList;

public class Node {
    // avoid using public for property
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

        // use the recommendations from IntelliJ
        // int valIteratorTo = Math.min(ParentNumNode + lengthConnection, numbersOfNodes);
        int valIteratorTo;

        if (ParentNumNode + lengthConnection > numbersOfNodes) {
            valIteratorTo = numbersOfNodes;
        } else {
            valIteratorTo = ParentNumNode + lengthConnection;
        }
        for (int i = ParentNumNode; i < valIteratorTo; i++) {
            chldNode = (Node) arrNodes[i];
            childNodes.add(chldNode);
        }
        return childNodes;
    }

    public static String RecursionVerifyWay(ArrayList<Node> arrNodes, Node[] FullarrNodes, Node DestinationElement, int numbersOfNodes) {
        String str;
        boolean repeatSearch = false;

        // With a single line single method you can skip the { ... } inn if
        if (arrNodes.contains(DestinationElement)) return "YES";

        for (Node tmpNode : arrNodes) {
            if (tmpNode.relable == 1) {
                repeatSearch = true;
            }
        }

        // With a single line single method you can skip the { ... } inn if
        if (!repeatSearch) return "";

        for (Node tmpNode : arrNodes) {
            if (tmpNode.relable == 1) {
                ArrayList<Node> arrChildNodes = Node.GetChildNodes(tmpNode, FullarrNodes, numbersOfNodes);
                if (arrChildNodes.contains(DestinationElement)) {
                    return "YES";
                }
                str = RecursionVerifyWay(arrChildNodes, FullarrNodes, DestinationElement, numbersOfNodes);
                // Dont use == comparing Strings
                if (str.equals("YES")) {
                    return str;
                }
            }
        }
        // avoid using multiple returns in the same method. 1,2,3 return is ok but more that 3 returns you need to rethink your logic
        return "";
    }
}
