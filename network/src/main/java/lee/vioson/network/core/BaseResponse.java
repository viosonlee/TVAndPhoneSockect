package lee.vioson.network.core;

/**
 * Created by viosonlee
 * on 2017/10/28.
 * for 实际使用可以仿照该类进行改写
 */

public class BaseResponse<T> {
    private int cd;
    private String msg;
    private T data;

    public void setData(T t){data =t;}

    public T getData() {
        return data;
    }

    public int getCode() {
        return cd;
    }

    public void setCode(int cd) {
        this.cd = cd;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public boolean isOk() {
        // TODO: 2017/10/30 判断正确ma
        return cd >= 0;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + cd +
                ", message='" + msg + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
