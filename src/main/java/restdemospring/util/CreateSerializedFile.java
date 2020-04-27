package restdemospring.util;

import restdemospring.Friend;

import java.util.ArrayList;
import java.util.List;

public class CreateSerializedFile {
    SerializationManager serializationManager = new SerializationManager();
    List<Friend> friendList = new ArrayList<>();

    CreateSerializedFile()
    {
        friendList.add(new Friend("Milkon ", "Elsarostigen2.",     "0723-850674" ,1));
        friendList.add(new Friend("Anto ",   "Fotballsvägen 10.",  "0722-930871", 2));
        friendList.add(new Friend("Khachig ","Okstigen 6.",        "0728-723913", 3));
        friendList.add(new Friend("Sako ",   "Sveavägen 1.",       "0708-702819", 4));
        friendList.add(new Friend("Serop ",  "Byvägen 21.",        "0722-590203", 5));
        friendList.add(new Friend("Sam ",    "Fornhöjdsvägen 27.", "0702-882036", 6));

        serializationManager.serializeList(friendList,"Friendfile.ser");
    }

    public static void main(String[] args) {
        CreateSerializedFile createSerializedFile = new CreateSerializedFile();
    }

}
