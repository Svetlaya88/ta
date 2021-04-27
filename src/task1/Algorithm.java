package task1;

import java.util.Arrays;

public class Algorithm {
    public static void main(String[] args){

        // 	Sort array by string length

        String s1 = "Text Text11";
        String s2 = "Some the longest text";
        String s3 = "Some longer text";
        String s4 = "Some the most longest text";
        String s5 = "Text5";

        String[] stringArray = {s1, s2, s3, s4, s5};
        boolean isSorted = false;
        String change;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < stringArray.length-1; i++) {
                if (stringArray[i].length() > stringArray[i+1].length()) {
                isSorted = false;

                change = stringArray[i];
                stringArray[i] = stringArray[i + 1];
                stringArray[i + 1] = change;
                }
            }
        }

        System.out.println(Arrays.toString(stringArray));
    }
}
