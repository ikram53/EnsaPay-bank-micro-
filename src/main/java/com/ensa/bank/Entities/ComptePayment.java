package com.ensa.bank.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
public class ComptePayment {


    private int id_compte;


    private Double solde;

    private String type_compte;

    //private UserApp client;
    private int id_client;

    public ComptePayment(int id_compte, Double solde, String typeCompte, int idClient) {
        this.id_compte = id_compte;
        this.solde = solde;
        this.type_compte = typeCompte;
        this.id_client = idClient;
    }

    public ComptePayment(Double solde, String type_compte, int id_client) {
        this.solde = solde;
        this.type_compte = type_compte;
        this.id_client = id_client;
    }
}
