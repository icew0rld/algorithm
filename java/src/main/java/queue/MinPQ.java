package queue;

public class MinPQ<Key extends Comparable<Key>> {
    private int n;
    private Key[] pq;
    public MinPQ(int maxN) {
        n = 0;
        pq = (Key[])new Comparable[maxN + 1];

    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    public void insert(Key v) {
        pq[++n] = v;
        swim(n);
    }
    public Key delMin() {
        Key min = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);
        return min;
    }
    private boolean larger(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    private void swim(int k) {
        while (k > 1 && larger(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && larger(j, j + 1)) {
                j++;
            }
            if (!larger(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<>(5);
        pq.insert(5);
        pq.insert(3);
        pq.insert(4);
        pq.insert(1);
        pq.insert(2);
        for (int i = 0; i < 5; i++) {
            System.out.print(pq.delMin() + " ");
        }
    }
}
