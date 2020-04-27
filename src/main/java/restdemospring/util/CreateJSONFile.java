package restdemospring.util;

import com.google.gson.Gson;
import restdemospring.Friend;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateJSONFile {
    Gson gson = new Gson();
    List<Friend> friendList = new ArrayList<>();

    CreateJSONFile(){
        friendList.add(new Friend("Milkon ", "Elsarostigen2.",     "0723-850674" ,1));
        friendList.add(new Friend("Anto ",   "Fotballsvägen 10.",  "0722-930871", 2));
        friendList.add(new Friend("Khachig ","Okstigen 6.",        "0728-723913", 3));
        friendList.add(new Friend("Sako ",   "Sveavägen 1.",       "0708-702819", 4));
        friendList.add(new Friend("Serop ",  "Byvägen 21.",        "0722-590203", 5));
        friendList.add(new Friend("Sam ",    "Fornhöjdsvägen 27.", "0702-882036", 6));

        String json = gson.toJson(friendList);

        try (FileWriter writer = new FileWriter("C:\\Users\\melko\\IdeaProjects\\REST\\AllFriends.json" );){

            writer.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateJSONFile createJSONFile = new CreateJSONFile();
    }
}
