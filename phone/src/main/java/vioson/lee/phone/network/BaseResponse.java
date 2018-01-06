package vioson.lee.phone.network;

/**
 * Created by viosonlee
 * on 2017/10/28.
 * for 实际使用可以仿照该类进行改写
 */

public class BaseResponse<T> {
    private int code;
    private String msg;
    private T data;
    private String seqid;

    public String getSeqid() {
        return seqid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSeqid(String seqid) {
        this.seqid = seqid;
    }

    public void setData(T t) {
        data = t;
    }

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int cd) {
        this.code = cd;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public boolean isOk() {
        // TODO: 2017/10/30 判断正确ma
        return code >= 0;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + msg + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
