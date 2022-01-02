public class CoronaPassport {
    private String reason;
    private Date date;

    public CoronaPassport(String reason, Date date) {
        this.reason = reason;
        this.date = date.copy();
    }

    public String getReason() {
        return reason;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return "reason='" + reason +
                ", date=" + date.toString();
    }
}
