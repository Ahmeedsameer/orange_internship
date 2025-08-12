import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        MatrixProcessor matrixProcessor = new MatrixProcessor();
            //matrixProcessor.createMatrixFiles();
        int A[][] = matrixProcessor.readmatrix(matrixProcessor.getFile_path() + "\\g0.txt");
        int b[][] = matrixProcessor.readmatrix(matrixProcessor.getFile_path() + "\\g1.txt");
        int c[][] = matrixProcessor.multiplyMatrices(A, b);
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}