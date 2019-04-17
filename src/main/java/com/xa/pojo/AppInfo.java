package com.xa.pojo;

import java.util.Date;
import java.util.List;

public class AppInfo {
    private Long id;

    private String softwareName;

    private String apkName;

    private String supportRom;

    private String interfaceLanguage;

    private Double softwareSize;

    private Date updateDate;

    private Long devId;

    private String appInfo;

    private Long status;

    private Date onsaleDate;

    private Date oddsaleDate;

    private Long flatformId;

/*    private Long categoryLevel1;

    private Long categoryLevel2;

    private Long categoryLevel3;*/

    private AppCategory categoryLevel1;

    private AppCategory categoryLevel2;

    private AppCategory categoryLevel3;

    private Long downloads;

    private Long createdBy;

    private Date creationDate;

    private String modifyBy;

    private Date modifyDate;

    private String logopicPath;

    private String logolocPath;

    private Long versionId;

    private DevUser devUser;

    private AppVersion newAppVersion;

    public AppVersion getNewAppVersion() {
        return newAppVersion;
    }

    public void setNewAppVersion(AppVersion newAppVersion) {
        this.newAppVersion = newAppVersion;
    }

    public DevUser getDevUser() {
        return devUser;
    }

    public void setDevUser(DevUser devUser) {
        this.devUser = devUser;
    }

    private List<AppVersion> appVersions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getSupportRom() {
        return supportRom;
    }

    public void setSupportRom(String supportRom) {
        this.supportRom = supportRom;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    public Double getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(Double softwareSize) {
        this.softwareSize = softwareSize;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getOnsaleDate() {
        return onsaleDate;
    }

    public void setOnsaleDate(Date onsaleDate) {
        this.onsaleDate = onsaleDate;
    }

    public Date getOddsaleDate() {
        return oddsaleDate;
    }

    public void setOddsaleDate(Date oddsaleDate) {
        this.oddsaleDate = oddsaleDate;
    }

    public Long getFlatformId() {
        return flatformId;
    }

    public void setFlatformId(Long flatformId) {
        this.flatformId = flatformId;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getLogopicPath() {
        return logopicPath;
    }

    public void setLogopicPath(String logopicPath) {
        this.logopicPath = logopicPath;
    }

    public String getLogolocPath() {
        return logolocPath;
    }

    public void setLogolocPath(String logolocPath) {
        this.logolocPath = logolocPath;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public List<AppVersion> getAppVersions() {
        return appVersions;
    }

    public void setAppVersions(List<AppVersion> appVersions) {
        this.appVersions = appVersions;
    }


    public AppCategory getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(AppCategory categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public AppCategory getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(AppCategory categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    public AppCategory getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(AppCategory categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }
}