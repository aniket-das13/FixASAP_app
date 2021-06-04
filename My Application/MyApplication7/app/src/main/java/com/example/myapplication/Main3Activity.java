package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends AppCompatActivity {

    Button b;
    EditText name,email,city,state,phno;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference reference;
    Customer customer;
    int i=0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        ;

        customer = new Customer();
        name = findViewById(R.id.cregname);
        email=findViewById(R.id.cregemail);
        city = findViewById(R.id.cregcity);
        state=findViewById(R.id.cregstate);
        phno = findViewById(R.id.cregphno);

        b = findViewById(R.id.cregister);
        reference= database.getInstance().getReference().child("customer");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    i = (int) dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Main3Activity.this, error.getMessage() ,Toast.LENGTH_LONG).show();

            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customer.setcname(name.getText().toString());
                customer.setcemail(email.getText().toString());
                customer.setccity(city.getText().toString());
                customer.setcstate(state.getText().toString());
                customer.setccontactno(phno.getText().toString());
                reference.child(String.valueOf(i+1)).setValue(customer);

                Toast.makeText(Main3Activity.this, "You have been successfully registered." ,Toast.LENGTH_LONG).show();
                Intent intent= new Intent(Main3Activity.this,Main4Activity.class);
                String str = phno.getText().toString();
                intent.putExtra("phno", str);
                startActivity(intent);
            }
        });




    }
}








