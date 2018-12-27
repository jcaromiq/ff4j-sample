package awesomeweb.conf

import org.ff4j.FF4j
import org.ff4j.web.jersey2.store.FeatureStoreHttp
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FF4jConfiguration {

    @Bean
    fun ff4j(): FF4j =
            FF4j().apply {
                featureStore = FeatureStoreHttp("http://ff4j-console:8080/api/ff4j")
            }
}