package pl.pharmaway.prezentacjatrilacplus.mvp.fake;

import android.annotation.SuppressLint;

import pl.pharmaway.prezentacjatrilacplus.database.NotSendDataRow;
import pl.pharmaway.prezentacjatrilacplus.mvp.Cancelable;
import pl.pharmaway.prezentacjatrilacplus.mvp.SendForm;
import pl.pharmaway.prezentacjatrilacplus.network.PrezentacjaApi;
import pl.pharmaway.prezentacjatrilacplus.network.SendResponse;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class SendFormImpl implements SendForm {
    private final PrezentacjaApi prezentacjaApi;
    public SendFormImpl(PrezentacjaApi prezentacjaApi) {
        this.prezentacjaApi = prezentacjaApi;
    }

    @Override
    public Cancelable sendForm(NotSendDataRow form, final Callback callback) {

        final Call<SendResponse> call = prezentacjaApi.send(
                form.appId,
                form.createDate,
                form.lekarzType,
                form.agent,
                form.lekarz,
                form.timeInApp,
                form.firstChoice
        );

        final Cancelable cancelable = new Cancelable() {
            boolean isCanceled = false;
            @Override
            public boolean isCanceled() {
                return isCanceled;
            }

            @Override
            public void cancel() {
                isCanceled = true;
                call.cancel();
            }
        };

        call.enqueue(new retrofit.Callback<SendResponse>() {

            @SuppressLint("ApplySharedPref")
            @Override
            public void onResponse(Response<SendResponse> response) {
                if (!cancelable.isCanceled()) {
                    if(response.body()==null){
                        onFailure(null);
                        return;
                    }

                    if(response.body().isSuccess()) {
                        callback.onSuccess();
                    } else {
                        onFailure(null);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure();
            }
        });

        return cancelable;
    }
}
