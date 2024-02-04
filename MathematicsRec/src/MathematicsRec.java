/**
 * @author Zichen Men
 */
class MathematicsRec
{
    /**
     * The method returns a value which:
     * - Increases each of even decimal digits of n by one
     * - Decreases each of  odd decimal digits of n by one
     * @param theDecimalNumber the input decimal number (n)
     * @return the new decimal number after digit adjustments
     */
    public static long eduodd(long n)
    {
        boolean isNegative = n < 0;
        if(isNegative) n = -n;
        if(n % 10 == n){
            if(n % 2 == 0){
                return isNegative? -1 * (n + 1) : n + 1;
            }
            return isNegative? -1 * (n - 1) : n - 1;
        }

        long k = n % 10;
        n = n / 10;

        if(k % 2 == 0)return isNegative? -1 * (eduodd(n) * 10 + k + 1) : eduodd(n) * 10 + k + 1;

        return isNegative? -1 * (eduodd(n) * 10 + k - 1) : eduodd(n) * 10 + k - 1;
    }

    /**
     * The method accepts non-negative integer and returns a value as described below
     * @param theDecimalNumber is a non-negative decimal number (n)
     * @return the value in following way:
     * - return 1 when n = 0
     * - return sum of fibby(floor(n/4)) and fibby(floor(3n/4)) when n > 0
     */
    public static int fibby(int n)
    {
        if(n == 0) return 1;

        return fibby(n/4) + fibby((3 * n)/4);
    }

    /**
     * The method prints all consecutive values of n and its fibby value
     * @param theLowerBound the lower bound (start)
     * @param theUpperBound the upper bound (end)
     */
    public static void stg(int n, int m)
    {
        System.out.println(n + " " + fibby(n));
        stgHelper(n+1, m);
    }

    /**
     * The method helps stg to print rest of consecutive values and its fibby value
     * @param n the lower bound
     * @param m the upper bound
     */
    private static void stgHelper(int n, int m){
        if(n > m) return;
        if(n == m){
            if(fibby(n) == fibby(n-1)){
                return;
            }else System.out.println(n+ " " + fibby(n));
        }else if(fibby(n - 1) == fibby (n)){
            stgHelper(n + 1 , m);
        }else{
            System.out.println(n + " " + fibby(n));
            stgHelper(n + 1 , m);
        }
    }

    /**
     * The method returns the median that split the array into 3 parts
     * @param theList the list of integers (a)
     * @return the median
     */
    public static double median3(int[] n)
    {
        return medianHelper(n, 0, n.length - 1);
    }


    private static double medianHelper(int[] arr, int start, int end) {
        int len = end - start + 1;

        if (len == 1) {
            return arr[start];
        } else if (len == 2) {
            return (arr[start] + arr[end]) / 2.0;
        }

        int mid1, mid2;
        if (len % 3 == 0) {
            mid1 = start + len / 3;
            mid2 = start + 2 * len / 3; // 1
        } else if (len % 3 == 1) {
            mid1 = start + len / 3;
            mid2 = start + 2 * len / 3 + 1;
        } else { // len % 3 == 2
            mid1 = start + len / 3 + 1;
            mid2 = start + 2 * len / 3;
        }

        double median1 = medianHelper(arr, start, mid1 - 1);
        double median2 = medianHelper(arr, mid1, mid2 - 1);
        double median3 = medianHelper(arr, mid2, end);
        return medianOfThree(median1, median2, median3);
    }


    private static double medianOfThree(double a, double b, double c) {
        if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return b;
        } else if ((b <= a && a <= c) || (c <= a && a <= b)) {
            return a;
        } else {
            return c;
        }
    }
}

