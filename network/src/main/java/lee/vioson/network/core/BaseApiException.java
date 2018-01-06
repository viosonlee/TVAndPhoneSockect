package lee.vioson.network.core;

/**
 * Created by viosonlee
 * on 2017/7/25.
 * for 异常处理
 */

public class BaseApiException extends RuntimeException {
    public int getErrorCode() {
        return errorCode;
    }

    protected int errorCode;

    public BaseApiException(String message) {
        super(message);
    }

    public BaseApiException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseApiException(BaseResponse baseResponse) {
        super(baseResponse.getMessage());
        this.errorCode = baseResponse.getCode();
    }
}
