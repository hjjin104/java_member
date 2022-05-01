package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    //컨테이너에 등록된 모든 빈 조회
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            //빈 꺼내기(타입을 정하지 않았기 때문에 오브젝트가 꺼내짐)
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = "+beanDefinitionName+" / object = "+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames){
            //Bean 하나하나에 대한 metadata 정보들
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //"스프링 내부의 빈이 아닌 내가 개발하기 위해 등록한 빈"인 경우에만 출력하도록 함
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = "+beanDefinitionName+" / object = "+bean);
            }
        }
    }
}
