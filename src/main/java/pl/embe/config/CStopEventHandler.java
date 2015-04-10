package pl.embe.config;

/**
 * Created by Michal_Bucki on 01/04/2015.
 */
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class CStopEventHandler
        implements ApplicationListener<ContextStoppedEvent>{

    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("ContextStoppedEvent Received");
    }
}