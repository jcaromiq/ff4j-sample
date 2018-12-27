package awesomeweb.controller

import awesomeweb.service.FFWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FeatureController @Autowired constructor(val ff: FFWrapper) {

    @GetMapping("/")
    fun home(): ResponseEntity<String> =
            ff.operateWith("AwesomeFeature",
                    ResponseEntity("Not available", HttpStatus.NOT_FOUND),
                    ResponseEntity("This is the awesome Feature", HttpStatus.OK))
}
