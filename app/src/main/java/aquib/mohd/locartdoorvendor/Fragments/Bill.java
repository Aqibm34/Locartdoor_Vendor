package aquib.mohd.locartdoorvendor.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aquib.mohd.locartdoorvendor.R;


public class Bill extends Fragment {

    TextView sname,sph,cname,orderiddate,items,price,dcharge,tamount,s;
    int amount,deliverycharge=20;
    String c_name,c_address,o_Id,date,item,p,status;
    String shop_name="Dada Boudi Biriyani";
    String shop_phone="9038747012";


    public Bill() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_bill, container, false);
        sname=v.findViewById(R.id.sname);
        sph=v.findViewById(R.id.sph);
        cname=v.findViewById(R.id.cn);
        orderiddate=v.findViewById(R.id.iddate);
        items=v.findViewById(R.id.items1);
        price=v.findViewById(R.id.pric);
        dcharge=v.findViewById(R.id.pric1);
        tamount=v.findViewById(R.id.tamount);
        s=v.findViewById(R.id.stat);

        Bundle b=getArguments();
        c_name=b.getString("cname");
        c_address=b.getString("caddress");
        o_Id=b.getString("orderid");
        date=b.getString("date");
        item=b.getString("items");
        p=b.getString("price");
        status=b.getString("status");

       sname.setText(shop_name);
        sph.setText(shop_phone);
        cname.setText("Bill to : "+c_name+"\n"+c_address);
        orderiddate.setText("Order Id : "+o_Id+"\n"+"Date:"+date);
        items.setText(item);
        price.setText(p+"/-");
       dcharge.setText(deliverycharge+"/-");
        amount=Integer.parseInt(p);
        if (status.equals("DUE"))
        {
            s.setTextColor(Color.RED);
        }
        else if (status.equals("PAID"))
        {
            s.setTextColor(Color.GREEN);
        }
        tamount.setText(amount+deliverycharge+"/-");
        s.setText(status);

        return v;
    }
}