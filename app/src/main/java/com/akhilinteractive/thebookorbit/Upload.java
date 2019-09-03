package com.akhilinteractive.thebookorbit;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Upload extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        final EditText BookName = (EditText) findViewById(R.id.editText3);
        final EditText ClassName = (EditText) findViewById(R.id.editText5);
        final EditText UniversityName = (EditText) findViewById(R.id.editText6);
        final EditText email = (EditText) findViewById(R.id.editText10);
        final EditText phone = (EditText) findViewById(R.id.editText11);

        Button UplaodButton = findViewById(R.id.button4);



        UplaodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Profiles");


                String BookId = mDatabase.push().getKey();

                Profile book = new Profile(BookName.getText().toString(),email.getText().toString(),"https://content-static.upwork.com/uploads/2014/10/02123010/profilephoto_goodcrop.jpg",false);

                mDatabase.child(BookId).setValue(book);

                mDatabase.child(BookId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        MainActivity ma = new MainActivity();
                        //ma.nameArray.add(BookName.getText().toString());

                        //Log.d(TAG, "User name: " + user.getName() + ", email " + user.getEmail());
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        //Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

            }
        });




    }


}