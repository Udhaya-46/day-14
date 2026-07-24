import java.util.*;

class MedianFinder {

    // Max heap for smaller half
    PriorityQueue<Integer> left;

    // Min heap for larger half
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Add to left heap first
        left.offer(num);

        // Balance: largest in left should be <= smallest in right
        if (!right.isEmpty() && left.peek() > right.peek()) {
            right.offer(left.poll());
        }

        // Keep size difference at most 1
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}