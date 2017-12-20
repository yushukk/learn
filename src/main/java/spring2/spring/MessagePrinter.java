package spring2.spring;

/**
 * Created by ³¾¶« on 2017/4/27.
 */
public class MessagePrinter {

    private MessageService service;

    public MessageService getService() {
        return service;
    }

    public void setService(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}