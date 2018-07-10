package in.karan.suman.bloodbanktracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BloodCountActivity extends AppCompatActivity {

    private RecyclerView mDistrictList;
    private DatabaseReference mDatabase;

    //String count;
   String sCount;

    String state,district,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_count);

        Intent box = getIntent();
        Bundle b = box.getExtras();
        state=b.getString("state");
        district=b.getString("district");
        type=b.getString("bg");

        mDistrictList= (RecyclerView) findViewById(R.id.count_list);
        mDistrictList.setHasFixedSize(true);
        mDistrictList.setLayoutManager(new LinearLayoutManager(this));

        mDatabase= FirebaseDatabase.getInstance().getReference().child(state+"/"+district+"/"+type);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Number,BloodCountActivity.CountViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Number,BloodCountActivity.CountViewHolder>(

                Number.class,
                R.layout.number,
                BloodCountActivity.CountViewHolder.class,
                mDatabase
        )  {
            @Override
            protected void populateViewHolder(final BloodCountActivity.CountViewHolder viewHolder, Number model, int position) {



                final String hospital=getRef(position).getKey();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(state+"/"+district+"/"+type+"/"+hospital);
                DatabaseReference myRef1=myRef.child("count");



                      /*  DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference mostafa = ref.child("Users").child("mostafa_farahat22@yahoo.com").child("_email");*/

                myRef1.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                         String count = Long.toString(dataSnapshot.getValue(Long.class));
                        viewHolder.setCount(count);


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

               // DatabaseReference nDatabase= FirebaseDatabase.getInstance().getReference().child(state+"/"+district+"/"+type+"/"+hospital);

              //  String value=nDatabase.getKey();


              /*  nDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot data : dataSnapshot.getChildren()){

                           count = data.getValue(String.class);


                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });*/


                viewHolder.setHospitalName(hospital);


                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent type = new Intent(BloodCountActivity.this,HospitalActivity.class);
                        type.putExtra("name" , hospital);
                        startActivity(type);
                    }
                });
            }


        };

        mDistrictList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class CountViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public CountViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }

        public void setHospitalName(String title)
        {
            TextView post_title =  mView.findViewById(R.id.hname);
            post_title.setText(title);
        }

        public void setCount(String count)
        {

            TextView post_title =  mView.findViewById(R.id.bgcount);
            post_title.setText("Available : "+count);
        }

    }

}
