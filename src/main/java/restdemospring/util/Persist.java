package restdemospring.util;

import restdemospring.Friend;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Persist {
    public static void main(String args[])throws Exception{
        Friend friend =new Friend("Milkon","Elsarostigen 2","0723-850674",1);
        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("file.txt"));
        out.writeObject(friend);
        out.flush();
        System.out.println("success");
    }
}
