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
    @ApiModelProperty(value = "请假用户id",hidden = true)
    Integer uId;
    @ApiModelProperty(value = "开始时间")
    Date startTime;
    @ApiModelProperty(value = "结束时间")
    Date endTime;
    @ApiModelProperty(value = "去哪",example = "去哪")
    String toWhere;
    @ApiModelProperty(value = "去干啥",example = "去做什么")
    String actions;
    @ApiModelProperty(value = "请假状态 默认为1 1：审批中 2：已同意 3：不同意" ,example = "1")
    Integer state;

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", uId=" + uId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", toWhere='" + toWhere + '\'' +
                ", actions='" + actions + '\'' +
                ", state=" + state +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
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

    public String getToWhere() {
        return toWhere;
    }

    public void setToWhere(String toWhere) {
        this.toWhere = toWhere;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
