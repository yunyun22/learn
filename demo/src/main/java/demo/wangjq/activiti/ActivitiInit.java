package demo.wangjq.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @author wang, jinqiao
 * @title: ActivitiInit
 * @date 06/11/2019
 */
public class ActivitiInit {

    public static void main(String[] args) {
        ProcessEngine processEngine = ActivitiHelloWorld.getProcessEngineConfiguration();
        System.out.println("processEngine：" + processEngine);
    }
}
