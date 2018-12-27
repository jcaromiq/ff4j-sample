package awesomeweb.controller

import awesomeweb.service.FFWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController @Autowired constructor(val ff:FFWrapper ) {

    @GetMapping("/greeting")
    fun home():ResponseEntity<String> {
        return ResponseEntity.ok(ff.enabled("AwesomeFeature").toString())
    }
}