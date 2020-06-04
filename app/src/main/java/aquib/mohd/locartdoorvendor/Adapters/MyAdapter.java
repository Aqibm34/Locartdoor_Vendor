package aquib.mohd.locartdoorvendor.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aquib.mohd.locartdoorvendor.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<String> status,orderId,cname,location,time,date,items,price,arriveTime;


    public MyAdapter(Context context, ArrayList<String> status, ArrayList<String> orderId,ArrayList<String> cname,ArrayList<String> location, ArrayList<String> time,ArrayList<String> date, ArrayList<String> items,ArrayList<String> price, ArrayList<String> arriveTime) {
        this.context = context;
        this.status = status;
        this.orderId = orderId;
        this.cname=cname;
        this.location=location;
        this.time =time ;
        this.date=date;
        this.items = items;
        this.price=price;
        this.arriveTime = arriveTime;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.corder_list_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.s.setText(status.get(position));
       holder.id.setText(orderId.get(position));
       holder.n.setText(cname.get(position));
       holder.l.setText(location.get(position));
        holder.td.setText(date.get(position)+" | "+time.get(position));
       holder.i.setText(items.get(position)+" | "+price.get(position));
        holder.at.setText(arriveTime.get(position));



    }

    @Override
    public int getItemCount() {
        return status.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView s,id,n,l,td,i,at;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

             s=itemView.findViewById(R.id.status);
            id=itemView.findViewById(R.id.orderid);
            n=itemView.findViewById(R.id.cname);
            l=itemView.findViewById(R.id.location);
            td=itemView.findViewById(R.id.date_time);
             i=itemView.findViewById(R.id.items);
             at=itemView.findViewById(R.id.dearrivetime);
        }
    }

}
