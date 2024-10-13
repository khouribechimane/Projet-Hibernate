package ma.projet.test;
import java.util.Calendar;
import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePK;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.ProjetService;
import ma.projet.services.TacheService;
import ma.projet.util.HibernateUtil;
import sun.applet.Main;
public class Test {
  public static void main(String[] args) {
        EmployeService es = new EmployeService();
        EmployeTacheService ets = new EmployeTacheService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();

       //creation des employes
        Employe e1 = new Employe("IMANE", "IMANE", "00000000");
        Employe e2 = new Employe("KHOURIBECH", "KHOURIBECH", "0999999");
        Employe e3 = new Employe("AYA", "AYA", "0777777");
        es.create(e2);
        es.create(e1);
        es.create(e3);
        //creation des projets 
        Projet p1 = new Projet("JAVA",new Date("2024/01/01"), new Date("2024/05/30"), e2);
        Projet p2 = new Projet("JEE",new Date("2024/01/01"), new Date("2024/05/30"), e2);
        ps.create(p1);
        ps.create(p2);
        //creation taches
        Tache t1 = new Tache("COMPILATION", new Date("2024/01/01"), new Date("2024/05/30"),20222 , p1);
        Tache t2 = new Tache("RUN", new Date("2024/01/01"), new Date("2024/05/30"),10111 , p2);
        ts.create(t1);
        ts.create(t2);
        
        EmployeTachePK etk = new EmployeTachePK(e2.getId(), t2.getId(),new Date("2020/01/01") );
        EmployeTache et = new EmployeTache(etk);
        ets.create(et);
        System.out.println(p2);
        System.out.println(e2.getProjets());
            Employe e = es.getById(2);
            e.getProjets().add(ps.getById(2));
            e.getEmployetaches().add(et);
        System.out.println(e.getProjets());
        //e2.getProjets().add(p);
        es.projetsParEmploye(e);
        es.getTachesparEmployee(e);

        // Attribution des tâches à "KHOURIBECH"
        Date dateAttribution = new Date();

        EmployeTachePK etk1 = new EmployeTachePK(e2.getId(), t1.getId(), dateAttribution);
        EmployeTache employeTache1 = new EmployeTache(etk1);
        ets.create(employeTache1);

        EmployeTachePK employeTachePK2 = new EmployeTachePK(e2.getId(), t2.getId(), dateAttribution);
        EmployeTache employeTache2 = new EmployeTache(employeTachePK2);
        ets.create(employeTache2);

        System.out.println("Tâches assignées à 'IMANE'.");
        es.getTachesparEmployee(e2);
        es.getProjetparEmployee(e2);
        System.out.println(p2.getId());
        ps.getTachesparProjets(p2);
        System.out.println("Projts assignées à 'IMANE'.");
        ps.getTachesEnProjet(p2);
        ts.getProjetparEmployee(t2);
        System.out.println(t2.getDateDebut());
        Date d1 = new Date("2024/02/01");
        Date d2 = new Date("2024/02/01");
        System.out.println(ts.getBetweenDate(d1, d2));
        for(Tache tt: ts.getBetweenDate(d1, d2)){
        System.out.println(tt);
        
 }

    }
}

