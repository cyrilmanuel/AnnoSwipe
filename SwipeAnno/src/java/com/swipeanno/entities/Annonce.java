/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swipeanno.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "annonce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annonce.findAll", query = "SELECT a FROM Annonce a")
    , @NamedQuery(name = "Annonce.findForUser", query = "SELECT a FROM Annonce a WHERE a.annonceUserId = :annonceUserId")
    , @NamedQuery(name = "Annonce.findById", query = "SELECT a FROM Annonce a WHERE a.id = :id")
    , @NamedQuery(name = "Annonce.findByAnnonceName", query = "SELECT a FROM Annonce a WHERE a.annonceName = :annonceName")
    , @NamedQuery(name = "Annonce.findByAnnoncePrice", query = "SELECT a FROM Annonce a WHERE a.annoncePrice = :annoncePrice")
    , @NamedQuery(name = "Annonce.findByAnnoncedateParution", query = "SELECT a FROM Annonce a WHERE a.annoncedateParution = :annoncedateParution")})
public class Annonce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "annonce_name")
    private String annonceName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annonce_price")
    private double annoncePrice;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "annonce_description")
    private String annonceDescription;
    @Column(name = "annonce_dateParution")
    @Temporal(TemporalType.TIMESTAMP)
    private Date annoncedateParution;
    @JoinColumn(name = "annonce_user_id", referencedColumnName = "id")
    @ManyToOne
    private Users annonceUserId;

    public Annonce() {
    }

    public Annonce(Integer id) {
        this.id = id;
    }

    public Annonce(Integer id, String annonceName, double annoncePrice, String annonceDescription) {
        this.id = id;
        this.annonceName = annonceName;
        this.annoncePrice = annoncePrice;
        this.annonceDescription = annonceDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnonceName() {
        return annonceName;
    }

    public void setAnnonceName(String annonceName) {
        this.annonceName = annonceName;
    }

    public double getAnnoncePrice() {
        return annoncePrice;
    }

    public void setAnnoncePrice(double annoncePrice) {
        this.annoncePrice = annoncePrice;
    }

    public String getAnnonceDescription() {
        return annonceDescription;
    }

    public void setAnnonceDescription(String annonceDescription) {
        this.annonceDescription = annonceDescription;
    }

    public Date getAnnoncedateParution() {
        return annoncedateParution;
    }

    public void setAnnoncedateParution(Date annoncedateParution) {
        this.annoncedateParution = annoncedateParution;
    }

    public Users getAnnonceUserId() {
        return annonceUserId;
    }

    public void setAnnonceUserId(Users annonceUserId) {
        this.annonceUserId = annonceUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annonce)) {
            return false;
        }
        Annonce other = (Annonce) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.swipeanno.entities.Annonce[ id=" + id + " ]";
    }
    
}
