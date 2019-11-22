package demo.wangjq.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * @author wang, jinqiao
 * @title: ActivitiTest
 * @date 12/11/2019
 */

public class ActivitiTest {

    public static final  String activitiXMLResource = "bpmn/Process-1.xml";

    public static final  String activitiPNGResource = "bpmn/Process-1.png";


    @Test
    public void deploy(){
        // 引擎配置
        ProcessEngineConfiguration pec=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/activiti.cfg.xml");
        // 获取流程引擎对象
        ProcessEngine processEngine=pec.buildProcessEngine();

        Deployment deploy = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource(activitiXMLResource)
                .addClasspathResource(activitiPNGResource)
                .deploy();


    }

    @Test
    public void startProcess(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById("1");

        System.out.println("id:"+processInstance.getId()+"activitiID:"+processInstance.getActivityId());

    }

    public void queryMyTask(){



    }
}
