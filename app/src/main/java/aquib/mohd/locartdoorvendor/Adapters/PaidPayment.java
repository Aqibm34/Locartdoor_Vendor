package aquib.mohd.locartdoorvendor.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aquib.mohd.locartdoorvendor.Fragments.Bill;
import aquib.mohd.locartdoorvendor.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class PaidPayment extends RecyclerView.Adapter<PaidPayment.MyViewHolder> {
    Context context;
    ArrayList<String> cname,caddress,orderId,time,date,items,price;
    ArrayList<Integer> cimage;


    public PaidPayment(Context context, ArrayList<String> cname, ArrayList<String> caddress, ArrayList<String> orderId, ArrayList<String> time, ArrayList<String> date, ArrayList<String> items, ArrayList<String> price, ArrayList<Integer> cimage) {
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
        View view=inflater.inflate(R.layout.paid_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        holder.i.setImageResource(cimage.get(position));
        holder.n.setText(cname.get(position));
        holder.a.setText(caddress.get(position));
       holder.id1.setText(orderId.get(position));
        holder.td1.setText(date.get(position)+" | "+time.get(position));
       holder.i1.setText(items.get(position)+" | Rs."+price.get(position)+"/-");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle();
                b.putString("cname",cname.get(position));
                b.putString("caddress",caddress.get(position));
                b.putString("orderid",orderId.get(position));
                b.putString("date",date.get(position));
                b.putString("items",items.get(position));
                b.putString("price",price.get(position));
                b.putString("status","PAID");

                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                Bill bill=new Bill();
                bill.setArguments(b);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.homepage_frame_container,bill).addToBackStack(null).commit();


            }
        });




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
