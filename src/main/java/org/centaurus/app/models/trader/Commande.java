package org.centaurus.app.models.trader;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Article article;

    private Date cmddate;

    private Boolean cmdState;

    private int qte;

    @OneToOne
    @JoinColumn(name = "idclient")
    private Client client;

    public Commande() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Date getCmddate() {
        return cmddate;
    }

    public void setCmddate(Date cmddate) {
        this.cmddate = cmddate;
    }

    public Boolean getCmdState() {
        return cmdState;
    }

    public void setCmdState(Boolean cmdState) {
        this.cmdState = cmdState;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

}
