
package ma.projet.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity 
@NamedQueries({
@NamedQuery(
    name = "getEpousesBetweenDates",
    query = "SELECT f FROM Femme f " +
            "INNER JOIN f.mariages m " +  // Assuming there's a relationship between Femme and Mariage
            "WHERE m.homme.id = :hommeId " +
            "AND m.dateFin BETWEEN :d1 AND :d2"
)
})

public class Homme extends Personne {
@OneToMany(mappedBy = "homme",fetch = FetchType.EAGER)
private List<Mariage> mariages;

    public Homme() {
    }

    public Homme(String nom, String prenom, String telephone, String adresse, Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }
    
  
    
}
