/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author 2P
 */

class User implements Serializable {

    public String name;
    public String email;
    private String[] roles;
    private boolean admin;

    public User() {
    }

    public User(String name, String email, String[] roles, boolean admin) {
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.admin = admin;
    }

    // getters and setters, toString() .... (omitted for brevity)
}

public class WriteObject {
    
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("object.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // create a new user object
            User user = new User("John Doe", "john.doe@example.com",
                   new String[]{"Member", "Admin"}, true);

            // write object to file
            oos.writeObject(user);

           } catch (IOException ex) {
               ex.printStackTrace();
           }
    }
}
