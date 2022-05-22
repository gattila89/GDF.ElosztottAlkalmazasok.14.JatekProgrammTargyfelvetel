package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    
    public static void SerializeToFile(Object serObj, String filepath) {
 
        try 
        {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
 
        } catch (IOException ex) {
        }
            
    }
    
    public static Object DeserializeFromFile(File file) throws IOException, ClassNotFoundException {
      Object result = null;
      try (FileInputStream fis = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(fis)) {
          result = ois.readObject();
      }
      return result;
  }
}
