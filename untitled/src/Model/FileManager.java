package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.filename))) {
            return (List<T>) objectInputStream.readObject();
        }
    }
}
