package pl.pharmaway.prezentacjatrilacplus.mvp;

import java.util.List;

import pl.pharmaway.prezentacjatrilacplus.database.NotSendDataRow;

public interface FormDataRepository {
    List<NotSendDataRow> getNotSendForms();
    void markAsSend(NotSendDataRow form);
    boolean hasNotSendForms();
    void storeNotSendForm(NotSendDataRow form);
}
