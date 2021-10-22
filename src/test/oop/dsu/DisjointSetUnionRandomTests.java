package oop.dsu;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DisjointSetUnionRandomTests {
    @Test
    public void DSURandomMakeTest() {
        int[] expected = {1, 2, 3};
        DisjointSetUnionRandom dsu = new DisjointSetUnionRandom(5);

        for (int i = 1; i < 4; i++) {
            assertEquals(expected[i-1], dsu.findSet(i).value());
        }
    }

    @Test
    public void DSURandomFindTest() {
        DisjointSetUnionRandom dsu = new DisjointSetUnionRandom(5);

        assertEquals(4, dsu.findSet(4).getRoot());
    }

    @Test
    public void DSURandomUnionTest() {
        DisjointSetUnionRandom dsu = new DisjointSetUnionRandom(5);

        dsu.union(2, 3);
        int root = dsu.findSet(3).getRoot();
        assertTrue(root == 2 || root == 3);
    }

    @Test
    public void DSURandomFindUnionTest() {
        DisjointSetUnionRandom dsu = new DisjointSetUnionRandom(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        int root = dsu.findSet(4).getRoot();
        assertTrue(root >= 0 && root <= 4);
    }

    @Test
    public void DSURandomSizeTest() {
        DisjointSetUnionRandom dsu = new DisjointSetUnionRandom(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        assertEquals(1, dsu.size());
    }

    @Test
    public void DSURandomGreatRootTest() {
        DisjointSetUnionRandom dsu = new DisjointSetUnionRandom(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        
        // chosen randomly, no guarantee
        int greatRoot = dsu.getGreatRoot(4);
        assertTrue(greatRoot >= 0 && greatRoot <= 4);
    }

    @Test
    public void DSURandomCapacityTest() {
        DisjointSetUnionRandom dsu = new DisjointSetUnionRandom(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        
        assertEquals(5, dsu.capacity());
    }

    @Test
    public void DSURandomAtTest() {
        DisjointSetUnionRandom dsu = new DisjointSetUnionRandom(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        
        DisjointSet expected = new DisjointSet(3, 2);
        assertTrue(expected.value() == dsu.at(3).value() && expected.getRoot() == dsu.at(3).getRoot());
    }
}

