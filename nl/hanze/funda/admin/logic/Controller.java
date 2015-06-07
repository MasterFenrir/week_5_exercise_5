package nl.hanze.funda.admin.logic;

import connector.DatabaseConnection;
import nl.hanze.funda.admin.ui.InputButton;
import nl.hanze.funda.admin.ui.InputCombo;
import nl.hanze.funda.admin.ui.Login;
import nl.hanze.funda.admin.ui.MainScreen;
import org.hibernate.Session;
import tables.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sander on 7-6-2015.
 */
public class Controller {

    private Login login;
    private MainScreen mainScreen;
    private Session session;
    private UserSession userSession;
    private User user;

    public Controller() {
        makeLogin();
    }

    /**
     * Make the loginscreen
     */
    private void makeLogin() {
        login = new Login();
        login.setLoginAction(this::login);
    }

    /**
     * Login method as actionListener
     *
     * @param actionEvent
     */
    private void login(ActionEvent actionEvent) {
        try {
            session = DatabaseConnection.getSession();
            userSession = new UserSession(session);
            user = userSession.login(login.getUserName(), login.getPassword());
            buildMainScreen();
            login.setVisible(false);
        } catch (Exception e) {
            login.setError(e.getMessage());
        }
    }

    private void buildMainScreen() {
        mainScreen = new MainScreen();
        fillInMainScreen();
        addActionListeners();

    }

    private void fillInMainScreen() {
        String ligging = "ligging";
        List<LiggingEntity> liggings = session.createQuery("FROM LiggingEntity ").list();
        List<String> liggingStrings = new ArrayList<>();
        liggingStrings.add("");
        liggings.forEach(e -> liggingStrings.add(e.getName()));
        for (int i = 1; i < 9; i++) {
            ((InputCombo) mainScreen.getWoningElement(ligging + i)).addValues(liggingStrings);
        }

        List<SoortobjectEntity> object = session.createQuery("FROM SoortobjectEntity").list();
        List<String> objectStrings = new ArrayList<>();
        object.forEach(e -> objectStrings.add(e.getName()));
        ((InputCombo) mainScreen.getWoningElement("soortobject")).addValues(objectStrings);

        List<SoortwoningEntity> woning = session.createQuery("FROM SoortwoningEntity").list();
        List<String> woningStrings = new ArrayList<>();
        woning.forEach(e -> woningStrings.add(e.getName()));
        ((InputCombo) mainScreen.getWoningElement("soort")).addValues(woningStrings);

        List<TypewoningEntity> type = session.createQuery("FROM TypewoningEntity").list();
        List<String> typeStrings = new ArrayList<>();
        type.forEach(e -> typeStrings.add(e.getName()));
        ((InputCombo) mainScreen.getWoningElement("type")).addValues(typeStrings);

        List<SoortbouwEntity> bouw = session.createQuery("FROM SoortbouwEntity").list();
        List<String> bouwStrings = new ArrayList<>();
        bouw.forEach(e -> bouwStrings.add(e.getName()));
        ((InputCombo) mainScreen.getWoningElement("soortbouw")).addValues(bouwStrings);

        List<StatusEntity> status = session.createQuery("FROM StatusEntity").list();
        List<String> statusStrings = new ArrayList<>();
        status.forEach(e -> statusStrings.add(e.getName()));
        ((InputCombo) mainScreen.getWoningElement("status")).addValues(statusStrings);
    }

    private void addActionListeners() {
        ((InputButton) mainScreen.getMakelaarElement("zoekbutton")).setActionListener(e -> searchBroker());
        ((InputButton) mainScreen.getWoningElement("zoekbutton")).setActionListener(e -> searchHouses());
    }

