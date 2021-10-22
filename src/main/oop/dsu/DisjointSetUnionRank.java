package oop.dsu;

public class DisjointSetUnionRank implements DisjointSetUnion {
    private DisjointSet[] parent;
    private int[] rank;
    private int size;
    private final int capacity;

    public DisjointSetUnionRank(int size) {
        this.capacity = size;
        this.size = size;
        this.parent = new DisjointSet[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = new DisjointSet(i);
        }
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            rank[i] = 0;
        }
    }

    @Override
    public DisjointSet findSet(int number) {
        if (number == parent[number].getRoot())
            return parent[number];

        parent[number].setRoot(findSet(parent[number].getRoot()).getRoot());
        return parent[number];
    }

    @Override
    public void union(int first, int second) {
        int firstRoot = findSet(first).value();
        int secondRoot = findSet(second).value();
        if (firstRoot != secondRoot) {
            if (rank[firstRoot] < rank[secondRoot]) {
                int t = firstRoot;
                firstRoot = secondRoot;
                secondRoot = t;
            }
            parent[secondRoot].setRoot(firstRoot);
            if (rank[firstRoot] == rank[secondRoot])
                rank[firstRoot]++;

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

