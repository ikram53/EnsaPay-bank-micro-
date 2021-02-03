package com.ensa.bank.Controller;

import com.ensa.bank.Entities.ComptePayment;
import com.ensa.bank.Service.OpenCsvWriterByAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ComptePaymentController {

    @Autowired
    OpenCsvWriterByAppend openCsvWriterByAppend;

    @RequestMapping(value="/comptePayment/creation",method= RequestMethod.POST)
    public void saveComptePay(@RequestBody ComptePayment comptePayment) {
         openCsvWriterByAppend.addCompteToCsvFile(comptePayment);
    }
}
