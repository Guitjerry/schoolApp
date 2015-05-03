package com.sushe.entity;

import java.util.Date;

public class UserChallenge {
    private String id;

    private String type;

    private String count;

    private String sourcePeo;

    private Date collengeTime;

    private String isAllow;

    private String acceptPeo;

    private String address;

    private String rewardId;

    private String punishId;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count == null ? null : count.trim();
    }

    public String getSourcePeo() {
        return sourcePeo;
    }

    public void setSourcePeo(String sourcePeo) {
        this.sourcePeo = sourcePeo == null ? null : sourcePeo.trim();
    }

    public Date getCollengeTime() {
        return collengeTime;
    }

    public void setCollengeTime(Date collengeTime) {
        this.collengeTime = collengeTime;
    }

    public String getIsAllow() {
        return isAllow;
    }

    public void setIsAllow(String isAllow) {
        this.isAllow = isAllow == null ? null : isAllow.trim();
    }

    public String getAcceptPeo() {
        return acceptPeo;
    }

    public void setAcceptPeo(String acceptPeo) {
        this.acceptPeo = acceptPeo == null ? null : acceptPeo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId == null ? null : rewardId.trim();
    }

    public String getPunishId() {
        return punishId;
    }

    public void setPunishId(String punishId) {
        this.punishId = punishId == null ? null : punishId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}