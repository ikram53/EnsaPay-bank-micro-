package com.ensa.bank.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class UserApp {



    private int id_user;

    private String nom;

    private String prenom;

    private  String numTel;

    private Date passwordChangedTime;


    private String password;


    private String profil;


    private String username;


    private Boolean firstAuth;


    private byte[] cinRecto;


    private byte[] cinVerso;


    private Collection<ComptePayment> comptePayements;

    public UserApp(String nom, String prenom, String numTel, Date passwordChangedTime, String password, String profil, String username, byte[] cinRecto, byte[] cinVerso) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.passwordChangedTime = passwordChangedTime;
        this.password = password;
        this.profil = profil;
        this.username = username;
        this.cinRecto = cinRecto;
        this.cinVerso = cinVerso;
    }

}