    private void searchBroker() {
        System.out.print("...hello?");
        String mkmdwid = mainScreen.getMakelaarElement("mkmdwid").getValue();
        if (mkmdwid.trim().isEmpty()) {
            mainScreen.setMakelaarNotifyLabel("Geen geldige input.");
            return;
        }
        List<Object[]> results = user.searchBroker(mkmdwid);
        if (results.isEmpty()) {
            mainScreen.setMakelaarNotifyLabel("Niets gevonden.");
            return;
        }
        mainScreen.setMakelaarNotifyLabel("");
        System.out.println("Hello!");
        Object[] result = results.get(0);
        MkantoormdwEntity mk = (MkantoormdwEntity) result[0];
        AccountsEntity acc = (AccountsEntity) result[1];
        MkantoorEntity mkk = (MkantoorEntity) result[2];
        mainScreen.getMakelaarElement("naam").setValue(mk.getName());
        mainScreen.getMakelaarElement("gebruikersnaam").setValue(acc.getUsername());
        mainScreen.getMakelaarElement("wachtwoord").setValue(acc.getPassword());
        mainScreen.getMakelaarElement("koppel").setValue(mk.getMkid().toString());
        mainScreen.getMakelaarElement("kantoornaam").setValue(mkk.getName());
        mainScreen.getMakelaarElement("adres").setValue(mkk.getAddress());
        mainScreen.getMakelaarElement("postode").setValue(mkk.getPc());
        mainScreen.getMakelaarElement("plaats").setValue(mkk.getCity());
        mainScreen.getMakelaarElement("telnr").setValue(mkk.getPhone());
    }

    private void searchHouses() {
        String woid = mainScreen.getWoningElement("zoeken").getValue();
        if (woid.trim().isEmpty()) {
            mainScreen.setWoNotifyLabel("Geen geldige input.");
            return;
        }
        List<Object[]> results = user.searchHouse(woid);
        if (results.isEmpty()) {
            mainScreen.setWoNotifyLabel("Niets gevonden.");
            return;
        }
        mainScreen.setWoNotifyLabel("");

        Object[] result = results.get(0);
        WoEntity wo = (WoEntity) result[0];
        SoortobjectEntity ob = (SoortobjectEntity) result[2];
        SoortwoningEntity swo = (SoortwoningEntity) result[1];
        SoortbouwEntity sbo = (SoortbouwEntity) result[3];
        TypewoningEntity two = (TypewoningEntity) result[5];
        StatusEntity status = (StatusEntity) result[4];
        mainScreen.getWoningElement("koppelmkid").setValue(wo.getMkmdwid().toString());
        mainScreen.getWoningElement("adres").setValue(wo.getAddress());
        mainScreen.getWoningElement("postcode").setValue(wo.getPc());
        mainScreen.getWoningElement("plaats").setValue(wo.getCity());
        mainScreen.getWoningElement("prijs").setValue(wo.getVraagprijs().toString());
        mainScreen.getWoningElement("oppervlakte").setValue(wo.getWoonOppervlakte().toString());
        mainScreen.getWoningElement("inhoud").setValue(wo.getInhoud().toString());
        mainScreen.getWoningElement("kamers").setValue(wo.getAantalKamers().toString());
        mainScreen.getWoningElement("badkamers").setValue(wo.getAantalBadkamers().toString());
        mainScreen.getWoningElement("woonlagen").setValue(wo.getWoonOppervlakte().toString());
        mainScreen.getWoningElement("plaatsingsdatum").setValue(wo.getPlaatsingDatum().toString());
        mainScreen.getWoningElement("bouwjaar").setValue(wo.getBouwJaar().toString());
        mainScreen.getWoningElement("omschrijving").setValue(wo.getOmschrijving());

        mainScreen.getWoningElement("soortobject").setValue(ob.getName());
        mainScreen.getWoningElement("soort").setValue(swo.getName());
        mainScreen.getWoningElement("type").setValue(two.getName());
        mainScreen.getWoningElement("soortbouw").setValue(sbo.getName());
        mainScreen.getWoningElement("status").setValue(status.getName());
        mainScreen.getWoningElement("tuinaanwezig").setValue(wo.getTuinAanwezig().toString());

        int i = 1;
        for (Object[] e : user.getLiggings(woid)) {
            mainScreen.getWoningElement("ligging" + i).setValue(((LiggingEntity) e[1]).getName());
            i++;
        }
    }
}
