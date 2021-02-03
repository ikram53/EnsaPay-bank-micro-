package com.ensa.bank.Config;

import java.io.File;
import java.io.IOException;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class TaskletStep implements Tasklet {

   // private String csvFilename = "C:\\Users\\pc\\Documents\\bank\\src\\main\\resources\\comptPay.csv";
    private  String csvFilename="src\\main\\resources\\comptPay.csv";
    public static int i=1;
    public TaskletStep() throws IOException {
        File file = new File(this.getCsvFilename());
        file.createNewFile();
    }

    public String getCsvFilename() {
        return csvFilename;
    }

    public void setCsvFilename(String csvFilename) {
        this.csvFilename = csvFilename;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        try{
            File file = new File(csvFilename);
            System.out.println(file.exists());
            if(file.delete()){

                System.out.println("### TaskletStep:" + file.getName() + " is deleted!");

                this.setCsvFilename("C:\\Users\\pc\\Documents\\bank\\src\\main\\resources\\compte-"+i+".csv");
                File file2 = new File(this.getCsvFilename());
                file2.createNewFile();

                i++;
            }else{
                System.out.println("Delete operation is failed.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
