package in.karan.suman.bloodbanktracker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DistrictListActivity extends AppCompatActivity {

    private RecyclerView mDistrictList;
    private DatabaseReference mDatabase;

    ProgressDialog progressDoalog;

    String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_list);

        Intent box = getIntent();
        Bundle b = box.getExtras();
        state=b.getString("state");

        mDistrictList= (RecyclerView) findViewById(R.id.district_list);
        mDistrictList.setHasFixedSize(true);
        mDistrictList.setLayoutManager(new LinearLayoutManager(this));

       mDatabase= FirebaseDatabase.getInstance().getReference().child(state);


    }

    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<Subject,SubjectViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Subject, SubjectViewHolder>(

                Subject.class,
                R.layout.subject,
                SubjectViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(SubjectViewHolder viewHolder, Subject model, final int position) {
                final String district=getRef(position).getKey();
                viewHolder.setSubjectName(district);
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent type = new Intent(DistrictListActivity.this,BloodTypeActivity.class);
                        type.putExtra("state" , state);
                        type.putExtra("district" , district);
                        //question.putExtra("subject" , subject);
                        startActivity(type);
                    }
                });

            }
        };

        mDistrictList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class SubjectViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public SubjectViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }

        public void setSubjectName(String title)
        {
            TextView post_title =  mView.findViewById(R.id.qname);
            post_title.setText(title);
        }



    }

}
