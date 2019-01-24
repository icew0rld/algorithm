package unclassified;

/**
 * 问题：N皇后问题
 * 解法：逐行递归
 */
public class NQueen {
    public static void main(String[] args) {
        NQueen nq = new NQueen();
        System.out.println(nq.nQueen(1));//1
        System.out.println(nq.nQueen(2));//0
        System.out.println(nq.nQueen(3));//0
        System.out.println(nq.nQueen(4));//2
        System.out.println(nq.nQueen(5));
        System.out.println(nq.nQueen(6));
        System.out.println(nq.nQueen(7));
        System.out.println(nq.nQueen(8));//92
    }

    public int nQueen(int n) {
        int[] record = new int[n];
        return process(record, 0, n);
    }

    /**
     * 第row行，有多少种摆法
     * @param record
     * @param row
     * @param n
     * @return
     */
    private int process(int[] record, int row, int n) {
        if (row == n) {
            //已经放置了n-1行的皇后，表示一次成功的摆法
            return 1;
        }

        //第row行的摆法数量，等于第row行每一列摆放后，第row+1行有多少种摆法
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (isValid(record, row, i)) {
                record[row] = i;
                res += process(record, row + 1, n);
            }
        }
        return res;
    }

    private boolean isValid(int[] record, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == record[i] || Math.abs(row - i) == Math.abs(col - record[i])) {
                return false;
            }
        }
        return true;
    }
}
