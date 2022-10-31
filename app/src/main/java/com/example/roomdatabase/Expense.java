package com.example.roomdatabase;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense")
public class Expense {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "firstname")
    private String firstname;

    @ColumnInfo(name = "lastname")
    private String lastname;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "userid")
    private String userid;

    @ColumnInfo(name = "mobileno")
    private String mobileno;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "gender")
    private String gender;




    //2. then we create DAO = Data Access Object

    Expense(int id, String firstname, String lastname, String email, String userid, String mobileno, String password, String gender){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.userid = userid;
        this.mobileno = mobileno;
        this.password = password;
        this.gender = gender;


    }

    //yaha pr secondary constructor hai jo k (id) ko consider nhi krta

    @Ignore
    Expense(String firstname, String lastname, String email, String userid, String mobileno, String password, String gender){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.userid = userid;
        this.mobileno = mobileno;
        this.password = password;
        this.gender = gender;

    }

    //Getter and Setter upto 63 line

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    //create DatabaseHelper which are use to connect the DataBase

}
