package aquib.mohd.locartdoorvendor.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aquib.mohd.locartdoorvendor.R;

public class PastOrderAdapter extends RecyclerView.Adapter<PastOrderAdapter.MyViewHolder> {
    Context context;
    ArrayList<String> status,orderId,location,time,date,items,price;


    public PastOrderAdapter(Context context, ArrayList<String> status, ArrayList<String> orderId,ArrayList<String> location, ArrayList<String> time, ArrayList<String> date, ArrayList<String> items, ArrayList<String> price) {
        this.context = context;
        this.status = status;
        this.orderId = orderId;
        this.location=location;
        this.time =time ;
        this.date=date;
        this.items = items;
        this.price=price;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.porder_list_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        if (status.get(position).equals("CANCELLED"))
        {
            holder.s1.setBackgroundColor(Color.RED);
        }

        holder.s1.setText(status.get(position));
       holder.id1.setText(orderId.get(position));
       holder.l1.setText(location.get(position));
        holder.td1.setText(date.get(position)+" | "+time.get(position));
       holder.i1.setText(items.get(position)+" | "+price.get(position));




    }

    @Override
    public int getItemCount() {
        return status.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView s1,id1,l1,td1,i1;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

             s1=itemView.findViewById(R.id.status1);
            id1=itemView.findViewById(R.id.orderid1);
            l1=itemView.findViewById(R.id.location1);
            td1=itemView.findViewById(R.id.date_time1);
             i1=itemView.findViewById(R.id.items1);

        }
    }

}
