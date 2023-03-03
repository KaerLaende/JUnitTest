package org.example.HomeWork;


import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String email;
    public static ArrayList<User> users = new ArrayList<>();

    public User() {// я не могу представить когда такое может понадобится
        // и как это будет работать при условии что два дефолтных юзера вдруг залогинятся
        this.login = "noob";
        this.email = "noob@noobnui.noobs";
    }

    public User(String login, String email) {
        this.login = login;
        this.email = email;
        users.add(this);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "login='" + login + '|' +
                ", email='" + email;
    }
}
