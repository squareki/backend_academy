package oop.dsu;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DisjointSetUnionNaiveTests {
    @Test
    public void DSUNaiveMakeTest() {
        int[] expected = {1, 2, 3};
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);

        for (int i = 1; i < 4; i++) {
            assertEquals(expected[i-1], dsu.findSet(i).value());
        }
    }

    @Test
    public void DSUNaiveFindTest() {
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);

        assertEquals(4, dsu.findSet(4).getRoot());
    }

    @Test
    public void DSUNaiveUnionTest() {
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);

        dsu.union(2, 3);
        assertEquals(2, dsu.findSet(3).getRoot());
    }

    @Test
    public void DSUNaiveFindUnionTest() {
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        assertEquals(3, dsu.findSet(4).getRoot());
    }

    @Test
    public void DSUNaiveSizeTest() {
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        assertEquals(1, dsu.size());
    }

    @Test
    public void DSUNaiveGreatRootTest() {
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        
        assertEquals(0, dsu.getGreatRoot(4));
    }

    @Test
    public void DSUNaiveCapacityTest() {
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        
        assertEquals(5, dsu.capacity());
    }

    @Test
    public void DSUNaiveAtTest() {
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        
        DisjointSet expected = new DisjointSet(3, 2);
        assertTrue(expected.value() == dsu.at(3).value() && expected.getRoot() == dsu.at(3).getRoot());
    }
}

