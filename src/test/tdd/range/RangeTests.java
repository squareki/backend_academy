package tdd.range;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

public class RangeTests {

    @Test
    public void emptyRangeTest() {
        Range empty = new Range();
        assertEquals(0, empty.length);
    }

    @Test
    public void rangeFromZeroToTenTest() {
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Range range = new Range(0, 10);

        assertArrayEquals(expected, range.toArray());
    }

    @Test
    public void rangeIsEmptyTest() {
        Range range = new Range();
        assertTrue(range.isEmpty());
    }

    @Test
    public void rangeIsNotEmptyTest() {
        Range range = new Range(0, 0); //contains 0
        assertFalse(range.isEmpty());
    }

    @Test
    public void rangeIsEmptyIncorrectOrder() {
        Range range = new Range(100, 1);
        assertTrue(range.isEmpty());
    }

    @Test
    public void rangeMaxTest() {
        Range range = new Range(-5, 10);
        assertEquals(10, range.getMax());
    }

    @Test
    public void rangeMinTest() {
        Range range = new Range(-10, 5);
        assertEquals(-10, range.getMin());
    }

    @Test
    public void rangeMaxNullTest() {
        Range range = new Range();
        assertEquals(null, range.getMax());
    }

    @Test
    public void rangeMinNullTest() {
        Range range = new Range();
        assertEquals(null, range.getMin());
    }
    
    @Test
    public void rangeContainsOnPresentTest() {
        Range range = new Range(0, 5);
        for (int i = 0; i < 5; i++)
            assertTrue(range.contains(i));
    }

    @Test
    public void rangeContainsOnAbsentTest() {
        Range range = new Range(0, 5);
        assertFalse(range.contains(-1));
    }

    @Test
    public void rangesEqualTest() {
        Range first = new Range(-100, 400);
        Range second = new Range(-100, 400);
        assertTrue(first.equals(second));
    }

    @Test
    public void rangesNonEqualTest() {
        Range first = new Range(-100, 400);
        Range second = new Range(-100, 399);
        assertFalse(first.equals(second));
    }

    @Test
    public void rangesIntersecWholeTest() {
        Range first = new Range(0, 10);
        Range second = new Range(5, 8);
        assertTrue(first.isIntersect(second) && second.isIntersect(first));
    }

    @Test
    public void rangesIntersectByBoundTest() {
        Range first = new Range(10, 15);
        Range second = new Range(0, 10);
        assertTrue(first.isIntersect(second) && second.isIntersect(first));
    }

    @Test
    public void rangeIncludesSubrangeTest() {
        Range superRange = new Range(0, 10);
        Range subRangeMiddle = new Range(4, 8);

        assertTrue(superRange.includes(subRangeMiddle));
    }

    @Test
    public void rangeDoesNotFullyIncludeLargerTest() {
        //non-inclusion
        Range superRange = new Range(0, 10);
        Range rangeLarger = new Range(8, 11);
        assertFalse(superRange.includes(rangeLarger) || rangeLarger.includes(superRange));
    }

    @Test
    public void rangeDoesNotInclueByNonIntersectionTest() {
        //non-intersection
        Range superRange = new Range(0, 10);
        Range rangeNegative = new Range(-10, -5);
        assertFalse(superRange.includes(rangeNegative) || rangeNegative.includes(superRange));
    }

    @Test
    public void intersectionOfEmptyRangesTest() {
        int[] expected = {};
        Range first = new Range();
        Range second = new Range();
        Range intersect = first.intersection(second);
        assertArrayEquals(expected, intersect.toArray());
    }

    @Test
    public void emptyIntersectionTest() {
        Range first = new Range(0, 5);
        Range second = new Range(6, 8);
        Range intersect = first.intersection(second);
        assertEquals(0, intersect.length);
    }

    @Test
    public void rangeIntersectionTest() {
        int[] expected = {3, 4, 5};
        Range first = new Range(0, 5);
        Range second = new Range(3, 8);
        Range intersect = first.intersection(second);
        assertArrayEquals(expected, intersect.toArray());
    }

    @Test
    public void emptyUnionTest() {
        Range first = new Range();
        Range second = new Range();

        Range union = first.union(second);
        assertEquals(0, union.length);
    }

    @Test
    public void rangeUnionTest() {
        int[] expected = {-3, -2, -1, 0, 1, 2, 3};
        Range first = new Range(-3, 0);
        Range second = new Range(0, 3);
        Range union;
        union = first.union(second);
        assertArrayEquals(expected, union.toArray());
    }

    @Test
    public void rangeUnionIntersectingTest() {
        int[] expected = {-1, 0, 1, 2, 3};
        Range first = new Range(-1, 2);
        Range second = new Range(0, 3);
        Range union = first.union(second);
        assertArrayEquals(expected, union.toArray());
    }

    @Test
    public void rangeUnionNonIntersectingTest() {
        Range first = new Range(-5, 0);
        Range second = new Range(5, 11);
        Exception exception = assertThrows(InvalidRangeException.class, () -> first.union(second));
        assertEquals("invalid range", exception.getMessage());
    }

    @Test
    public void toStringTest() {
        Range range = new Range(-51, 17);
        assertEquals("[-51; 17]", range.toString());
    }

    @Test
    public void toStringZeroTest() {
        Range range = new Range(0, 0);
        assertEquals("[0; 0]", range.toString());
    }

    @Test
    public void toStringEmptyTest() {
        Range range = new Range();
        assertEquals("[]", range.toString());
    }
}

