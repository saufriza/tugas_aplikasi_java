/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopapplication2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author zotskabs
 */
@Entity
@Table(name = "tblmahasiswa", catalog = "db_mahasiswa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tblmahasiswa.findAll", query = "SELECT t FROM Tblmahasiswa t"),
    @NamedQuery(name = "Tblmahasiswa.findByNim", query = "SELECT t FROM Tblmahasiswa t WHERE t.nim = :nim"),
    @NamedQuery(name = "Tblmahasiswa.findByNama", query = "SELECT t FROM Tblmahasiswa t WHERE t.nama = :nama"),
    @NamedQuery(name = "Tblmahasiswa.findByJurusan", query = "SELECT t FROM Tblmahasiswa t WHERE t.jurusan = :jurusan"),
    @NamedQuery(name = "Tblmahasiswa.findByFakultas", query = "SELECT t FROM Tblmahasiswa t WHERE t.fakultas = :fakultas")})
public class Tblmahasiswa implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nim")
    private Integer nim;
    @Column(name = "nama")
    private String nama;
    @Column(name = "jurusan")
    private String jurusan;
    @Column(name = "fakultas")
    private String fakultas;

    public Tblmahasiswa() {
    }

    public Tblmahasiswa(Integer nim) {
        this.nim = nim;
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        Integer oldNim = this.nim;
        this.nim = nim;
        changeSupport.firePropertyChange("nim", oldNim, nim);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        String oldNama = this.nama;
        this.nama = nama;
        changeSupport.firePropertyChange("nama", oldNama, nama);
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        String oldJurusan = this.jurusan;
        this.jurusan = jurusan;
        changeSupport.firePropertyChange("jurusan", oldJurusan, jurusan);
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        String oldFakultas = this.fakultas;
        this.fakultas = fakultas;
        changeSupport.firePropertyChange("fakultas", oldFakultas, fakultas);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblmahasiswa)) {
            return false;
        }
        Tblmahasiswa other = (Tblmahasiswa) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktopapplication2.Tblmahasiswa[nim=" + nim + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
