import java.util.ArrayList;

public class SetRelableConnection {

    public static void main(String[] args) {

        // For learning process is ok but in the real world avoid using int, char, double, ... primitive types. Instead use their class Integer, String, ...
        int[] relableArr;
        int numbersOfNodes;
        int lengthConnection;
        int tmpRel;
        Node[] arrNodes;
        //TreeMap<Node, Integer> treeMapa = new TreeMap<>(Comparator.comparingInt(o -> o.numNode));
        Node DestinationElement;

        Entrance entrance = new Entrance();

        String DataInStr = entrance.SetNodesAndLengthConnection();

        // In real world avoid using Arrays String[], use List<String> or Collections.unmodifiableList(list)
        String[] ArrTMP = DataInStr.split(String.valueOf(","));
        // Avoid using methods that returns primitives Integer.parseInt() use the class equivalent Integer.valueOf()
        try {
            numbersOfNodes = Integer.parseInt(ArrTMP[0]);
        } catch (NumberFormatException e) {
            System.out.println("Attention! enter the number format against.");
            return;
        }
        // Combine the same error in one try catch module
        try {
            lengthConnection = Integer.parseInt(ArrTMP[1]);
        } catch (NumberFormatException e) {
            System.out.println("Attention! enter the number format against.");
            return;
        }
        // avoid putting return inside catch module
        /* Example
        } catch (NumberFormatException e) {
            if (numbersOfNodes == null)
                System.out.println("Attention! numbersOfNodes is not set, enter the number format against.");
            if (lengthConnection == null)
                System.out.println("Attention! lengthConnection is not set, enter the number format against.");
        }

         */

        relableArr = entrance.SetRelablesString(numbersOfNodes);
        // Avoid using this old fashion signature use more modern
        /*
            ArrayList<Integer> arr;
            if (arr.isEmpty()) return;
        */
        if (relableArr.length == 0) {
            return;
        }

        int num_tmp = 0;

        // Replace with lambda function
        for (int i = 0; i < relableArr.length; i++) {
            if (relableArr[i] == 1) {
                num_tmp++;
            }
        }
        arrNodes = new Node[numbersOfNodes];

        Node node = new Node(1, 1);
        Node.SetlengthConnection(lengthConnection);
        arrNodes[0] = node;
        //treeMapa.put(node, 1);

        for (int i = 2; i < numbersOfNodes; i++) {
            tmpRel = relableArr[i - 1];
            node = new Node(i, tmpRel);
            arrNodes[i - 1] = node;
            //treeMapa.put(node, i);
        }
        node = new Node(numbersOfNodes, 1);
        arrNodes[numbersOfNodes - 1] = node;
        DestinationElement = node;
        //treeMapa.put(node, numbersOfNodes);
        //--------------------------------------------------------------------------

        for (int i = 0; i < arrNodes.length; i++) {
            node = (Node) arrNodes[i];
            int mtpNumNode = node.GetNumNode();

            ArrayList<Node> arrChildNodes = Node.GetChildNodes(node, arrNodes, numbersOfNodes);
            if (arrChildNodes.contains(DestinationElement)) {
                System.out.println("YES");
                return;
            }

            String str = Node.RecursionVerifyWay(arrChildNodes, arrNodes, DestinationElement, numbersOfNodes);
            if (str.equals("YES")) {
                System.out.println(str);
            } else {
                System.out.println("NO");
            }
            return;

            //Node tmpNode = treeMapa.navigableKeySet().stream().filter(nod -> nod.GetNumNode() > 3).findFirst().get();
            //Map<Node, Integer> childNodes = treeMapa.headMap(tmpNode, true);
        }
        // Avoid using System.out.print. Create a project with gradle/maven put the lombock dependency and use log.info()
        System.out.println("NO");
    }
}
