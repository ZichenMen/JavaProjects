import java.util.*;
import java.io.*;

public class Test {

    public static void main(String[] args) {
        SortedList<Integer> sortedList = new SortedList<>();
        UnsortedList<Integer> unsortedList = new UnsortedList<>();

        // Testing insert method
        sortedList.insert(3);
        sortedList.insert(1);
        sortedList.insert(2);
        System.out.println("Expected output for SortedList after insertions: [1, 2, 3]");
        System.out.println("Actual output: " + sortedList.toString());

        unsortedList.insert(3);
        unsortedList.insert(1);
        unsortedList.insert(2);
        System.out.println("Expected output for UnsortedList after insertions: [3, 1, 2]");
        System.out.println("Actual output: " + unsortedList.toString());

        // Testing remove method
        sortedList.remove(2);
        System.out.println("Expected output for SortedList after removing 2: [1, 3]");
        System.out.println("Actual output: " + sortedList.toString());

        unsortedList.remove(2);
        System.out.println("Expected output for UnsortedList after removing 2: [3, 1]");
        System.out.println("Actual output: " + unsortedList.toString());

        // Testing removeAtIndex method
        sortedList.removeAtIndex(0);
        System.out.println("Expected output for SortedList after removing index 0: [3]");
        System.out.println("Actual output: " + sortedList.toString());

        unsortedList.removeAtIndex(1);
        System.out.println("Expected output for UnsortedList after removing index 1: [3]");
        System.out.println("Actual output: " + unsortedList.toString());

        // Testing set method
        // For unsorted list only as set method is not applicable for sorted list
        unsortedList.set(0, 5);
        System.out.println("Expected output for UnsortedList after setting index 0 to 5: [5]");
        System.out.println("Actual output: " + unsortedList.toString());

        // Testing get method
        Integer sortedListValue = sortedList.get(0);
        Integer unsortedListValue = unsortedList.get(0);

        System.out.println("Expected output for SortedList get index 0: 3");
        System.out.println("Actual output: " + sortedListValue);
        System.out.println("Expected output for UnsortedList get index 0: 5");
        System.out.println("Actual output: " + unsortedListValue);
    }
}
