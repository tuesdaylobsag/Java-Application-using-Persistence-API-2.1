/**
 * This is an Entity class. It allow us to manipulate the data inside the 
 * database. This is a normal class with setters and getters
 */
package com.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Ricardo Saumeth
 * @version 03/06/2014
 */
@Entity
@Table(name = "coach_trip", catalog = "coachtrip", schema = "")
@NamedQueries({
    @NamedQuery(name = "CoachTrip.findAll", query = "SELECT c FROM CoachTrip c"),
    @NamedQuery(name = "CoachTrip.findById", query = "SELECT c FROM CoachTrip c WHERE c.id = :id"),
    @NamedQuery(name = "CoachTrip.findByFirstname", query = "SELECT c FROM CoachTrip c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "CoachTrip.findByLastname", query = "SELECT c FROM CoachTrip c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "CoachTrip.findByPhone", query = "SELECT c FROM CoachTrip c WHERE c.phone = :phone"),
    @NamedQuery(name = "CoachTrip.findByAdults", query = "SELECT c FROM CoachTrip c WHERE c.adults = :adults"),
    @NamedQuery(name = "CoachTrip.findByChildren", query = "SELECT c FROM CoachTrip c WHERE c.children = :children"),
    @NamedQuery(name = "CoachTrip.findByTripdestination", query = "SELECT c FROM CoachTrip c WHERE c.tripdestination = :tripdestination")})
public class CoachTrip implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Column(name = "adults")
    private Integer adults;
    @Column(name = "children")
    private Integer children;
    @Basic(optional = false)
    @Column(name = "tripdestination")
    private String tripdestination;

    public CoachTrip() {
    }

    public CoachTrip(Integer id) {
        this.id = id;
    }

    public CoachTrip(Integer id, String firstname, String lastname, String phone, String tripdestination) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.tripdestination = tripdestination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        Integer oldAdults = this.adults;
        this.adults = adults;
        changeSupport.firePropertyChange("adults", oldAdults, adults);
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        Integer oldChildren = this.children;
        this.children = children;
        changeSupport.firePropertyChange("children", oldChildren, children);
    }

    public String getTripdestination() {
        return tripdestination;
    }

    public void setTripdestination(String tripdestination) {
        String oldTripdestination = this.tripdestination;
        this.tripdestination = tripdestination;
        changeSupport.firePropertyChange("tripdestination", oldTripdestination, tripdestination);
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
        if (!(object instanceof CoachTrip)) {
            return false;
        }
        CoachTrip other = (CoachTrip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.view.CoachTrip[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
