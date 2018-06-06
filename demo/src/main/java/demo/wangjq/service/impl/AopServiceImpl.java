package demo.wangjq.service.impl;

import demo.wangjq.service.AopService;

public class AopServiceImpl implements AopService {
    @Override
    public void doDealService() {
        System.out.println("deal service");
    }
}
