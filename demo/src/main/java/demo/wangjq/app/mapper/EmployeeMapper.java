package demo.wangjq.app.mapper;

import demo.wangjq.app.domain.Employee;

public interface EmployeeMapper {

    Employee selectEmployee(Integer id);
}
