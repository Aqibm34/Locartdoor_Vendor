package aquib.mohd.locartdoorvendor.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aquib.mohd.locartdoorvendor.Fragments.complaintOverview;
import aquib.mohd.locartdoorvendor.R;

public class complaintAdapter extends RecyclerView.Adapter<complaintAdapter.myViewHolder_cmp>{

    Context context;
    ArrayList<complaintsData> data;


    public complaintAdapter(Context context, ArrayList<complaintsData> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public myViewHolder_cmp onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.complaints_list_item,parent,false);
        return new myViewHolder_cmp(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder_cmp holder, final int position) {

        final complaintsData complaint = data.get(position);

        holder.c_name.setText(complaint.getName());
        holder.c_id.setText(complaint.getId());
        holder.ref.setText(complaint.getRefid());
        holder.order.setText(complaint.getOrderid());
        holder.date.setText(complaint.getDate());
        holder.issue.setText(complaint.getIssue());

        String status_ = complaint.getStatus();
        if (status_.equals("Active"))
            holder.status.setTextColor(Color.RED);
        else
            holder.status.setTextColor(Color.parseColor("#36d153"));

        holder.status.setText(status_);


        holder.cmpCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getComplaintDetail(complaint, position,view);
            }
        });

    }

    private void getComplaintDetail(complaintsData d,int i,View v) {

        Fragment fragment = new complaintOverview();
        Bundle bundle = new Bundle();
        bundle.putString("name",d.getName());
        bundle.putString("id",d.getId());
        bundle.putString("refid",d.getRefid());
        bundle.putString("orderid",d.getOrderid());
        bundle.putString("date",d.getDate());
        bundle.putString("issue",d.getIssue());
        bundle.putString("status",d.getStatus());
        fragment.setArguments(bundle);

        AppCompatActivity activity = (AppCompatActivity) v.getContext();

        activity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_left)
                .add(R.id.homepage_frame_container,fragment,"tag").addToBackStack("tag").commit();


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class myViewHolder_cmp extends RecyclerView.ViewHolder {

        TextView ref,order,date,issue,status,c_name,c_id;
        ImageView c_img;
        CardView cmpCV;
        public myViewHolder_cmp(@NonNull View itemView) {
            super(itemView);

            c_name = itemView.findViewById(R.id.cust_name_cmp);
            c_id = itemView.findViewById(R.id.cust_id_cmp);
            c_img = itemView.findViewById(R.id.cust_imgae_cmp);
            ref = itemView.findViewById(R.id.cmp_refid);
            order = itemView.findViewById(R.id.order_id_cmp);
            date = itemView.findViewById(R.id.cmp_date);
            issue = itemView.findViewById(R.id.cmp_issue);
            status = itemView.findViewById(R.id.cmp_status);
            cmpCV = itemView.findViewById(R.id.cmp_CV);

        }
    }
}
