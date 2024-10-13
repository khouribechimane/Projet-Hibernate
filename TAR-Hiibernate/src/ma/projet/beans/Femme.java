
package ma.projet.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedNativeQueries({
     @NamedNativeQuery(
        name = "nombreEnfantsEntreDates",
        query = "SELECT SUM(m.nbrEnfant) "
              + "FROM mariage m "
              + "WHERE m.femme_id = :femmeId "
              + "AND m.dateFin BETWEEN :d1 AND :d2"
    )
})

@NamedQuery(
            name = "femmesMarieesDeuxFoisOuPlus",
            query = "SELECT f "
            + "FROM Femme f "
            + "WHERE f IN ("
            + "   SELECT m.femme "
            + "   FROM Mariage m "
            + "   GROUP BY m.femme "
            + "   HAVING COUNT(m.femme) >= 2"
            + ")"
           
    )
public class Femme extends Personne {
@OneToMany(mappedBy = "femme",fetch = FetchType.EAGER)
private List<Mariage> mariages;

    public Femme() {
    }

    public Femme(String nom, String prenom, String telephone, String adresse, Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }

}
