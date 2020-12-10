package demo.wangjq.excel.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author wang, jinqiao
 * @title: ToolKitReferenceDto
 * @date 09/12/2020
 */
public class ToolKitReferenceDto {

    @ExcelProperty("file_id")
    private String fileId;

    @ExcelProperty("type")
    private String type;

    @ExcelProperty("sort")
    private String sort;

    @ExcelProperty("task_id")
    private String taskId;

    @ExcelProperty("name")
    private String name;

    @ExcelProperty("link")
    private String link;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
