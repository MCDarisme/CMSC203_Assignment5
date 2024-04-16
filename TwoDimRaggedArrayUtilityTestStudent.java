import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] data;

    @Before
    public void setUp() {
        data = new double[][]{
            {1.0, 2.0},
            {2.0}
        };
    }

    @Test
    public void testGetTotal() {
        double expectedTotal = 5.0;
        double actualTotal = TwoDimRaggedArrayUtility.getTotal(data);
        assertEquals("Total of all elements should be calculated correctly.", expectedTotal, actualTotal, 0.01);
    }

    @Test
    public void testGetColumnTotal() {
        double expectedColumnTotal = 3.0; 
        double actualColumnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 0);
        assertEquals("Column total should be calculated correctly.", expectedColumnTotal, actualColumnTotal, 0.01);
    }

    @Test
    public void testGetRowTotal() {
        double expectedRowTotal = 3.0;
        double actualRowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 0);
        assertEquals("Row total should be calculated correctly.", expectedRowTotal, actualRowTotal, 0.01);
    }
}
