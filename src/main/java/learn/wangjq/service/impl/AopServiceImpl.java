package learn.wangjq.service.impl;

import learn.wangjq.service.AopService;

public class AopServiceImpl implements AopService {
    @Override
    public void doDealService() {
        System.out.println("deal service");
    }
}
