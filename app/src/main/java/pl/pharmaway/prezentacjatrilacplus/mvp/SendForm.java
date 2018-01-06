package pl.pharmaway.prezentacjatrilacplus.mvp;

import pl.pharmaway.prezentacjatrilacplus.database.NotSendDataRow;

public interface SendForm {
    Cancelable sendForm(NotSendDataRow form, Callback callback);

    interface Callback {
        void onSuccess();
        void onFailure();
    }
}
