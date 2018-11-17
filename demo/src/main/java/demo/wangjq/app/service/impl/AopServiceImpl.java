package demo.wangjq.app.service.impl;

import demo.wangjq.app.service.AopService;

public class AopServiceImpl implements AopService {
    @Override
    public void doDealService() {
        System.out.println("deal service");
    }
}
