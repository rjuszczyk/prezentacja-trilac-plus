package pl.pharmaway.prezentacjatrilacplus.mvp;

public interface Cancelable {
    boolean isCanceled();
    void cancel();
}
