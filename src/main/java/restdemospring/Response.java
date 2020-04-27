package restdemospring;
public class Response {
    String  message;
    Boolean status;

    public Response(String  message,Boolean status) {
        this.message = message;
        this.status = status;
    }

    public Response( ) { }

    public String getMessage() { return message; }
    public Boolean getStatus() { return status; }

    public void setMessage(String message) { this.message = message; }
    public void setStatus(Boolean status) { this.status = status; }
}
