
package ma.projet.beans;


import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Mariage  {
    
    @EmbeddedId
    private MariagePK pk ;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin ;
    private int nbrEnfant ;
    @ManyToOne
    @JoinColumn( name ="homme" , insertable =false , updatable =false)
    private Homme homme ;
    @ManyToOne
    @JoinColumn( name ="femme" , insertable =false , updatable =false)
    private Femme femme ;

    public Mariage() {
    }

    public Mariage(MariagePK pk, Date dateFin, int nbrEnfant) {
        this.pk = pk;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
        
    }

    public MariagePK getPk() {
        return pk;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }


    public void setPk(MariagePK pk) {
        this.pk = pk;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }

   

    @Override
    public String toString() {
        return "Mariage{" + "pk=" + pk + ", dateFin=" + dateFin + ", nbrEnfant=" + nbrEnfant + ", homme=" + homme + ", femme=" + femme + '}';
    }
    
    
    

   
}
