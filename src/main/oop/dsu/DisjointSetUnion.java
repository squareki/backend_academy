package oop.dsu;

public interface DisjointSetUnion {
    public abstract DisjointSet findSet(int number);
    public abstract void union(int first, int second);
    public abstract int size();
    public abstract DisjointSet at(int index);
    public abstract int capacity();
    public abstract int getGreatRoot(int index);
}

