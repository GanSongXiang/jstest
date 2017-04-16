package com.itcast.oa.base.exception;

/**
 * Created by GanSX on 2017/3/18.
 */
@SuppressWarnings("serial")
public class BizServiceException extends RemotingServiceException{
    public BizServiceException(String expCode, String expMessage) {
        super(expCode, expMessage);
    }

    public BizServiceException(EErrorCode errInfo) {
        super(errInfo.getErrCode(), errInfo.getErrorMsg());
    }

    public BizServiceException(EErrorCode errInfo,Object... formatArgs) {
        super(errInfo.getErrCode(), String.format(errInfo.getErrorMsg(), formatArgs));
    }
}
