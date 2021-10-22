package oop.dsu;

public class DisjointSetUnionNaive implements DisjointSetUnion {
    private DisjointSet[] parent;
    private int size;
    private final int capacity;

    public DisjointSetUnionNaive(int size) {
        this.capacity = size;
        this.size = size;
        this.parent = new DisjointSet[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = new DisjointSet(i);
        }
    }

    @Override
    public DisjointSet findSet(int number) {
        if (number == parent[number].value())
            return parent[number];

        return findSet(parent[number].value());
    }

    @Override
    public void union(int first, int second) {
        int firstRoot = findSet(first).value();
        int secondRoot = findSet(second).value();
        if (firstRoot != secondRoot) {
            parent[secondRoot].setRoot(firstRoot);
            this.size--;
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

