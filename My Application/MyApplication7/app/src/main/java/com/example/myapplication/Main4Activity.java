package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main4Activity extends AppCompatActivity {
    RadioButton crlpc,crmpa,crha;
    EditText  crd, crpin;
    CusReq cusreq;
    Button b;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        cusreq= new CusReq();

        crlpc=findViewById(R.id.radioButton);
        crmpa=findViewById(R.id.radioButton2);
        crha=findViewById(R.id.radioButton3);
        crd=findViewById(R.id.et1);
        crpin=findViewById(R.id.et2);


        b = findViewById(R.id.button3);
        reference= database.getInstance().getReference().child("cr");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    i = (int) dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Main4Activity.this, error.getMessage() ,Toast.LENGTH_LONG).show();

            }
        });



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();

                cusreq.setCrphno( intent.getStringExtra("phno"));
                cusreq.setCrpin(crpin.getText().toString());
                cusreq.setCrdet(crd.getText().toString());



                String e1=crlpc.getText().toString();
                String e2=crmpa.getText().toString();
                String e3=crha.getText().toString();


                if(crlpc.isChecked())
                {
                    cusreq.setCrp(e1);
                    reference.child(String.valueOf(i+1)).setValue(cusreq);
                }
                else if(crmpa.isChecked())
                {
                    cusreq.setCrp(e2);
                    reference.child(String.valueOf(i+1)).setValue(cusreq);
                }
                else
                {
                    cusreq.setCrp(e3);
                    reference.child(String.valueOf(i+1)).setValue(cusreq);
                }


                Toast.makeText(Main4Activity.this, "Looking for partners near you!" ,Toast.LENGTH_LONG).show();
                Intent intent1= new Intent(Main4Activity.this,Main5Activity.class);
                String str="Results for "+cusreq.getCrp()+" in your area- "+cusreq.getCrpin();
                String str2= cusreq.getCrpin();
                intent1.putExtra("pincode",str2);
                intent1.putExtra("mes",str);
                startActivity(intent1);
            }
        });








    }

    public void logout(View view) {


        Toast.makeText(Main4Activity.this, "Logged Out ",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Main4Activity.this, MainActivity.class);
        startActivity(intent);
    }
}