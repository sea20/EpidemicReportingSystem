package com.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@ApiModel(description = "外出申请",value = "Leave")
public class Leave {
    @ApiModelProperty(value = "主键id,会自动生成，不用管他",hidden = true)
    Integer id;
    @ApiModelProperty(value = "请假用户id",example = "1")
    Integer uId;
    @ApiModelProperty(value = "开始时间")
    Date startTime;
    @ApiModelProperty(value = "结束时间")
    Date endTime;
    @ApiModelProperty(value = "去哪")
    String where;
    @ApiModelProperty(value = "去干啥")
    String action;
    @ApiModelProperty(value = "请假状态 默认为1 1：审批中 2：已同意 3：不同意" ,example = "1")
    Integer state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", uId=" + uId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", where='" + where + '\'' +
                ", action='" + action + '\'' +
                ", state=" + state +
                '}';
    }
}
