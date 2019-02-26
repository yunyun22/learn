package demo.wangjq.base.designpattern;

/**
 * Created by wangjq on 2018/7/12.
 */
public class AdapterTest {

    public static void main(String[] args) {
        Phone p = new Phone();

        UsbB usbB = new UsbAdpter();

        p.charge(usbB);
    }


}

class UsbAdpter extends IphoneUsbC implements UsbB {

    @Override
    public void linkedPhoneTypeB() {
        super.linkedPhoneTypeC();
    }
}


class Phone {
    void charge(UsbB usbB) {
        usbB.linkedPhoneTypeB();
        System.out.println("充电");
    }
}

interface UsbB {

    void linkedPhoneTypeB();

}

interface UsbC {
    void linkedPhoneTypeC();
}

class IphoneUsbC implements UsbC {
    @Override
    public void linkedPhoneTypeC() {
        System.out.println("Apple of usb linked to phone");
    }
}
