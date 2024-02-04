
/**
 * The class defines to sort the integer number in queue.
 * @author Zichen Men <zichen.men@bellevuecollege.edu>
 */
public class RadixSort
{
    /**
     * The number of digit queue.
     */
    public static final int TEN_DIGITS = 10;

    /**
     * The max digits in a number.
     */
    public static final int MAX_DIGITS = 4;

    /**
     * The method sort the queue using radix sort.
     * @param master the queue
     */
    public static void sort(Deque<Integer> master)
    {
        @SuppressWarnings("unchecked")
        Deque<Integer>[] buckets = new LinkedDeque[TEN_DIGITS];
        for (int index = 0; index < TEN_DIGITS; index++)
            buckets[index] = new LinkedDeque<Integer>();

        // TODO IMPLEMENT CODE HERE
        for (int digit = 0; digit < MAX_DIGITS; digit++) {
            // Distribute elements into buckets
            while (!master.isEmpty()) {
                int number = master.removeFront();
                int currentDigit = (number / (int) Math.pow(10, digit)) % TEN_DIGITS;
                buckets[currentDigit].addRear(number);
            }

            // Collect elements from buckets
            for (int index = 0; index < TEN_DIGITS; index++) {
                while (!buckets[index].isEmpty()) {
                    master.addRear(buckets[index].removeFront());
                }
            }
        }

    }
}