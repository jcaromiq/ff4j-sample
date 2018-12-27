package ff4console.conf

import org.ff4j.FF4j
import org.ff4j.web.FF4jDispatcherServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(value = ["org.ff4j.spring.boot.web.api", "org.ff4j.services", "org.ff4j.aop", "org.ff4j.spring"])
class FF4jServletConfiguration : SpringBootServletInitializer() {

    @Bean
    fun getFF4j(): FF4j = FF4j()

    @Bean
    fun getFF4JServlet(): FF4jDispatcherServlet =
            FF4jDispatcherServlet().apply { ff4j = getFF4j() }

    @Bean
    fun ff4jDispatcherServletRegistrationBean(): ServletRegistrationBean =
            ServletRegistrationBean(getFF4JServlet(), "/ff4j-web-console/*")

}