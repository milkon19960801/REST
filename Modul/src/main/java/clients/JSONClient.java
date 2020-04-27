package clients;

import models.Friend;
import models.Response;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JSONClient {
    private static void getFriendsAsJsonString() {
        final String url = "http://localhost:8080/Friends.json";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        System.out.println(result);
    }
    private static Friend getFriendByid(int id) {
        final String url = "http://localhost:8080/FriendByID?id={id}";
        Map<String ,Integer> params = new HashMap<>();
        params.put("id",id);
        RestTemplate restTemplate = new RestTemplate();
        Friend result = restTemplate.getForObject(url,Friend.class,params);
        return result;
    }
    private static Friend deleteFriendByid(int id) {
        final String url = "http://localhost:8080/Friend/{id}/delete";
        Map<String ,Integer> params = new HashMap<>();
        params.put("id",id);
        RestTemplate restTemplate = new RestTemplate();
        Friend result = restTemplate.getForObject(url,Friend.class,params);
        return result;
    }
    private static Boolean checkIfFriendExists(int id) {
        final String url = "http://localhost:8080/FriendByID?id={id}";
        Map<String ,Integer> params = new HashMap<>();
        params.put("id",id);
        RestTemplate restTemplate = new RestTemplate();
        Friend result = restTemplate.getForObject(url,Friend.class,params);
        if(result != null)
            return true;
        else
            return false;
    }
    private static Response addFriend(Friend friend)
    {
        final String url = "http://localhost:8080/Friend/add";
        Friend newfriend = friend;
        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.postForObject(url,newfriend,Response.class);
        return response;
    }
    private static Friend createFriend()
    {
        Scanner scanner = new Scanner(System.in);
        String address,phoneNumber;int id;

        System.out.println("Please enter friend name: ");
        String name = scanner.nextLine();


        System.out.println("Please enter friend address: ");
        address = scanner.nextLine();

        System.out.println("Please enter friend phone number: ");
        phoneNumber = scanner.nextLine();

        System.out.println("Please enter friend id");
        id = scanner.nextInt();

        Friend  friend = new Friend(name,address,phoneNumber,id);

        return friend;
    }
    private static Friend uppdateFriend()
    {
        Scanner scanner = new Scanner(System.in);
        String address,phoneNumber;int id;

        System.out.println("Please update friend name: ");
        String name = scanner.nextLine();


        System.out.println("Please update friend address: ");
        address = scanner.nextLine();

        System.out.println("Please update friend phone number: ");
        phoneNumber = scanner.nextLine();

        System.out.println("Please update friend id");
        id = scanner.nextInt();

        Friend  friend = new Friend(name,address,phoneNumber,id);

        return friend;
    }

    private static void upsertFriend()
    {
        int id;
        System.out.println("Please enter friend id: ");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        if(checkIfFriendExists(id) == false) {
            addFriend(createFriend());
            return;
        }
        else if(checkIfFriendExists(id) == true)
        {
           deleteFriendByid(id);
            addFriend(uppdateFriend());
        }

    }





    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("1:Search friend.\n2:Add friend\n3:Update friend\n" +
                    "4:Delete friend\n5:Show all friends");
            int choice,friendId;
            choice= scanner.nextInt();
            switch (choice)
            {
                case 1: {
                    System.out.println("Please enter friend id");
                    friendId = scanner.nextInt();
                    Friend friend = getFriendByid(friendId);
                    System.out.println("Name: "+friend.getName()+"\n"+"Address: "+friend.getAddress()+
                            "\n"+"Phone number: "+friend.getPhoneNumber()+"\n"+"Id: "+friend.getId());
                    break;
                }
                case 2: {
                    Friend friend = createFriend();
                    Response response =  addFriend(friend);
                    System.out.println(response.getMessage()+" "+"friend created successfully"+response.getStatus());
                    break;
                }
                case 3: {
                    upsertFriend();
                    break;
                }
                case 4: {
                    int id ;
                    System.out.println("Please enter friend id to delete: ");
                    id =  scanner.nextInt();
                    deleteFriendByid(id);
                    break;
                }
                case 5: {
                    getFriendsAsJsonString();
                    break;
                }
            }

        }

    }
}
