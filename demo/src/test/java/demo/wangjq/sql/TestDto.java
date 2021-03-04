package demo.wangjq.sql;

/**
 * @author wang  ; jinqiao
 * @title: TestDto
 * @date 22/01/2021
 */
public class TestDto {

    private String auditStatus;
    private String reviewer;
    private String lastUpdateDate;
    private String submittedByEnName;
    private String submittedOn;
    private String borrowId;
    private String id;
    private String requestNo;
    private String projectName;
    private String code;
    private String clientName;


    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getSubmittedByEnName() {
        return submittedByEnName;
    }

    public void setSubmittedByEnName(String submittedByEnName) {
        this.submittedByEnName = submittedByEnName;
    }

    public String getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(String submittedOn) {
        this.submittedOn = submittedOn;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "borrowId='" + borrowId + '\'' +
                ", id='" + id + '\'' +
                ", requestNo='" + requestNo + '\'' +
                ", projectName='" + projectName + '\'' +
                ", code='" + code + '\'' +
                ", clientName='" + clientName + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                ", submittedByEnName='" + submittedByEnName + '\'' +
                ", submittedOn='" + submittedOn + '\'' +
                '}';
    }
}
