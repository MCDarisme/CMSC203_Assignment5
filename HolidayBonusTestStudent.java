import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent {

    private double[][] salesData;

    @Before
    public void setUp() {
        salesData = new double[][] {
            {1000.0, 2000.0},
            {2000.0, 1000.0}
        };
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double actualTotal = HolidayBonus.calculateTotalHolidayBonus(salesData);
        assertTrue("Total holiday bonuses should be a positive number.", actualTotal > 0);
    }

    @Test
    public void testCalculateHolidayBonusLength() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(salesData);
        assertEquals("Number of bonuses should match number of rows in sales data.", salesData.length, bonuses.length);
    }

    @Test
    public void testNonNegativeBonuses() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(salesData);
        for (double bonus : bonuses) {
            assertTrue("Bonuses should be non-negative.", bonus >= 0);
        }
    }
}


