package com.example.csvparser;

import com.example.csvparser.csvHelper.CSVParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
//import com.example.csvparser.csvHelper;


@RestController

public class CSVController {
    @RequestMapping("/")
   public String index(@RequestParam(value = "csv") String csv) {
        String testInput = "\"Patient Name\",\"SSN\",\"Age\",\"Phone Number\",\"Status\"\n" +
                "\"Prescott, Zeke\",\"542-51-6641\",21,\"801-555-2134\",\"Opratory=2,PCP=1\"\n" +
                "\"Goldstein, Bucky\",\"635-45-1254\",42,\"435-555-1541\",\"Opratory=1,PCP=1\"\n" +
                "\"Vox, Bono\",\"414-45-1475\",51,\"801-555-2100\",\"Opratory=3,PCP=2\"";

        CSVParser parser=new CSVParser();
      String result =  parser.parseCSVString(csv);

       return result;

    }

}