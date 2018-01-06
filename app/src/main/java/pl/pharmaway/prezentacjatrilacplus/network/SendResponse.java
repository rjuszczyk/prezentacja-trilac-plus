package pl.pharmaway.prezentacjatrilacplus.network;

public class SendResponse {
    int status;

    public boolean isSuccess() {
        return status == 1;
    }
}
