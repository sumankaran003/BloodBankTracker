package in.karan.suman.bloodbanktracker;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HospitalActivity extends AppCompatActivity {

    Button call, map, google, searchnearby;

    String phone, lat, lon, name, add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        Intent box = getIntent();
        Bundle b = box.getExtras();
        name = b.getString("name");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(name);
        DatabaseReference myRef1 = myRef.child("add");
        DatabaseReference myRef2 = myRef.child("lat");
        DatabaseReference myRef3 = myRef.child("lon");
        DatabaseReference myRef4 = myRef.child("phone");

        call = findViewById(R.id.call);
        map = findViewById(R.id.map);
        google = findViewById(R.id.search);
        searchnearby = findViewById(R.id.searchnearby);


        myRef1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                add = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lat = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lon = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                phone = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                google();
            }
        });

        searchnearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchnearby();
            }
        });

    }

    private void searchnearby() {

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                Uri.parse("http://maps.google.com/maps?q=hospital&mrt=yp&sll=lat,lon&output=kml"));

        startActivity(intent);



    }

    private void google() {

        Uri uri = Uri.parse("http://www.google.com/#q="+name);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    private void search() {

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                Uri.parse("http://maps.google.com/maps?q="+name+"&mrt=yp&sll=lat,lon&output=kml"));

        startActivity(intent);

    }

    private void call() {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" +phone));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);

    }
}
