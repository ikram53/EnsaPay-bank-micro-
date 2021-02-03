package com.ensa.bank.Service;

import com.ensa.bank.Config.TaskletStep;
import com.ensa.bank.Entities.ComptePayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;

@Service
public class OpenCsvWriterByAppend {
   //String csvFilename = "C:\\Users\\pc\\Documents\\bank\\src\\main\\resources\\newFile.csv";
    @Autowired
    TaskletStep taskletStep;

    public  void addCompteToCsvFile(ComptePayment comptePayment){
        try {
            System.out.println("add Compte To csv file");
            System.out.println(taskletStep.getCsvFilename());
            FileWriter csvwriter = new FileWriter(taskletStep.getCsvFilename());

            csvwriter.append(comptePayment.getSolde().toString());
            csvwriter.append(",");

            csvwriter.append(comptePayment.getType_compte());
            csvwriter.append(",");
            csvwriter.append((char)comptePayment.getId_client());


            csvwriter.close();
            System.out.println("CSV file created succesfully.");
        } catch (Exception e) {
            System.out.println("exception :" + e.getMessage());
        }


    }
}
