/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Calculates holiday bonuses for retail stores based on their sales data
 * Due: 04/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Guerlain Darisme
*/
public class HolidayBonus {
	private static final double HIGHEST_BONUS = 5000;
    private static final double LOWEST_BONUS = 1000;
    private static final double OTHER_BONUS = 2000;

    public HolidayBonus() {
        
    }

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        int columns = getMaximumNumberOfColumns(data);

        for (int col = 0; col < columns; col++) {
            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;
            int highestStoreIndex = -1;
            int lowestStoreIndex = -1;
            int positiveSalesCount = 0;

         
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length) {
                    if (data[row][col] > 0) {
                        positiveSalesCount++;
                        if (data[row][col] > highest) {
                            highest = data[row][col];
                            highestStoreIndex = row;
                        }
                        if (data[row][col] < lowest) {
                            lowest = data[row][col];
                            lowestStoreIndex = row;
                        }
                    }
                }
            }

           
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && data[row][col] > 0) {
                    if (row == highestStoreIndex) {
                        bonuses[row] += HIGHEST_BONUS;
                    } else if (row == lowestStoreIndex && positiveSalesCount > 1) {
                        bonuses[row] += LOWEST_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }

        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double totalBonus = 0;
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        return totalBonus;
    }

    private static int getMaximumNumberOfColumns(double[][] data) {
        int maxColumns = 0;
        for (double[] row : data) {
            if (row.length > maxColumns) {
                maxColumns = row.length;
            }
        }
        return maxColumns;
    }
}
