import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Entrance {
    public String SetNodesAndLengthConnection() {
        Scanner scanr = new Scanner(System.in);
        System.out.println("Enter the numbers of Nodes & Length connection: N,k ");
        String i = "";
        if (scanr.hasNextLine()) {
            i = scanr.nextLine();
        }
        return i;
    }
    public int[] SetRelablesString(int numbrsOfNode) {
        int[] arr = new int[numbrsOfNode];
        int[] voidArr = new int[0];

        System.out.println("Enter the string value between 0 to 1, means relables of nodes (lengths = " + numbrsOfNode + "): ");
        Scanner scanr = new Scanner(System.in);

        int num = 0;
        int tmpVar = 0;
        if (scanr.hasNextLine()){

            String StrIn = scanr.nextLine();
            char[] charArrIn = StrIn.toCharArray();

            for (int i = 0; i < charArrIn.length; i++){
                try {
                    num = Character.getNumericValue(charArrIn[i]);
                    if (num < 0 || num > 1){
                        System.out.println("wrong number , try again...");
                        return voidArr;
                    }else {
                        arr[tmpVar] = num;
                        tmpVar++;
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Atention! enter the number format against.");
                    return voidArr;
                }
            }
        }

        if (tmpVar < numbrsOfNode){
            System.out.println("Number can't be empty. Try again...");
            return voidArr;
        }
        return arr;
     }
}
