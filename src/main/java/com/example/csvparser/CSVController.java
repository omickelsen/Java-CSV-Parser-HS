package com.example.csvparser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
@RestController

public class CSVController {
    @RequestMapping("/")
   public String index(@RequestParam(value = "csv") String csv) {
       return csv;

    }

}