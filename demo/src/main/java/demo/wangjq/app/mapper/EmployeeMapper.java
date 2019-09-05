package demo.wangjq.app.mapper;

import org.apache.ibatis.annotations.Param;

import demo.wangjq.app.domain.Employee;


/**
 * @author wangjq
 */
public interface EmployeeMapper {

    /**
     * 查询员工信息
     *
     * @param id   查询参数
     * @param name 名称
     * @return 员工信息
     */
    Employee selectEmployee(@Param("id") Integer id, @Param("name") String name);

    /**
     * 更新员工信息
     *
     * @param employee 员工
     * @return 成功的数量
     */
    int updateEmployee(Employee employee);
}
