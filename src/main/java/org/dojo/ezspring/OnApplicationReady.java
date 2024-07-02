package org.dojo.ezspring;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnApplicationReady implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("어플리케이션 실행 성공했다고 알려주려는데 인터럽트 당함.");
        }
        System.out.println("애플리케이션이 성공적으로 실행되었습니다!");
    }
}
