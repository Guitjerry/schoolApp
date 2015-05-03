package com.sushe.entity;

import java.util.Date;

public class UserGroupChallenge {
    private String id;

    private String name;

    private String type;

    private String note;

    private String userGroupId;

    private String address;

    private Date challengeTime;

    private String acceptGroupId;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId == null ? null : userGroupId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getChallengeTime() {
        return challengeTime;
    }

    public void setChallengeTime(Date challengeTime) {
        this.challengeTime = challengeTime;
    }

    public String getAcceptGroupId() {
        return acceptGroupId;
    }

    public void setAcceptGroupId(String acceptGroupId) {
        this.acceptGroupId = acceptGroupId == null ? null : acceptGroupId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}