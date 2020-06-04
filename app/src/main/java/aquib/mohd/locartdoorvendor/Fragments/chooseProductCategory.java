package aquib.mohd.locartdoorvendor.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aquib.mohd.locartdoorvendor.R;

public class chooseProductCategory extends Fragment {

    public chooseProductCategory() {
        // Required empty public constructor
    }

    private Toolbar toolbar;
    private CardView exixtingCV,add_new;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_choose_product_category, container, false);
        exixtingCV = v.findViewById(R.id.choose_exist);
        add_new = v.findViewById(R.id.add_new);

        exixtingCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseCatDialogue("Choose Category",new existingCategory());
            }
        });

        add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseCatDialogue("Choose Category to add new item",new addnewItem());
            }
        });

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Add Item");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);

        return v;
    }

    private void chooseCatDialogue(String title, final Fragment fragment) {

        final String[] category = {"Food","Groceries","Fruits & vegetables","Medical","Fish & meat","PetSupplies","Others"};

        new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setItems(category, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){

                            case 0:
                                loadFrag(fragment,category[0]);
                                break;
                            case 1:
                                loadFrag(fragment,category[1]);
                                break;
                            case 2:
                                loadFrag(fragment,category[2]);
                                break;
                            case 3:
                                loadFrag(fragment,category[3]);
                                break;
                            case 4:
                                loadFrag(fragment,category[4]);
                                break;
                            case 5:
                                loadFrag(fragment,category[5]);
                                break;
                            case 6:
                                loadFrag(fragment,category[6]);
                                break;

                        }
                    }
                }).create().show();



    }

    private void loadFrag(Fragment fragment,String category){

        Bundle bundle = new Bundle();
        bundle.putString("category",category);
        fragment.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_left)
                .add(R.id.homepage_frame_container,fragment,"tag").addToBackStack("tag").commit();

    }

    @Override
    public void onPause() {
        super.onPause();
        toolbar.setTitle("");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.VISIBLE);

    }

    @Override
    public void onResume() {
        super.onResume();
        toolbar.setTitle("Add Item");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);

    }

    @Override
    public void onStop() {
        super.onStop();
        toolbar.setTitle("");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.VISIBLE);
    }
}