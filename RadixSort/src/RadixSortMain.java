import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * The main class of the program
 * @author Zichen Men <zichen.men@bellevuecollege.edu>
 */
public class RadixSortMain
{
    /**
     * The main method of the program
     * @param theArguments the arguments of the program
     * @throws FileNotFoundException
     */
    public static void main(String[] theArguments) throws FileNotFoundException
    {
        Deque<Integer> master = new LinkedDeque<Integer>();
        readFileIntoDeque("input100.txt", master);
        RadixSort.sort(master);
        writeDequeToFile("output100.txt", master);
    }

    /**
     * The method reads all elements from the input file into queue
     * @param filename the input file
     * @param queue the queue
     * @throws FileNotFoundException
     */
    public static void readFileIntoDeque(String filename, Deque<Integer> queue) throws FileNotFoundException
    {
        // TODO IMPLEMENT CODE HERE
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                int number = Integer.parseInt(scanner.nextLine());
                queue.addRear(number);
            }
        }
    }

    /**
     * The method removes all elements in queue and writes them to output file
     * @param filename the output file name
     * @param queue the queue
     * @throws FileNotFoundException
     */
    public static void writeDequeToFile(String filename, Deque<Integer> queue) throws FileNotFoundException
    {
        // TODO IMPLEMENT CODE HERE
        try (PrintStream printStream = new PrintStream(new FileOutputStream(filename))) {
            while (!queue.isEmpty()) {
                int number = queue.removeFront();
                printStream.println(number);
            }
        }
    }
}