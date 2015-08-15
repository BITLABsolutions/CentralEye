/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Malith
 */
public  class User {
    String password;
    int accessPriviledge;
    String id;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

  


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccessPriviledge() {
        return accessPriviledge;
    }

    public void setAccessPriviledge(int accessPriviledge) {
        this.accessPriviledge = accessPriviledge;
    }
  
}
