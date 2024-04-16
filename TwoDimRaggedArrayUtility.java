/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Manages operations on a two-dimensional ragged array of sales data.
 * Due: 04/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Guerlain Darisme
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtility {
	    public TwoDimRaggedArrayUtility() {
	    }

	    public static double[][] readFile(File file) throws FileNotFoundException {
	        Scanner scanner = new Scanner(file);
	        double[][] tempData = new double[10][10];  
	        int numRow = 0;
	        while (scanner.hasNextLine() && numRow < tempData.length) {
	            String[] values = scanner.nextLine().split("\\s+");
	            tempData[numRow] = new double[values.length]; 
	            for (int i = 0; i < values.length; i++) {
	                tempData[numRow][i] = Double.parseDouble(values[i]);
	            }
	            numRow++;
	        }
	        scanner.close();
	        double[][] data = new double[numRow][];
	        for (int i = 0; i < numRow; i++) {
	            data[i] = tempData[i];
	        }
	        return data;
	    }

	    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
	        PrintWriter writer = new PrintWriter(outputFile);
	        for (double[] row : data) {
	            for (double value : row) {
	                writer.print(value + " ");
	            }
	            writer.println();
	        }
	        writer.close();
	    }

	    public static double getTotal(double[][] data) {
	        double total = 0;
	        for (double[] row : data) {
	            for (double value : row) {
	                total += value;
	            }
	        }
	        return total;
	    }

	    public static double getAverage(double[][] data) {
	        double total = getTotal(data);
	        int count = 0;
	        for (double[] row : data) {
	            count += row.length;
	        }
	        return total / count;
	    }

	    public static double getRowTotal(double[][] data, int row) {
	        double total = 0;
	        for (double value : data[row]) {
	            total += value;
	        }
	        return total;
	    }

	    public static double getColumnTotal(double[][] data, int col) {
	        double total = 0;
	        for (double[] row : data) {
	            if (col < row.length) {
	                total += row[col];
	            }
	        }
	        return total;
	    }

	    public static double getHighestInRow(double[][] data, int row) {
	        double highest = Double.NEGATIVE_INFINITY;
	        for (double value : data[row]) {
	            if (value > highest) {
	                highest = value;
	            }
	        }
	        return highest;
	    }

	    public static int getHighestInRowIndex(double[][] data, int row) {
	        double highest = getHighestInRow(data, row);
	        for (int i = 0; i < data[row].length; i++) {
	            if (data[row][i] == highest) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    public static double getLowestInRow(double[][] data, int row) {
	        double lowest = Double.POSITIVE_INFINITY;
	        for (double value : data[row]) {
	            if (value < lowest) {
	                lowest = value;
	            }
	        }
	        return lowest;
	    }

	    public static int getLowestInRowIndex(double[][] data, int row) {
	        double lowest = getLowestInRow(data, row);
	        for (int i = 0; i < data[row].length; i++) {
	            if (data[row][i] == lowest) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    public static double getHighestInColumn(double[][] data, int col) {
	        double highest = Double.NEGATIVE_INFINITY;
	        for (double[] row : data) {
	            if (col < row.length && row[col] > highest) {
	                highest = row[col];
	            }
	        }
	        return highest;
	    }

	    public static int getHighestInColumnIndex(double[][] data, int col) {
	        double highest = getHighestInColumn(data, col);
	        for (int row = 0; row < data.length; row++) {
	            if (col < data[row].length && data[row][col] == highest) {
	                return row;
	            }
	        }
	        return -1;
	    }

	    public static double getLowestInColumn(double[][] data, int col) {
	        double lowest = Double.POSITIVE_INFINITY;
	        for (double[] row : data) {
	            if (col < row.length && row[col] < lowest) {
	                lowest = row[col];
	            }
	        }
	        return lowest;
	    }

	    public static int getLowestInColumnIndex(double[][] data, int col) {
	        double lowest = getLowestInColumn(data, col);
	        for (int row = 0; row < data.length; row++) {
	            if (col < data[row].length && data[row][col] == lowest) {
	                return row;
	            }
	        }
	        return -1;
	    }

	    public static double getHighestInArray(double[][] data) {
	        double highest = Double.NEGATIVE_INFINITY;
	        for (double[] row : data) {
	            for (double value : row) {
	                if (value > highest) {
	                    highest = value;
	                }
	            }
	        }
	        return highest;
	    }

	    public static double getLowestInArray(double[][] data) {
	        double lowest = Double.POSITIVE_INFINITY;
	        for (double[] row : data) {
	            for (double value : row) {
	                if (value < lowest) {
	                    lowest = value;
	                }
	            }
	        }
	        return lowest;
	    }

}
