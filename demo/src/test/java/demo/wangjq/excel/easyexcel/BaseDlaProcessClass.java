package demo.wangjq.excel.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * <p>
 * 流程阶段
 * </p>
 *
 * @author wangjq
 * @since 2020-09-23
 */
public class BaseDlaProcessClass {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ExcelProperty("PROCESS_CLASS_ID")
	private String processClassId;

	/**
	 * 流程阶段ID
	 */
	@ExcelProperty("PROCESS_TYPE_ID")
	private String processTypeId;

	/**
	 * CODE
	 */
	@ExcelProperty("PROCESS_CLASS_CODE")
	private String processClassCode;

	/**
	 * 名称
	 */
	@ExcelProperty("PROCESS_CLASS_NAME")
	private String processClassName;



	/**
	 * 员工类型
	 */
	@ExcelProperty("EMP_CLASS")
	private String empClass;

	public String getProcessClassId() {
		return processClassId;
	}

	public void setProcessClassId(String processClassId) {
		this.processClassId = processClassId;
	}

	public String getProcessTypeId() {
		return processTypeId;
	}

	public void setProcessTypeId(String processTypeId) {
		this.processTypeId = processTypeId;
	}

	public String getProcessClassCode() {
		return processClassCode;
	}

	public void setProcessClassCode(String processClassCode) {
		this.processClassCode = processClassCode;
	}

	public String getProcessClassName() {
		return processClassName;
	}

	public void setProcessClassName(String processClassName) {
		this.processClassName = processClassName;
	}

	public String getEmpClass() {
		return empClass;
	}

	public void setEmpClass(String empClass) {
		this.empClass = empClass;
	}

	@Override
	public String toString() {
		return "BaseDlaProcessClass{" +
				"processClassId=" + processClassId +
				", processTypeId=" + processTypeId +
				", processClassCode=" + processClassCode +
				", processClassName=" + processClassName +
				"}";
	}
}
