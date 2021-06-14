package com.bean.result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@ApiModel("返回结果")
public class Result {
    //数据
    @ApiModelProperty("数据")
    private HashMap data = new HashMap();
    //附带信息
    @ApiModelProperty("附带信息")
    private String message;
    //状态码 400异常 200正常(默认200)  401:未登录
    @ApiModelProperty("状态码 400出错 200正常(默认200)  401:未登录 402:异常情况 403:没有查到数据" )
    private Integer state = 200;
    public Result(String message){
        this.message = message;
    }
    public Result(){
    }
    public Result(Integer state){
        this.state = state;
    }
    public HashMap getData() {
        return data;
    }
    public void setData(HashMap data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Result add(String key, Object value){
        data.put(key,value);
        return this;
    }
    public void remove(String key){
        data.remove(key);
    }
    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", state=" + state +
                '}';
    }
}
