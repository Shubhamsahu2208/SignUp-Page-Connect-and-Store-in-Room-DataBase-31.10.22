package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.RoomOpenHelper;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText firstname, lastname, email, userid, mobileno, password;
    Button register;

    RadioButton male, female;

    private RadioGroup rgGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.et_firstName);
        lastname = findViewById(R.id.et_lastName);
        email = findViewById(R.id.et_email);
        userid = findViewById(R.id.et_userId);
        mobileno = findViewById(R.id.et_mobileNo);
        password = findViewById(R.id.et_password);
        rgGender = findViewById(R.id.rg_gender);


        male = findViewById(R.id.rb_male);
        female = findViewById(R.id.rb_female);


        register = findViewById(R.id.bt_register);

        //Validation on Password




        //1.then create Expense.java class to define Entity

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String first = firstname.getText().toString();
                String last = lastname.getText().toString();
                String emai = email.getText().toString();
                String user = userid.getText().toString();
                String mobile = mobileno.getText().toString();
                String pass = password.getText().toString();





                String gender = "female";
                if (rgGender.getCheckedRadioButtonId() == R.id.rb_male)
                    gender = male.getText().toString();
                else gender = female.getText().toString();

                databaseHelper.expenseDao().addTx(new Expense(first, last, emai, user, mobile, pass,gender));

                ArrayList<Expense> arrExpenses = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpence();


                    for (int i = 0; i < arrExpenses.size(); i++) {
                        Log.d("Data", "FirstName:" + arrExpenses.get(i).getFirstname() + "LastName: " + arrExpenses.get(i).getLastname() + "Email: " + arrExpenses.get(i).getEmail() + "User Id: " + arrExpenses.get(i).getUserid() + "Mobile No: " + arrExpenses.get(i).getMobileno() + "Password: " + arrExpenses.get(i).getPassword() + "Gender" + arrExpenses.get(i).getGender());
                    }

            }
        });


    }
}