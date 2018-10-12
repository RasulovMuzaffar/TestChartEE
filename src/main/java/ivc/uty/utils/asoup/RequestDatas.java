package ivc.uty.utils.asoup;

import java.io.Serializable;

public class RequestDatas implements Serializable {
    private String sprName;
    private String sprData;

    public RequestDatas() {
    }

    public RequestDatas(String sprName, String sprData) {
        this.sprName = sprName;
        this.sprData = sprData;
    }

    public String getSprName() {
        return sprName;
    }

    public void setSprName(String sprName) {
        this.sprName = sprName;
    }

    public String getSprData() {
        return sprData;
    }

    public void setSprData(String sprData) {
        this.sprData = sprData;
    }
}
