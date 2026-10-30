import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Experiment 1: Matrix multiplication using InputStreamReader and BufferedReader.
 */
public class MatrixMultiplication {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] readMatrix(String name, int r, int c) throws IOException {
        int[][] m = new int[r][c];
        System.out.println("Enter elements of Matrix " + name + " (" + r + "x" + c + "), row by row:");
        for (int i = 0; i < r; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            for (int j = 0; j < c; j++) {
                m[i][j] = Integer.parseInt(parts[j]);
            }
        }
        return m;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter rows and columns of Matrix A: ");
        String[] a = br.readLine().trim().split("\\s+");
        int r1 = Integer.parseInt(a[0]), c1 = Integer.parseInt(a[1]);

        System.out.print("Enter rows and columns of Matrix B: ");
        String[] b = br.readLine().trim().split("\\s+");
        int r2 = Integer.parseInt(b[0]), c2 = Integer.parseInt(b[1]);

        if (c1 != r2) {
            System.out.println("Multiplication not possible: columns of A must equal rows of B.");
            return;
        }

        int[][] A = readMatrix("A", r1, c1);
        int[][] B = readMatrix("B", r2, c2);
        int[][] C = new int[r1][c2];

        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    C[i][j] += A[i][k] * B[k][j];

        System.out.println("Resultant Matrix (A x B):");
        for (int[] row : C) {
            for (int v : row) System.out.print(v + "\t");
            System.out.println();
        }
    }
}
