package aquib.mohd.locartdoorvendor.Adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DontHaveAadharCardData {
    public static HashMap<String, List<String>> getData()
    {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
        List<String> noadhar = new ArrayList<String>();
       noadhar.add("PAN CARD");
       noadhar.add("Driving License");




        expandableListDetail.put("Don't have Aadhar Card?\nComplete Your Kyc with Other Documents",noadhar);

        return expandableListDetail;
    }
}
