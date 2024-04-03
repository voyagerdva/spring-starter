package nn.ru.spring.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class SecondBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Class<?>> secondBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Second.class)) {
            secondBeans.put(beanName, bean.getClass());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = secondBeans.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    (InvocationHandler) (proxy, method, args) -> {
                        System.out.println("This is Second...");
                        try {
                            return method.invoke(bean, args);
                        } finally {
                            System.out.println("This is close Second...");
                        }
                    });
        }
        return bean;
    }
}
