package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {
   RadioButton home,self,mpa,ha,lpc;
    Button b;

    EditText name,email,pin,phno,cost,duration;

    private FirebaseAuth auth;
    FirebaseDatabase database;
DatabaseReference reference;
    Member member;
    int i=0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    ;

        member= new Member();
           home=findViewById(R.id.Home);
           self=findViewById(R.id.Self);

           lpc=findViewById(R.id.reglpc);
        mpa=findViewById(R.id.regmpa);
        ha=findViewById(R.id.regha);

        name = findViewById(R.id.regname);
        email=findViewById(R.id.regemail);
     pin = findViewById(R.id.regpin);

        phno = findViewById(R.id.regphno);
        cost=findViewById(R.id.regcost);
        duration = findViewById(R.id.regduration);

                b = findViewById(R.id.register);
        reference= database.getInstance().getReference().child("user");
      reference.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              if (dataSnapshot.exists()) {
                  i = (int) dataSnapshot.getChildrenCount();
              }
          }

                                          @Override
                                          public void onCancelled(@NonNull DatabaseError error) {
                                              Toast.makeText(Main2Activity.this, error.getMessage() ,Toast.LENGTH_LONG).show();

                                          }
                                      });


       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               member.setName(name.getText().toString());
               member.setemail(email.getText().toString());
               member.setPin(pin.getText().toString());
               member.setContactno(phno.getText().toString());
               member.setRepaircost(cost.getText().toString());
               member.setduration(duration.getText().toString());

               String m1=home.getText().toString();
               String m2=self.getText().toString();

               if(home.isChecked())
               {
                   member.setDeliveryType(m1);

               }
               else
               {
                   member.setDeliveryType(m2);

               }

               String e1=lpc.getText().toString();
               String e2=mpa.getText().toString();
               String e3=ha.getText().toString();


               if(lpc.isChecked())
               {
                   member.setExp(e1);
                   reference.child(String.valueOf(i+1)).setValue(member);
               }
               else if(mpa.isChecked())
               {
                   member.setDeliveryType(e2);
                   reference.child(String.valueOf(i+1)).setValue(member);
               }
               else
               {
                   member.setDeliveryType(e3);
                   reference.child(String.valueOf(i+1)).setValue(member);
               }


               Toast.makeText(Main2Activity.this, "You have been successfully registered and you will be contacted by interested customers." ,Toast.LENGTH_LONG).show();
               Intent intent= new Intent(Main2Activity.this,MainActivity.class);
               startActivity(intent);
           }
       });




        }
    }







