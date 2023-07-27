package com.major.selftest11.data;

import com.major.selftest11.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsersFakeDAO implements UsersDataAccessInterface{
    List<User> users = new ArrayList<>();

    // 初始化UsersFakeDAO的时候创建对象加入链表
    public UsersFakeDAO()
    {
        users.add(new User(1L, "yasuo012", "12345678", 18, 1500.0f));
        users.add(new User(2L, "george13", "mj15678732", 21, 1200.0f));
        users.add(new User(3L, "john021", "john123", 24, 1560.0f));
        users.add(new User(4L, "shawn32", "178966775nkm", 13, 500.0f));
        users.add(new User(5L, "stephen14", "2345klm", 12, 3500.0f));
    }
    @Override
    public List<User> getAllEmployees() {
        return users;
    }

    @Override
    public User getByEmployeeID(long id) {
        for(int i = 0 ; i < users.size() ; i++)
        {
            if(users.get(i).getEmployeeNO() == id)
            {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public List<User> searchUser(String searchTerm) {
//        List<User> foundUser = new ArrayList<>();
//        for(int i = 0; i < users.size() ; i++)
//        {
//            if(users.get(i).getUsername().toLowerCase().contains(searchTerm)){
//                foundUser.add(users.get(i));
//            }
//        }
//
//        if(foundUser.size() > 0)
//        {
//            return foundUser;
//        }
//        else{
//            return null;
//        }

        List<User> foundUsers = users.stream()
                .filter(user -> user.getUsername().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());
        return foundUsers;
    }

    @Override
    public long addNewUser(User newUser) {
        boolean success = users.add(newUser);
        if(success)
        {
            return 1;
        }else
        {
            return 0;
        }
    }

    @Override
    public boolean deleteUser(long id) {
        for(int i = 0 ; i < users.size(); i++)
        {
            if(users.get(i).getEmployeeNO() == id)
            {
                users.remove(users.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public User update(long id, User user) {
        for(int i = 0 ; i < users.size() ; i++)
        {
            if(users.get(i).getEmployeeNO() == id)
            {
                users.set(i, user);
                return users.get(i);
            }
        }
        return null;
    }
}
