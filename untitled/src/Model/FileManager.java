package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    public String[] readCSV()
    {
        int i = 0;
        String csvFile = filename;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\n";
        String[] productsData = new String[3];
        String[] tmp = new String[3];
        try
        {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
            {
                tmp = line.split(cvsSplitBy);
                productsData[i++] =tmp[0];
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
}
