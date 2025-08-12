import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MatrixProcessor
{
     String files_name;
     int number_of_files;
     private String file_path ="D://orange work//task2//files";
     int rows1;
     int rows2;
     int cols1;
     int cols2;
//     public void createMatrixFiles(){// this method i will do it to generate files it work but have bug in path with method that read i will solve it later so i do this method comment
//        Scanner scanner=new Scanner(System.in);
//        System.out.print("Enter base file name: ");
//        files_name=scanner.nextLine();
//        System.out.print("Enter number of files: ");
//        number_of_files=scanner.nextInt();
//        System.out.print("Enter rows for Matrix 1: ");
//        rows1=scanner.nextInt();
//        System.out.print("Enter columns for Matrix 1: ");
//        cols1 = scanner.nextInt();
//        System.out.print("Enter rows for Matrix 2: ");
//        rows2 = scanner.nextInt();
//        System.out.print("Enter columns for Matrix 2: ");
//        cols2 = scanner.nextInt();
//        if (cols1!=rows2){
//            System.out.println("Cannot multiply: columns of Matrix 1 != rows of Matrix 2");
//        }
//        else {
//            File directory = new File(file_path);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//            Random random =new Random();
//            try {
//                for (int i = 0; i < number_of_files; i++) {
//                    File file = new File(file_path, files_name + i + ".txt");
//                    if (file.createNewFile()) {
//                        System.out.println("File created: " + file.getName());
//                    } else {
//                        System.out.println("File already exists: " + file.getName());
//                    }
//                    FileWriter writer = new FileWriter(file);
//
//                    if (i % 2 == 0) {
//                        writer.write("Matrix 1:\n");
//                        for (int r=0; r<rows1; r++) {
//                            for (int c=0; c<cols1; c++) {
//                                writer.write(random.nextInt(100) + " ");
//                            }
//                            writer.write("\n");
//                        }
//                    } else {
//                        writer.write("Matrix 2:\n");
//                        for (int r=0; r<rows2; r++) {
//                            for (int c=0; c<cols2; c++) {
//                                writer.write(random.nextInt(100) + " ");
//                            }
//                            writer.write("\n");
//                        }
//                    }
//                    writer.close();
//                }
//
//
//            } catch (IOException e) {
//                System.out.println("Error when creating/writing file: " + e.getMessage());
//            }
//
//        }
//    }
    public  int[][] readmatrix(String file_path) throws FileNotFoundException {
        ArrayList<int[]>rowlist=new ArrayList<>();
        Scanner reader=new Scanner(new File(file_path));
        while (reader.hasNextLine()){
            String line=reader.nextLine().trim();
            if (line.isEmpty() || line.equals("Matrix 1:") || line.equals("Matrix 2 :")) {
                continue;
            }
            String[]number=line.trim().split("\\s+");
            int[]row=new int[number.length];
            for (int i=0; i<number.length;i++){
                row[i]=Integer.parseInt(number[i]);
            }
            rowlist.add(row);
        }
        int [][]matrix =new int[rowlist.size()][];
        for (int i=0;i<rowlist.size();i++){
            matrix[i]=rowlist.get(i);
        }
        reader.close();
        return matrix;

    }
    public int[][] multiplyMatrices(int[][] matrixa,int[][] matrixb) throws InterruptedException {
         int rowa=matrixa.length;
         int colsa=matrixa[0].length;
         int colsb=matrixb[0].length;
         int [][]c=new int [rowa][colsb];
         Thread[] thread=new Thread[rowa];
         for (int i=0;i<rowa;i++){
             final int row=i;
             thread[i]=new Thread(()->{
                 for (int j=0 ;j<colsb;j++){
                        int sum=0 ;
                        for (int k=0;k<colsa;k++) {
                            sum += matrixa[row][k] *matrixb[k][j];
                        c[row][j]=sum;
                        }
                 }
             }
             );
             thread[i].start();

         }
         for (Thread t:thread){
             t.join();
         }
     return c;
     }
    public String getFile_path() {
        return file_path;
    }
}
