package pl.pharmaway.prezentacjatrilacplus.mvp.fake;


import pl.pharmaway.prezentacjatrilacplus.mvp.Cancelable;

public class SimpleCancelable implements Cancelable {
    private final Runnable doOnCancel;
    private boolean isCanceled = false;

    public SimpleCancelable(Runnable doOnCancel) {
        this.doOnCancel = doOnCancel;
    }

    @Override
    public boolean isCanceled() {
        return isCanceled;
    }

    @Override
    public void cancel() {
        doOnCancel.run();
        isCanceled = true;
    }
}
