package restdemospring;

import org.springframework.boot.autoconfigure.security.FallbackWebSecurityAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    public List<Friend> getFriendslist() {
        return friendslist;
    }

    private List<Friend> friendslist= new ArrayList<>();
    public DAO()
    {
        friendslist.add(new Friend("Milkon ", "Elsarostigen2.",    "0723-850674",1));
        friendslist.add(new Friend("Anto ",   "Fotballsvägen 10.", "0722-930871",2));
        friendslist.add(new Friend("Khachig ","Okstigen 6.",       "0728-723913",3));
        friendslist.add(new Friend("Sako ",   "Sveavägen 1.",      "0708-702819",4));
        friendslist.add(new Friend("Serop ",  "Byvägen 21.",       "0722-590203",5));
        friendslist.add(new Friend("Sam ",    "Fornhöjdsvägen 27.","0702-882036",6));
    }
    public Friend getFriend(String name)
    {
        for(int i = 0;i<friendslist.size();i++) {
            if(friendslist.get(i).getName().equalsIgnoreCase(name)) {
                return friendslist.get(i);
            }
        }
        return null;
    }
    public Friend getFriendByid(int id)
    {
        for(int i = 0;i<friendslist.size();i++) {
            if(friendslist.get(i).getId() == id) return friendslist.get(i);
        }
        return null;
    }
    public Response deleteFriendByid(int id) {
        Response response;
        for(Friend friend :friendslist) {
            if(friend.getId() == id) {
                friendslist.remove(friend);
                response = new Response("Friend has been deleted successfully ",true);
                return response;
            }
        }

        response = new Response("Friend is not found ",false);
        return response;
    }
    public String getAllFriends()
    {
        StringBuilder stringBuilder = new StringBuilder();
        String allFriends ;
        for(Friend friend:friendslist) {
            stringBuilder.append(friend.getName());
            stringBuilder.append(" ");
            stringBuilder.append(friend.getAddress());
            stringBuilder.append(" ");
            stringBuilder.append(friend.getPhoneNumber());
            stringBuilder.append(" ");
        }
        allFriends = stringBuilder.toString();
        return allFriends;
    }
}
