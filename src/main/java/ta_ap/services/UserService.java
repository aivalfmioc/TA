package ta_ap.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import ta_ap.controllers.RegLogController;
import ta_ap.exceptions.CouldNotWriteUsersException;
import ta_ap.exceptions.UsernameAlreadyExistsException;
import ta_ap.exceptions.UsernameDoesntExistsException;
import ta_ap.exceptions.WrongUsernamePasswordException;
import ta_ap.model.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UserService {

    public static final Path USERS_PATH = FileSystemService.getPathToFile("config","users.json");
    public static List<User> users;
    public static User getUser(){
        for(User user:users){
            if(user.getUsername().equals(RegLogController.getUsernameL()))
                return user;
        }
        return null;
    }
    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(UserService.class.getClassLoader().getResource("users.json")), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }
    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        users.add(new User(username, encodePassword(username, password), role));
        persistUsers();
    }

    public static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }
    public static void saveTable(String landlord,List<Input> schedule){
        for (User user : users) {
           if (Objects.equals(landlord, user.getUsername()))
           {
             //  if(user.getSchedule().size()>0) user.getSchedule().add();

                user.setSchedule(schedule);
           }
        }
        persistUsers();
    }
    public static int manyTable(String landlord){
        for (User user : users) {
            if (Objects.equals(landlord, user.getUsername()))
            {
                if(user.getSchedule().size()>0) return 1;
            }
        }
        return 0;
    }
    public static List<Input> seeTable(String landlord){
        for (User user : users) {
            if (Objects.equals(landlord, user.getUsername()))
            {
                return user.getSchedule();
            }
        }
        return Collections.emptyList();
    }
    private static void checkUserAlreadyExist(String username, String password) throws UsernameDoesntExistsException {
        boolean find = false;
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(encodePassword(username,password),user.getPassword()))
            {  find = true;
               break; }
        }

       if (!find)
           throw  new UsernameDoesntExistsException(username);

    }

    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }
    public static void checkUser(String username, String password,String role) throws UsernameDoesntExistsException{
        checkUserAlreadyExist(username, password);
        users.add(new User(username, encodePassword(username, password), role));
        persistUsers();
    }

    public static void checkUsernameAndPassword(String username, String password) throws WrongUsernamePasswordException {
        boolean find = false;
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(encodePassword(username,password),user.getPassword()))
            {  find = true;
                break; }
        }

        if (!find)
            throw  new WrongUsernamePasswordException(username,password);
    }
   
    public static List<Input> seeCostumer(){
        List<Input> listcostumer=new ArrayList<>();
        for (User user : users) {

            if (Objects.equals("Landlord", user.getRole()))
            {
                 listcostumer.addAll(user.getSchedule());

            }
        }
        return listcostumer;
    }

    public static boolean checkExistsAccommodation(String text) {
        for (User user : users) {
            if (user.getRole().equals("Landlord")) {
                for (Input input : user.getSchedule()) {
                    if (input.getName().equals(text)){
                        addAccommodation(text);
                        return true;}
                }
            }
        }
            return false;
        }

    private static void addAccommodation(String text) {
         for(User user: users){
             if(user.getUsername().equals(RegLogController.getUsernameL()))
                 user.getReservations().add(text);
         }
         persistUsers();
    }

}
