/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sachi
 */
public class User {
   private int Id;
   private String Name;
   private String password;

    public User(int Id, String Name, String password) {
        this.Id = Id;
        this.Name = Name;
        this.password = password;
    }


   
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
