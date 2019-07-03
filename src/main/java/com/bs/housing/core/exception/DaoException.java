package com.bs.housing.core.exception;

import com.bs.housing.core.base.BaseException;

import java.util.Date;

/**
 *自定义数据库操作异常
 *
 */
public class DaoException extends BaseException {

    private static final long serialVersionUID = -5625211540764397976L;

    private StringBuffer errorMethod;
    private String errorMsg;
    private Date errorDate = new Date();
    private Exception exception;
    private boolean needPrint = true;

    public DaoException(StringBuffer errorMethod, String errorMsg, Exception exception) {
        this.errorMethod = errorMethod;
        this.errorMsg = errorMsg;
        this.exception = exception;
    }

    public DaoException(String errorMsg, Exception exception) {
        this.errorMsg = errorMsg;
        this.exception = exception;
        exception.printStackTrace();
    }

    public DaoException(String errorMsg, Exception exception, boolean needPrint) {
        this.errorMsg = errorMsg;
        this.exception = exception;
        this.needPrint = needPrint;
        if (needPrint) {
            exception.printStackTrace();
        }
    }

    /**
     * 获取异常信息
     */
    @Override
    public String getMessage() {
        if (this.errorMsg != null && !this.errorMsg.equals("")) {
            return this.errorMsg;
        }
        return super.getMessage();
    }

    public StringBuffer getErrorMethod() {
        return errorMethod;
    }

    public Date getErrorDate() {
        return (Date) errorDate.clone();
    }

    /**
     * 获取异常
     */
    public Exception getException() {
        return exception;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isNeedPrint() {
        return needPrint;
    }

    public void setNeedPrint(boolean needPrint) {
        this.needPrint = needPrint;
    }

    public void setErrorMethod(StringBuffer errorMethod) {
        this.errorMethod = errorMethod;
    }

    public void setErrorDate(Date errorDate) {
        this.errorDate = errorDate;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
