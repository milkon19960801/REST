package restdemospring.controllers;

import org.springframework.web.bind.annotation.*;
import restdemospring.DAO;
import restdemospring.Friend;
import restdemospring.Response;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {
    DAO dataBase = new DAO();

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/hello")
    public String addFoo(@RequestParam String firstname, @RequestParam String lastname) { return "Hejsan " + firstname + " " + lastname; }

    @RequestMapping("/helloOptional")
    public String helloOptional(@RequestParam(required = false) String firstname,
                                @RequestParam(required = false) String lastname) {
        String name = "milkon";
        if (firstname != null){
            name = firstname;
        }
        if (lastname != null){
            if (name.length() == 0) name = lastname;
            else  name += " "+lastname;
        }
        return "Hej " + name;
    }

    @RequestMapping("/swedish")
    public String swedish() {
            return "Hejsan ";
    }
    @RequestMapping("/english")
    public String english(  ) {
            return "Hello";
    }
    @RequestMapping("/arabic")
    public String arabic(  ) {
        return "مرحبا";
    }
    @RequestMapping("/armenian")
    public String armenian(  ) {
        return "Բարեւ Ձեզ";
    }
    @RequestMapping("/Land")
    public String landOptional(@RequestParam(defaultValue = "Sweden") String home) {
        return "I am from "+home;
    }

    @RequestMapping("/listGreeting")
    public String listHello(@RequestParam List<String> names) {
        return "<h1>Hello!  " + names+"</h1>"; } // med html taggar funkar utan också.http://localhost:8080/listGreeting?names=(Milkon,sako,khachig)

    @RequestMapping("/Friend")
    public Friend Friend(@RequestParam String name) { return dataBase.getFriend(name); }

    @RequestMapping("/FriendByID")
    public Friend getFriendById(@RequestParam int id) { return dataBase.getFriendByid(id); }

    @RequestMapping("/Friend/{id}/delete")
    public Response deleteFriendById(@PathVariable("id") int id) { return dataBase.deleteFriendByid(id); }

    @RequestMapping(value = "/FriendJson",headers = "Accept=application/json")
    public Friend FriendJSpon(@RequestParam String name) {
        Friend friend =  dataBase.getFriend(name);
        return new Friend(friend.getName(),friend.getAddress(),friend.getPhoneNumber(),friend.getId());
    }

    @RequestMapping(value = "/FriendXml",produces = "application/xml")
    public Friend FriendXml(@RequestParam String name) {
        Friend friend = dataBase.getFriend(name);
        return new Friend(friend.getName(),friend.getAddress(),friend.getPhoneNumber(),friend.getId());
    }

    @RequestMapping(value = "/FriendsXml",produces = "application/xml")
    public List<Friend> AllFriendXml() { return dataBase.getFriendslist(); }

    @RequestMapping(value = "/Friends")
    public List<Friend> Friends() { return dataBase.getFriendslist(); }

    @RequestMapping(value = "/FriendsJson",headers = "Accept=application/json")
    public List<Friend> AllFriendJson() { return dataBase.getFriendslist(); }

    @RequestMapping("/swedishhtml")
    public String swedishHtml() { return "<html><body><h1 style=\"color:red;\">Hejsan!</h1><p style=\"color:blue;\">Milkon heter jag.</p><h5>"+dataBase.getAllFriends()+"</h5></body></html>"; }



    @PostMapping("/Friend/add")
    public Response addFriend(@RequestBody Friend friend){
        dataBase.getFriendslist().add(friend);
        Response response = new Response("Friend added successfully",true);
        return response;
    }

    @PostMapping("/Friend/upsert")
    public Response upsertFriend(@RequestBody Friend friend){
        boolean foundId = false;
        for(Friend fri: dataBase.getFriendslist())
        {
            if(fri.getId() == friend.getId()) {
                fri.setName(friend.getName());
                fri.setAddress(friend.getAddress());
                fri.setPhoneNumber(friend.getPhoneNumber());
                foundId = true;
            }
        }
        if(foundId == false)
        {
            dataBase.getFriendslist().add(friend);
        }

        Response response = new Response("Friend added successfully",true);
        return response;
    }

}