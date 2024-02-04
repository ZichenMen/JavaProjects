public class Test1 {

    public static void main(String[] args) {
        SortedList<Integer> sortedList = new SortedList<>();

        // Testing insert method
        sortedList.insert(1);
        sortedList.insert(2);
        sortedList.insert(10);
        System.out.println("Expected output for SortedList after insertions: [1, 2, 3]");

        System.out.println("Actual output: " + sortedList.toString());


    }}