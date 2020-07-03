package Model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import Model.Products;

public class FileManager<T> {

    private String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    private boolean isFileExists() {
        File file = new File(filename);
        return file.exists();
    }

    public void write(List<T> object) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.filename))) {
            objectOutputStream.writeObject(object);
        }
    }

    public List<T> read() throws FileNotFoundException, IOException, ClassNotFoundException {
        if (!isFileExists()) { // Return empty List when file is not exists
           return new ArrayList<>();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.filename)))
        {
            return (List<T>) objectInputStream.readObject();
        }
    }

   public int GetCSVSize(){
       int size=0;
       BufferedReader br = null;
       try
       {
           br = new BufferedReader(new FileReader(filename));
           size=(int)br.lines().count();
           br.close();
       }
       catch (FileNotFoundException e)
       {
           e.printStackTrace();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
       finally
       {
           if (br != null) {
               try {
                   br.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           return size;
       }
   }


    public String[] readCSV(String splitBy) throws FileNotFoundException {
        int i = 0;
        int size=GetCSVSize();
        String csvFile = filename;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String[] productsData=new String[size] ;

        try
        {
            br = new BufferedReader(new FileReader(csvFile));

            //line = br.readLine();
            while ((line = br.readLine()) != null)
            {
                productsData[i++] =line.split(splitBy)[0];;
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return productsData;
        }
    }



    public String GetInfoByIndex(int index) throws FileNotFoundException {
        String productsInfo =null;
        try
        {
                productsInfo = Files.readAllLines(Paths.get(filename)).get(index);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

            return productsInfo;
        }

    public void RemoveFromFile(int index) throws IOException {
        int size=GetCSVSize();
        String tmp;
        String [] products=readCSV("\0");
      //  System.out.println(products[5]);
    //List<Products> products=readCSV();
        FileWriter csvWriter = new FileWriter(filename);


       for (int i=0;i<size;i++) {
           //tmp=products[i].split(",")[0];
           if(i!=index)
           csvWriter.append(products[i]+"\n");

        }

        csvWriter.flush();
        csvWriter.close();

    }

}




