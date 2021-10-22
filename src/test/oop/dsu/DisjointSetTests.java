package oop.dsu;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class DisjointSetTests {
    @Test
    public void DSGetRootTest() {
        DisjointSet s = new DisjointSet(1);
        assertEquals(1, s.getRoot());
    }

    @Test
    public void DSSetRootTest() {
        DisjointSet s = new DisjointSet(1);
        s.setRoot(0);
        assertEquals(0, s.getRoot());
    }

    @Test
    public void DSValueTest() {
        DisjointSet s = new DisjointSet(1);
        s.setRoot(0);
        assertEquals(1, s.value());
    }


    @Test
    public void DSEqualsTest() {
        int size = 5;
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(size);
        dsu.union(0, 1);
        dsu.union(2, 3);
        dsu.union(1, 3);
        DisjointSet first = dsu.at(0);
        DisjointSet second = dsu.at(3);
        assertTrue(first.equals(dsu, second));
    }
    
    @Test
    public void DSNaiveSizeTest() {
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(3, 4);
        assertEquals(5, dsu.at(0).size(dsu));
    }

    @Test
    public void DSNaiveRandomTest() {
        DisjointSetUnionNaive dsu = new DisjointSetUnionNaive(5);
        Random random = new Random();
        dsu.union(0, 1);
        dsu.union(1, 2);
        int randomValue = dsu.at(2).getRandom(dsu, random);
        assertTrue(randomValue >= 0 && randomValue <= 2);
    }
}

