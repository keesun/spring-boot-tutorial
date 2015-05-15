package me.whiteship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Keeun Baik
 */
@RestController
public class HelloController {

    @Autowired
    LolProperties lolProperties;

    @RequestMapping("/")
    public String hi() {
        return lolProperties.getName() + " " + lolProperties.getLevel();
    }

}
