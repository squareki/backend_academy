package tdd.range;

import java.io.PrintStream;
import java.lang.Math;

public class Range {
    public final int length;
    public final int leftBound;
    public final int rightBound;

    public Range(int leftBound, int rightBound) {
        int length = rightBound - leftBound + 1;
        this.length = leftBound <= rightBound ? length : 0;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    public Range() {
        this.length = 0;
        this.leftBound = 0;
        this.rightBound = 0;
    }

    public int[] toArray() {
        int[] interval = new int[length];
        for (int i = 0; i < interval.length; i++) {
            interval[i] = leftBound + i;
        }
        return interval;
    }

    public Integer getMax() {
        return this.isEmpty() ? null : this.rightBound;
    }

    public Integer getMin() {
        return this.isEmpty() ? null : this.leftBound;
    }

    public Boolean isEmpty() {
        return this.length == 0 ? true : false;
    }

    public Boolean contains(int number) {
        return (this.leftBound <= number && number <= this.rightBound) ? true : false;
    }

    public Boolean equals(Range second) {
        return (this.leftBound == second.leftBound && this.rightBound == second.rightBound) ? true : false;
    }

    public Boolean isIntersect(Range second) {
        return (this.leftBound <= second.rightBound && this.rightBound >= second.leftBound) ? true : false;
    }

    public Boolean includes(Range second) {
        return (this.leftBound <= second.leftBound && second.rightBound <= this.rightBound) ? true : false;
    }

    public Range intersection(Range second) {
        if (this.length == 0 || second.length == 0 || !isIntersect(second))
            return new Range();
        else {
            int iLeftBound = Math.max(this.leftBound, second.leftBound);
            int iRightBound = Math.min(this.rightBound, second.rightBound);
            return new Range(iLeftBound, iRightBound);
        }
    }

    public Range union(Range second) throws InvalidRangeException {
        if (!isIntersect(second))
            throw new InvalidRangeException("invalid range");

        if (this.length == 0 || second.length == 0)
            return new Range();
        
        int iLeftBound = Math.min(this.leftBound, second.leftBound);
        int iRightBound = Math.max(this.rightBound, second.rightBound);
        return new Range(iLeftBound, iRightBound);
    }

    public void print(PrintStream printer) {
        if (this.length == 0)
            return;

        for (int number = this.leftBound; number <= this.rightBound; number++)
        {
            printer.printf("%d ", number);
        }
    }

    public String toString() {
        return String.format(this.isEmpty() ? "[]" : "[%d; %d]", this.leftBound, this.rightBound);
    }
}

