package demo.wangjq.excel.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author wang, jinqiao
 * @title: ToolkitDto
 * @date 08/12/2020
 */
public class ToolkitDto {


    @ExcelProperty("id")
    private String id;


    @ExcelProperty("category_id")
    private String categoryId;


    @ExcelProperty("desc_cn")
    private String desCn;

    @ExcelProperty("desc_en")
    private String desEn;

    @ExcelProperty("detail_cn")
    private String detailCn;

    @ExcelProperty("detail_en")
    private String detailEn;

    @ExcelProperty("title_cn")
    private String titleCn;

    @ExcelProperty("title_en")
    private String titleEn;

    @ExcelProperty("sort")
    private String sort;

    @ExcelProperty("base_id")
    private String baseId;


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDesCn() {
        return desCn;
    }

    public void setDesCn(String desCn) {
        this.desCn = desCn;
    }

    public String getDesEn() {
        return desEn;
    }

    public void setDesEn(String desEn) {
        this.desEn = desEn;
    }

    public String getDetailCn() {
        return detailCn;
    }

    public void setDetailCn(String detailCn) {
        this.detailCn = detailCn;
    }

    public String getDetailEn() {
        return detailEn;
    }

    public void setDetailEn(String detailEn) {
        this.detailEn = detailEn;
    }

    public String getTitleCn() {
        return titleCn;
    }

    public void setTitleCn(String titleCn) {
        this.titleCn = titleCn;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    @Override
    public String toString() {
        return "ToolkitDto{" +
                "categoryId='" + categoryId + '\'' +
                ", desCn='" + desCn + '\'' +
                ", desEn='" + desEn + '\'' +
                ", detailCn='" + detailCn + '\'' +
                ", detailEn='" + detailEn + '\'' +
                ", titleCn='" + titleCn + '\'' +
                ", titleEn='" + titleEn + '\'' +
                ", sort='" + sort + '\'' +
                ", baseId='" + baseId + '\'' +
                '}';
    }
}
