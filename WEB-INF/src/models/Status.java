package models;

public class Status {

    private Integer statusId;
    private String type;

    public static final int ACTIVE = 1;
    public static final int INACTIVE = 2;
    public static final int BLOCKED = 3;
    public static final int CLOSED = 4;
    public static final int EMAIL_VERIFIED = 5;
    public static final int MANUAL_VERIFICATION = 6;
    public static final int PENDING = 7;
    public static final int COMPLETED = 8;

    
    public Status(){

    }

    public Status(Integer statusId){
        this.statusId = statusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}