package com.sx.beatles.prize.bean;

/**
 * Created by 施行 on 2017/8/1.
 */

public class PrizeInfo {
    private String prizeType;
    private String issue; //期数
    private String prizeTime;//开奖时间
    private String prizeNumber;//开奖号码

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getPrizeTime() {
        return prizeTime;
    }

    public void setPrizeTime(String prizeTime) {
        this.prizeTime = prizeTime;
    }

    public String getPrizeNumber() {
        return prizeNumber;
    }

    public void setPrizeNumber(String prizeNumber) {
        this.prizeNumber = prizeNumber;
    }
}
