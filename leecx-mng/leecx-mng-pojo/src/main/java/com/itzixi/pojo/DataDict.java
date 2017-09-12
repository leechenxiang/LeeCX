package com.itzixi.pojo;

public class DataDict {
    private Integer id;

    private String typeName;

    private String typeCode;

    private String ddkey;

    private String ddvalue;

    private Integer isShow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getDdkey() {
        return ddkey;
    }

    public void setDdkey(String ddkey) {
        this.ddkey = ddkey == null ? null : ddkey.trim();
    }

    public String getDdvalue() {
        return ddvalue;
    }

    public void setDdvalue(String ddvalue) {
        this.ddvalue = ddvalue == null ? null : ddvalue.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
}