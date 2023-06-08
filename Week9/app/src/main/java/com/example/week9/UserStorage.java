package com.example.week9;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class UserStorage {
    private ArrayList<User> users = new ArrayList<User>();
    private static UserStorage userstorage = null;

    private UserStorage() {
    }

    public static UserStorage getInstance() {
        if (userstorage == null) {
            userstorage = new UserStorage();
        }
        return userstorage;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        sort();
    }

    public void sort(){
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user, User user2) {
                return user.getLastname().compareToIgnoreCase(user2.getLastname());
            }
        });
    }


    public void removeUser(int id) {
        users.remove(id);
    }

    public void saveUsers(Context context) {
        try {
            ObjectOutputStream OOPS = new ObjectOutputStream(context.openFileOutput("Users.data", Context.MODE_PRIVATE));
            OOPS.writeObject(users);
            OOPS.close();
        } catch (IOException e) {
            Toast.makeText(context, "Saving Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void loadUsers(Context context) {
        try {
            ObjectInputStream OIPS = new ObjectInputStream(context.openFileInput("Users.data"));
            users = (ArrayList<User>) OIPS.readObject();
            OIPS.close();
        } catch(FileNotFoundException e1) {
            Toast.makeText(context, "File not found", Toast.LENGTH_SHORT).show();
        }catch(IOException e2) {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }catch(ClassNotFoundException e3) {
            Toast.makeText(context, "Class not found?", Toast.LENGTH_SHORT).show();
        }
    }

}
