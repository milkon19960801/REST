package restdemospring.util;

import restdemospring.Friend;

import java.util.ArrayList;
import java.util.List;

public class ReadingFromSerializedFile {


    public static void main(String[] args) {
        SerializationManager serializationManager = new SerializationManager();
        List<Friend> friendList= new ArrayList<>();
        friendList = (List<Friend>)serializationManager.deSerializedList("Friendfile.ser");
        friendList.forEach(friend-> System.out.println(friend.getName()+"id:"+friend.getId()));
    }
}
