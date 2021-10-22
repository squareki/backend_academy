package oop.dsu;

import java.util.Random;

public class DisjointSetUnionRandom implements DisjointSetUnion {
    private DisjointSet[] parent;
    private int[] index;
    private Random random;
    private int size;
    private final int capacity;

    public DisjointSetUnionRandom(int size) {
        this.capacity = size;
        this.size = size;
        this.random = new Random();
        this.parent = new DisjointSet[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = new DisjointSet(i);
        }
        this.index = new int[size];
        for (int i = 0; i < size; i++) {
            index[i] = this.random.nextInt();
        }
    }

    @Override
    public DisjointSet findSet(int number) {
        if (number == parent[number].value())
            return parent[number];

        parent[number].setRoot(findSet(parent[number].getRoot()).getRoot());
        return parent[number];
    }

    @Override
    public void union(int first, int second) {
        int firstRoot = findSet(first).value();
        int secondRoot = findSet(second).value();
        if (firstRoot != secondRoot) {
            if (index[firstRoot] < index[secondRoot]) {
                int t = second;
                firstRoot = secondRoot;
                secondRoot = t;
            }
            parent[secondRoot].setRoot(firstRoot);

            size--;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }
    
    @Override
    public DisjointSet at(int index) {
        return parent[index];
    }

    @Override
    public int getGreatRoot(int index) {
        // findSet(index) -- searches for next root
        // search until previous root == next root
        // which means we are at tree root
        while (this.findSet(index).getRoot() != index)
            index = this.findSet(index).getRoot();
        return index;
    }
}

