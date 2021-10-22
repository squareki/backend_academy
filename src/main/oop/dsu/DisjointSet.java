package oop.dsu;

import java.util.Random;

public class DisjointSet {
    private int rootIndex;
    private int val;

    public DisjointSet(int number, int rootIndex) {
        this.rootIndex = rootIndex;
        this.val = number;
    }

    public DisjointSet(int number) {
        this(number, number);
    }

    public DisjointSet() {
        this(0, 0);
    }

    public void setRoot(int rootIndex) {
        this.rootIndex = rootIndex;
    }
    
    public int getRoot() {
        return this.rootIndex;
    }

    public int value() {
        return this.val;
    }

    public int size(DisjointSetUnion dsu) {
        int target = dsu.getGreatRoot(this.value());
        int count = 0;
        for (int i = 0; i < dsu.capacity(); i++) {
            int greatRoot = dsu.getGreatRoot(i);

            if (greatRoot == target)
                count++;
        }

        return count;
    }

    public boolean equals(DisjointSetUnion dsu, DisjointSet second) {
        int firstGreatRoot = this.getRoot();
        int secondGreatRoot = second.getRoot();
        if (firstGreatRoot == secondGreatRoot)
            return true;

        firstGreatRoot = dsu.getGreatRoot(firstGreatRoot);

        secondGreatRoot = dsu.getGreatRoot(secondGreatRoot);

        return firstGreatRoot == secondGreatRoot ? true : false;
    }

    public int getRandom(DisjointSetUnion dsu, Random random) {
        int iterations = random.nextInt(this.size(dsu));
        int cur = this.val;
        for (int i = 0; i < iterations; i++) {
            cur = dsu.findSet(cur).value();
        }
        return cur;
    }
    
}

