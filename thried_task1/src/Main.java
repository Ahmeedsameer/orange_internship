import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    static String folderPath = "D://orange work//task/";
    public static void main(String[] args) {
        List<String> names = Collections.synchronizedList(new ArrayList<>());// itis new way in synchronize
        Thread[] thread=new Thread[5];
        for (int i=0;i<5;i++){
            final int indax =i;
            thread[i]=new Thread(()->{
                try {
                    BufferedReader buffer = new BufferedReader(new FileReader(folderPath + "txt." + indax + ".txt"));
                    String line;
                   while ((line=buffer.readLine())!=null){
                    names.add(line);
                   }
                   Collections.sort(names);
               } catch (Exception e) {
                    System.err.println("Failed to read file: " + folderPath + "txt." + indax + ".txt - " + e.getMessage());
                    System.out.println("Reading file: " + folderPath + "txt." + indax + ".txt");

                }



            }


                    );
            thread[i].start();
        }
        try {


        for (Thread t:thread) {
            t.join();
        }

        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(names);
        System.out.println(names);


    }

}