package com.desobei.algorithms.util;

/**
 * Tracks metrics for algorithm analysis: time, recursion depth, comparisons, allocations
 */
public class MetricsTracker {
    private int currentDepth = 0;
    private int maxDepth = 0;
    private long comparisons = 0;
    private long allocations = 0;
    private long startTime;

    public MetricsTracker() {
        startTime = System.nanoTime();
    }

    public void enterRecursion() {
        currentDepth++;
        maxDepth = Math.max(maxDepth, currentDepth);
    }

    public void exitRecursion() {
        currentDepth--;
    }

    public void recordComparison() {
        comparisons++;
    }

    public void recordAllocation() {
        allocations++;
    }

    // Getters
    public int getMaxDepth() { return maxDepth; }
    public long getComparisons() { return comparisons; }
    public long getAllocations() { return allocations; }
    public long getElapsedTime() {
        return System.nanoTime() - startTime;
    }

    public void reset() {
        currentDepth = 0;
        maxDepth = 0;
        comparisons = 0;
        allocations = 0;
        startTime = System.nanoTime();
    }

    @Override
    public String toString() {
        return String.format("Metrics{time=%d ns, depth=%d, comparisons=%d, allocations=%d}",
                getElapsedTime(), maxDepth, comparisons, allocations);
    }
}