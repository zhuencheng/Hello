# hello
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 
public class Crawler1 {
    public static void main(String[] args) {
        System.out.println(countDirFileLine(new File("E:\\OA\\src\\cn\\oa")));
    }



public static int countDirFileLine(File dir)
    {
        int count = 0;
         
        File[] files = dir.listFiles();
         
        for (File file : files) {
             
            if(file.isFile()&&file.getName().endsWith(".java"))
            {
                count+=countFileLine(file);
            }
            else if(file.isDirectory())
            {
                count+= countDirFileLine(file);
            }
        }
         
        return count;
    }


public static int countFileLine(File file)
    {
        int count = 0;
        BufferedReader bufferedReader = null;
        try {
        bufferedReader = new BufferedReader(new FileReader(file));
         
        while(bufferedReader.readLine()!=null)
        {
            count++;
        }
         
        } catch (Exception e) {
 
            e.printStackTrace();
        }finally
        {
            if(bufferedReader!=null)
            {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }
}
this is a test
