package DBUtils;

import Model.Objects.Products;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager<T> {


    public FileManager(){}

    public void write(List<T> object, String fileName) throws IOException
    {
        File file = new File(fileName);
        if(!file.exists())
            file.createNewFile();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            objectOutputStream.writeObject(object);
        }
    }

    public List<T> read(String fileName) throws  IOException, ClassNotFoundException
    {
        File file = new File(fileName);
        if(!file.exists())
            return new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName)))
        {
            return (List<T>) objectInputStream.readObject();
        }
    }

   public int GetCSVSize(String fileName){
       int size=0;
       BufferedReader br = null;
       try
       {
           br = new BufferedReader(new FileReader(fileName));
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


    public String[] ReadFromCSV(String splitBy, String fileName) throws FileNotFoundException {
        int i = 0;
        int size=GetCSVSize(fileName);
        String csvFile = fileName;
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
    public static void WriteToCSV(Products product, String fileName) throws IOException
    {
        List<List<String>> rows = Arrays.asList
                (
                        Arrays.asList(product.getProduct_name(), product.getProduct_quantity(), product.getExpiration_day())
                );
        File file = new File(fileName);
        if(!file.exists())
            System.out.println("file " +fileName+ " does not exist!");
        FileWriter csvWriter = new FileWriter(fileName, true);

        for (List<String> rowData : rows) {
            csvWriter.write(String.join(",", rowData));
            csvWriter.write("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }


    public String GetInfoByIndex(int index, String fileName) throws FileNotFoundException {
        String productsInfo =null;
        try
        {
                productsInfo = Files.readAllLines(Paths.get(fileName)).get(index);
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

    public void RemoveFromFile(int index, String fileName) throws IOException {
        int size=GetCSVSize(fileName);
        String tmp;
        String [] products= ReadFromCSV("\0", fileName);
        FileWriter csvWriter = new FileWriter(fileName);


       for (int i=0;i<size;i++) {
           //tmp=products[i].split(",")[0];
           if(i!=index)
           csvWriter.append(products[i]+"\n");

        }

        csvWriter.flush();
        csvWriter.close();

    }

}




