package aquib.mohd.locartdoorvendor.Adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListData {
    public static HashMap<String, List<String>> getData()
    {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
        List<String> usees = new ArrayList<String>();
       usees.add("1.Step 1-Go to our website and click on partner with Us link");

        List<String> whatisthis = new ArrayList<String>();
       whatisthis.add("A free app for Android,belonging to the category 'Buisiness & Productivity'");

        List<String> partnership = new ArrayList<String>();
       partnership.add("Coming Soon");
       List<String> sell=new ArrayList<String>();
       sell.add("Yes,you can start a business with Locartdoor from home.");
        List<String> partner = new ArrayList<String>();
        partner.add("Coming Soon");
        List<String> night = new ArrayList<String>();
        night.add("Locartdoor deliver till 02:30 Am for sure");


        expandableListDetail.put("What is Locartdoor Partner app?",whatisthis);
        expandableListDetail.put("Can I sell on Locartdoor from home?",sell);
        expandableListDetail.put("Does Locartdoor deliver at night?",night);
        expandableListDetail.put("How do I become a Locartdoor Partner?",partner);
        expandableListDetail.put("How do I contact Locartdoor for a partnership?",partnership);
        expandableListDetail.put("How do you use the Locartdoor Partnership app?",usees);

        return expandableListDetail;
    }
}
