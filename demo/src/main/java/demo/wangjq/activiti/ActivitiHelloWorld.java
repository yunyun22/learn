package demo.wangjq.activiti;

import cn.hutool.core.collection.CollectionUtil;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

public class ActivitiHelloWorld {


    public static ProcessEngine getProcessEngineConfiguration() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        //定义连接mysql数据库
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://118.25.67.106:3306/test?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("root");

       /*  public static final String DB_SCHEMA_UPDATE_FALSE = "false";操作activiti23张表的时候，如果表不存在，就抛出异常，不能自动创建23张表
         public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";每次操作，都会先删除表，再创建表
         public static final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，就创建表，如果表存在，就直接操作		*/


        //TODO DB_SCHEMA_UPDATE_CREATE_DROP不生效
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        return configuration.buildProcessEngine();
    }

    @Test
    public void deployProcess() {
        RepositoryService repositoryService = getProcessEngineConfiguration().getRepositoryService();
        Deployment deploy = repositoryService
                .createDeployment()
                .name("请假流程001")
                .addClasspathResource("bpmn/HelloWorld.png")
                .addClasspathResource("bpmn/HelloWorld.bpmn")
                .deploy();

        System.out.println("部署成功。流程部署id:" + deploy.getId());

    }


    @Test
    public void startProcess() {
        RuntimeService runtimeService = getProcessEngineConfiguration().getRuntimeService();
        runtimeService.startProcessInstanceById("HelloWorld:1:2504");
        System.out.println("启动成功");
    }


    @Test
    public void findTask() {
        TaskService taskService = getProcessEngineConfiguration().getTaskService();
        List<Task> taskList = taskService.createTaskQuery().taskAssignee("王五").list();
        if (CollectionUtil.isNotEmpty(taskList)) {
            taskList.forEach(task -> {
                System.out.println("taskId=" + task.getId());
                System.out.println("taskName=" + task.getName());
                System.out.println("assignee=" + task.getAssignee());

            });
        }
    }

    @Test
    public void completeTask() {
        TaskService taskService = getProcessEngineConfiguration().getTaskService();
        String taskId = "15002";
        taskService.complete(taskId);
        System.out.println("完成任务");

    }
}
