package com.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@ApiModel(description = "填报健康信息",value = "Information")
public class Information {
    @ApiModelProperty(value = "主键id,会自动生成，不用管他",hidden = true)
    Integer id;
    @ApiModelProperty(value = "请假用户id",hidden = true)
    Integer uId;
    @ApiModelProperty(value = "创建时间",hidden = true)
    Date createTime;
    @ApiModelProperty(value = "体温",example = "36.1℃")
    String temperature;
    @ApiModelProperty(value = "是否生病 是/否",example = "否")
    String ill;
    @ApiModelProperty(value = "14天内是否去过高风险地区 是/否",example = "否")
    String route;
    @ApiModelProperty(value = "当前位置",example = "13栋210")
    String position;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getIll() {
        return ill;
    }

    public void setIll(String ill) {
        this.ill = ill;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", uId=" + uId +
                ", createTime=" + createTime +
                ", temperature='" + temperature + '\'' +
                ", ill='" + ill + '\'' +
                ", route='" + route + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
