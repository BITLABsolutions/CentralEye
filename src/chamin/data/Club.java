/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
 
package chamin.data;

import java.sql.Date;


public class Club {
    private String ClubId;
    private String ClubName;
    private String TeacherIncharge;
    private String Advisor;
    private String PresidentId;
    private String VisePresidentId;
    private String SecretaryId;
    private String AssSecretaryId;
    private String TreasurerId;
    private String Task;
    private String Suggestions;
    private Date DateOfEstablish;
    private String[] MemberIdList;

    public Club(String ClubId, String ClubName, String TeacherIncharge, String Advisor, String PresidentId, String VisePresidentId, String SecretaryId, String AssSecretaryId, String TreasurerId, String Task, String Suggestions, Date DateOfEstablish, String[] MemberIdList) {
        this.ClubId = ClubId;
        this.ClubName = ClubName;
        this.TeacherIncharge = TeacherIncharge;
        this.Advisor = Advisor;
        this.PresidentId = PresidentId;
        this.VisePresidentId = VisePresidentId;
        this.SecretaryId = SecretaryId;
        this.AssSecretaryId = AssSecretaryId;
        this.TreasurerId = TreasurerId;
        this.Task = Task;
        this.Suggestions = Suggestions;
        this.DateOfEstablish = DateOfEstablish;
        this.MemberIdList = MemberIdList;
    }

    public String getClubId() {
        return ClubId;
    }

    public void setClubId(String ClubId) {
        this.ClubId = ClubId;
    }

    public String getClubName() {
        return ClubName;
    }

    public void setClubName(String ClubName) {
        this.ClubName = ClubName;
    }

    public String getTeacherIncharge() {
        return TeacherIncharge;
    }

    public void setTeacherIncharge(String TeacherIncharge) {
        this.TeacherIncharge = TeacherIncharge;
    }

    public String getAdvisor() {
        return Advisor;
    }

    public void setAdvisor(String Advisor) {
        this.Advisor = Advisor;
    }

    public String getPresidentId() {
        return PresidentId;
    }

    public void setPresidentId(String PresidentId) {
        this.PresidentId = PresidentId;
    }

    public String getVisePresidentId() {
        return VisePresidentId;
    }

    public void setWisePresidentId(String VisePresidentId) {
        this.VisePresidentId = VisePresidentId;
    }

    public String getSecretaryId() {
        return SecretaryId;
    }

    public void setSecretaryId(String SecretaryId) {
        this.SecretaryId = SecretaryId;
    }

    public String getAssSecretaryId() {
        return AssSecretaryId;
    }

    public void setAssSecretaryId(String AssSecretaryId) {
        this.AssSecretaryId = AssSecretaryId;
    }

    public String getTreasurerId() {
        return TreasurerId;
    }

    public void setTreasureId(String TreasureId) {
        this.TreasurerId = TreasureId;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String Task) {
        this.Task = Task;
    }

    public String getSuggestions() {
        return Suggestions;
    }

    public void setSuggestions(String Suggestions) {
        this.Suggestions = Suggestions;
    }

    public Date getDateOfEstablish() {
        return DateOfEstablish;
    }

    public void setDateOfEstablish(Date DateOfEstablish) {
        this.DateOfEstablish = DateOfEstablish;
    }

    public String[] getMemberIdList() {
        return MemberIdList;
    }

    public void setMemberIdList(String[] MemberIdList) {
        this.MemberIdList = MemberIdList;
    }

    

  

    
    
    
}
