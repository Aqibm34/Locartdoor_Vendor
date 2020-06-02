package aquib.mohd.locartdoorvendor.Adapters;

public class complaintsData {

    private String img,name,id,refid,orderid,date,issue,status;

    public complaintsData(){}

    public complaintsData(String img, String name, String id, String refid, String orderid, String date, String issue, String status) {
        this.img = img;
        this.name = name;
        this.id = id;
        this.refid = refid;
        this.orderid = orderid;
        this.date = date;
        this.issue = issue;
        this.status = status;

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
