package demo.wangjq.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author:wangjq
 * @Date: 2019/7/22 14:14
 */
public class ParkingDataSmsHandler implements EventHandler<InParkingDataEvent> {


    @Override
    public void onEvent(InParkingDataEvent event, long sequence, boolean endOfBatch) throws Exception {
        long threadId = Thread.currentThread().getId();
        String carLicense = event.getCarLicense();
        System.out.println(String.format("Thread Id %s send %s in plaza sms to user", threadId, carLicense));
    }
}
