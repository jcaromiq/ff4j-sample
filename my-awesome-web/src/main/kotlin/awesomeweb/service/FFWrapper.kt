package awesomeweb.service

import org.ff4j.FF4j
import org.ff4j.core.Feature
import org.ff4j.exception.FeatureNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class FFWrapper @Autowired constructor(private val ff4j: FF4j) {

    fun enabled(featureID: String): Boolean =
            getFeature(featureID)
                    .map { it.isEnable }
                    .orElse(false)

    fun getFeature(featureID: String): Optional<Feature> =
            try {
                Optional.of(ff4j.getFeature(featureID))
            } catch (nf: FeatureNotFoundException) {
                Optional.empty()
            }
}