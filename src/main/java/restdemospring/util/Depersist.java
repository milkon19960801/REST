package restdemospring.util;

import restdemospring.Friend;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Depersist {
    public static void main(String args[])throws Exception{
        ObjectInputStream in= new ObjectInputStream(new FileInputStream("file.txt"));
        Friend friend =(Friend)in.readObject(); //notera castning
        System.out.println(friend.getId()+" "+friend.getName());
        in.close();
    }
}
