import java.io.*;
import java.util.*;

/**
 * Reads in configurations of potential solutions to Skyscraper puzzles and
 * evaluates their validity before printing out both the grids and their status
 * as an answer to the puzzles.
 *
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Zichen Men <zichen.men@bellevuecollege.edu>
 * @version ____1.0______
 */
public class Skyscraper
{
    /**
     * The driver method to process Skyscraper puzzle settings
     * The task is to check their validity and then print the grids along with the results of those checks.
     *
     * @param theArgs is used for command line input.
     */
    public static void main(final String[] theArgs) throws FileNotFoundException
    {
        if (theArgs.length != 1)
        {
            System.out.println("ERROR: Program must be run using the name of an input file that "
                    + "contains skyscraper information as a command line argument.");
        }
        else
        {
            // START FILLING YOUR CODE HERE
            Scanner input = new Scanner(new File(theArgs[0]));
            while (input.hasNextLine()) {
                int[][] x = getSkyscrapers(input);
                boolean validation = validateSkyscrapers(x);
                printSkyscrapers(x, validation);
            }
            // END FILLING YOUR CODE HERE
            System.out.println("COMPLETED PROCESSING SKYSCRAPERS");
        }
    }

    /**
     * The method validates the 2D array that read from standard input.
     *
     * @param theArray     the array of 6x6 grid
     */

    public static boolean validateSkyscrapers(final int[][] theArray) {
        // Check if each row and column have unique values from 1 to 4
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                int rowUnique = 0;
                int colUnique = 0;
                for (int k = 1; k <= 4; k++) {
                    if (theArray[i][k] == j) {
                        rowUnique++;
                    }
                    if (theArray[k][i] == j) {
                        colUnique++;
                    }
                }
                if (rowUnique != 1 || colUnique != 1) {
                    return false;
                }
            }
        }

        // Check if the clues are satisfied
        for (int i = 0; i < 6; i++) {
            if (!checkClue(theArray, i, 0, 0, 1) || !checkClue(theArray, i, 5, 0, -1)) { // Check rows
                return false;
            }
            if (!checkClue(theArray, 0, i, 1, 0) || !checkClue(theArray, 5, i, -1, 0)) { // Check columns
                return false;
            }
        }
        return true;
    }
    /**
     * Checks if a given clue is satisfied in the Skyscraper puzzle grid.
     *
     * @param theGrid   The Skyscraper puzzle grid.
     * @param theRow    The row index of the clue.
     * @param theCol    The column index of the clue.
     * @param theRowInc The row increment value for traversing the grid.
     * @param theColInc The column increment value for traversing the grid.
     * @return true if the clue is satisfied, false otherwise.
     */
    private static boolean checkClue(final int[][] theGrid, final int theRow, final int theCol, final int theRowInc, final int theColInc) {
        int clue = theGrid[theRow][theCol];
        int maxHeight = 0;
        int visibleCount = 0;
        for (int i = 1; i <= 4; i++) {
            int height = theGrid[theRow + theRowInc * i][theCol + theColInc * i];
            if (height > maxHeight) {
                maxHeight = height;
                visibleCount++;
            }
        }
        return clue == 0 || clue == visibleCount;
    }

    /**
     * The method use the Scanner parameter passed in the method to read skyscrapers from standard
     * input into 2D array.
     *
     * @param theInput     the file read by the scanner
     */
    public static int[][] getSkyscrapers(final Scanner theInput) {
        int row = 6;
        int column = 6;
        int[][] skyscrapers = new int[row][column];

        for (int i = 0; i < skyscrapers.length && theInput.hasNextLine(); i++) {
            String[] line = theInput.nextLine().split(" ");

            int indexOffset = 0;
            if (line.length == 4) {
                skyscrapers[i][0] = 0;
                indexOffset = 1;
            }

            for (int j = 0; j < line.length; j++) {
                skyscrapers[i][j + indexOffset] = Integer.parseInt(line[j]);
            }
        }

        return skyscrapers;
    }

    /**
     * Prints the Skyscraper puzzle configuration and whether it is valid or not as
     * a solution.
     *
     * @param theGrid     is a 2D integer array representing a configuration of
     *                    integers as a potential answer to a Skyscraper puzzle.
     * @param theValidity is a boolean value representing whether the 2D integer
     *                    array is an acceptable solution or not.
     */
    public static void printSkyscrapers(final int[][] theGrid, final boolean theValidity)
    {
        final StringBuilder sb = new StringBuilder();
        for (int row = 0; row < theGrid.length; row++)
        {
            for (int col = 0; col < theGrid[0].length; col++)
            {
                if (theGrid[row][col] == 0)
                {
                    sb.append(" ");
                }
                else
                {
                    sb.append(theGrid[row][col]);
                }
            }
            sb.append("\n");
        }
        if (theValidity)
        {
            sb.append("VALID");
        }
        else
        {
            sb.append("NOT VALID");
        }
        System.out.println(sb.toString());
    }
}