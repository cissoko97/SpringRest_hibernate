package org.centaurus.app.models.trader;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idclient;

    private String name;

    private String surname;

    private String comment;

    private String phone;

    @OneToMany
    private Set<Commande> commandes = new HashSet<>();

    public Client() {
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return idclient != null ? idclient.equals(client.idclient) : client.idclient == null;
    }

    @Override
    public int hashCode() {
        return idclient != null ? idclient.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idclient=" + idclient +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", comment='" + comment + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
