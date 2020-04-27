package restdemospring.util;

import restdemospring.Friend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationManager {
    public void serializeList(List<Friend> list,String filePath) {
        try(FileOutputStream fileOutput = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutput);) {

            objectOutputStream.writeObject(list);
            System.out.println("Friend list saved to"+filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Friend> deSerializedList(String filePath)
    {
        System.out.println("deSerializedList "+ filePath);
        List<Friend>list = new ArrayList<Friend>();
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            list = (List<Friend>) objectInputStream.readObject();
            System.out.println("deserialize "+list.size()+" friends");
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
