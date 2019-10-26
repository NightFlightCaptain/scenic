package com.hust.software.scenic.common;

/**
 * @author: 小栗旬
 * @Date: 2019/10/23 17:54
 */
public class CommonResult {
    private long code;
    private String message;
    private Object data;

    public CommonResult(){

    }

    public CommonResult(long code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static  CommonResult success(Object data){
        return new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    public static CommonResult success(String message){
        return new CommonResult(ResultCode.SUCCESS.getCode(),message,null);
    }

    public static CommonResult success(String message,Object data){
        return new CommonResult(ResultCode.SUCCESS.getCode(),message,data);
    }

    public static  CommonResult failed(Object data){
        return new CommonResult(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),data);
    }

    /**
     * 失败返回结果
     */
    public static  CommonResult failed() {
        return new CommonResult(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),null);
    }

    public static CommonResult failed(String message){
        return new CommonResult(ResultCode.FAILED.getCode(),message,null);
    }

    public static CommonResult failed(String message,Object data){
        return new CommonResult(ResultCode.FAILED.getCode(),message,data);
    }

    
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
