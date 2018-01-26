package generic.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by huiyh on 2017/10/26.
 */
public class ApiResponse<DATA> {

    @SerializedName("errorno")
    int errorno;

    @SerializedName("errormsg")
    String errormsg;

    @SerializedName("data")
    DATA data;

    public int getCode() {
        return errorno;
    }

    public String getMsg() {
        return errormsg;
    }

    public DATA getData() {
        return data;
    }
}
