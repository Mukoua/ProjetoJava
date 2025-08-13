package dev.Anderson.My_First_Web_App.controllers;


import dev.Anderson.My_First_Web_App.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/test/v1")
public class TestLogController {
    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog() {

        logger.debug("This is my DEBUG log");
        logger.info("This is my INFO log");
        logger.warn("This is my WARN log");
        logger.error("This is my ERROR log");
        return "Logs generated successfully!!";
    }
}
