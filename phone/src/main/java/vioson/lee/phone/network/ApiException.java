package vioson.lee.phone.network;

import lee.vioson.network.core.BaseApiException;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for
 */

public class ApiException extends BaseApiException {
    public ApiException(int errorCode, String message) {
        super(errorCode, message);
    }
    public ApiException(BaseResponse baseResponse){
        super(baseResponse.getMessage());
        this.errorCode = baseResponse.getCode();
    }
}
