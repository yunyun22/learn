package demo.wangjq.excel.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.List;

/**
 * @author wang, jinqiao
 * @title: AreaTree
 * @date 17/02/2020
 */
public class Area {
    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("name")
    private String name;

    @ExcelProperty("parent_id")
    private Integer parentId;

    @ExcelProperty("short_name")
    private String shortName;

    @ExcelProperty("level_type")
    private Integer levelType;

    @ExcelProperty("city_code")
    private String cityCode;

    @ExcelProperty("zip_code")
    private String zipCode;

    @ExcelProperty("merger_name")
    private String mergerName;

    @ExcelProperty("lng")
    private String lng;

    @ExcelProperty("lat")
    private String lat;

    @ExcelProperty("pinyin")
    private String pinyin;

    private List<Area> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getLevelType() {
        return levelType;
    }

    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public List<Area> getChildren() {
        return children;
    }

    public void setChildren(List<Area> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "AreaTree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", shortName='" + shortName + '\'' +
                ", levelType=" + levelType +
                ", cityCode='" + cityCode + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", mergerName='" + mergerName + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", children=" + children +
                '}';
    }
}
