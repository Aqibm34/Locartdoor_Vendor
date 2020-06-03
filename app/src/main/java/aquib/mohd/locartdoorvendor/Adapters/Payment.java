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
import de.hdodenhof.circleimageview.CircleImageView;

public class Payment extends RecyclerView.Adapter<Payment.MyViewHolder> {
    Context context;
    ArrayList<String> cname,caddress,orderId,time,date,items,price;
    ArrayList<Integer> cimage;


    public Payment(Context context, ArrayList<String> cname,ArrayList<String> caddress, ArrayList<String> orderId, ArrayList<String> time, ArrayList<String> date, ArrayList<String> items, ArrayList<String> price,ArrayList<Integer> cimage) {
        this.context = context;
        this.cname =cname;
        this.caddress=caddress;
        this.orderId = orderId;
        this.time =time ;
        this.date=date;
        this.items = items;
        this.price=price;
        this.cimage=cimage;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.due_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        holder.i.setImageResource(cimage.get(position));
        holder.n.setText(cname.get(position));
        holder.a.setText(caddress.get(position));
       holder.id1.setText(orderId.get(position));
        holder.td1.setText(date.get(position)+" | "+time.get(position));
       holder.i1.setText(items.get(position)+" | "+price.get(position));




    }

    @Override
    public int getItemCount() {
        return cname.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView n,a,id1,td1,i1;
        CircleImageView i;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

             n=itemView.findViewById(R.id.cname1);
            a=itemView.findViewById(R.id.caddress1);
            id1=itemView.findViewById(R.id.orderid2);
            td1=itemView.findViewById(R.id.date_time2);
             i1=itemView.findViewById(R.id.items2);
             i=itemView.findViewById(R.id.cimage1);


        }
    }

}
