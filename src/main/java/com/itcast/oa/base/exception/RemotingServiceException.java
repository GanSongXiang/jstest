package com.itcast.oa.base.exception;

/**
 * Created by GanSX on 2017/3/18.
 */
public class RemotingServiceException extends BaseException {
    private static final long	serialVersionUID	= 1L;
    private String				errorPathInfo;

    /**
     * @param errorNo
     * @param errorInfo
     */
    public RemotingServiceException(String errorNo, String errorInfo) {
        super(errorNo);
        setErrorMessage(errorInfo);
    }

    /**
     * @param errorNo
     * @param errorInfo
     */
    public RemotingServiceException(int returnCode, String errorNo,
                                    String errorInfo) {
        super(errorNo);
        setErrorMessage(errorInfo);
    }

    public RemotingServiceException(String errorNo, String errorInfo,
                                    String errorPathInfo) {
        super(errorNo);
        setErrorMessage(errorInfo);
        this.errorPathInfo = errorPathInfo;
    }

    public RemotingServiceException(int returnCode, String errorNo,
                                    String errorInfo, String errorPathInfo) {
        super(errorNo);
        setErrorMessage(errorInfo);
        this.errorPathInfo = errorPathInfo;
    }

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    public String getErrorInfo() {
        return getMessage();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.hundsun.jres.interfaces.exception.IJRESBaseErrorMessage#getErrorMessage
     * ()
     */
    public String getErrorMessage() {
        return getMessage();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.hundsun.jres.interfaces.exception.IJRESBaseErrorMessage#getErrorNo()
     */
    public String getErrorNo() {
        return getErrorCode();
    }

    /**
     * @return the errorPathInfo
     */
    public String getErrorPathInfo() {
        return errorPathInfo;
    }
}
