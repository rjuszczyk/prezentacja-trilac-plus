package pl.pharmaway.prezentacjatrilacplus.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pl.pharmaway.prezentacjatrilacplus.database.DataRow;

public class GetDataResponse {
    @SerializedName("response")
    List<DataRow> mResponse;

    public List<DataRow> getDataList() {
        return mResponse;
    }
}
