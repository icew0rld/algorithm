package matrix;

/**
 * 问题：转圈打印矩阵
 */
public class CirclePrinter {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        CirclePrinter cp = new CirclePrinter();
        cp.circlePrintMatrix(a);
    }

    public void circlePrintMatrix(int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return;
        }
        int colMin = 0;
        int colMax = a[0].length - 1;
        int rowMin = 0;
        int rowMax = a.length - 1;
        while (rowMin <= rowMax && colMin <= colMax) {
            for (int i = colMin; i < colMax; i++) {
                System.out.print(a[rowMin][i] + " ");
            }
            for (int i = rowMin; i < rowMax; i++) {
                System.out.print(a[i][colMax] + " ");
            }
            for (int i = colMax; i > colMin; i--) {
                System.out.print(a[rowMax][i] + " ");
            }
            for (int i = rowMax; i > rowMin; i--) {
                System.out.print(a[i][colMin] + " ");
            }
            colMin++;
            colMax--;
            rowMin++;
            rowMax--;
        }
    }
}
