package test.java.com.ancoxs.testtask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.com.ancoxs.testtask.MinSum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class MinSumTest {

    @Test
    @DisplayName("Simple MinSum with moves < array.length should work")
    void testMinSumVar1() {
        assertEquals(21, MinSum.arrayMinSum(new int[]{10, 2, 7, 13},2),
                "Regular MinSum with moves < array.length should work");
    }

    @Test
    @DisplayName("Simple MinSum with moves > array.length should work")
    void testMinSumVar2() {
        assertEquals(6, MinSum.arrayMinSum(new int[]{10, 2, 7, 13},10),
                "Regular MinSum with moves > array.length should work");
    }

    @RepeatedTest(4)
    @DisplayName("IllegalArgumentException testing")
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> MinSum.arrayMinSum(new int[]{10, -2, 7, 13, 1},10));
        Throwable exception1 = assertThrows(IllegalArgumentException.class, () -> MinSum.arrayMinSum(new int[]{10, 2, 7, 13, 1},0));
        Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> MinSum.arrayMinSum(new int[]{},10));
        Throwable exception3 = assertThrows(IllegalArgumentException.class, () -> MinSum.arrayMinSum(new int[]{},0));

        assertEquals("Given array should contain only integers greater then 0", exception.getMessage());
        assertEquals("Given array should have at least one element and the amount of moves should be greater then 0", exception1.getMessage());
        assertEquals("Given array should have at least one element and the amount of moves should be greater then 0", exception2.getMessage());
        assertEquals("Given array should have at least one element and the amount of moves should be greater then 0", exception3.getMessage());
    }
}
