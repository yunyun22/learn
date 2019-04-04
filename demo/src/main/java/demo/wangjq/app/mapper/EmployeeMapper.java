package demo.wangjq.app.mapper;

import demo.wangjq.app.domain.Employee;


/**
 * @author wangjq
 */
public interface EmployeeMapper {

    /**
     * 查询员工信息
     *
     * @param id 查询参数
     * @return 员工信息
     */
    Employee selectEmployee(Integer id);
}
