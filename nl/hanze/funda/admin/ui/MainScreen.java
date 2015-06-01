package nl.hanze.funda.admin.ui;

import java.awt.Component;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import nl.hanze.funda.admin.settings.Settings;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {
	private Map<String, InputElement> makelaarPanelEls = new HashMap<String, InputElement>();
	private Map<String, InputElement> woningPanelEls = new HashMap<String, InputElement>();
	private JPanel notifyPanel, makelaarPanel, woningPanel;
	
	private JLabel makelaarNotifyLabel, woNotifyLabel;
	
	public MainScreen() {		
		mainLayout();
		panels();
		
		addMakelaarTextFields();
		addMakelaarButtons();
		addItemsToPanel(makelaarPanelEls, makelaarPanel);
		
		addWoningTextFields();
		addWoningButtons();
		addWoningComboBoxes();
		addWoningMiscItems();
		addItemsToPanel(woningPanelEls, woningPanel);
		
		notifyLabels();
		
		JTabbedPane mainTabs = new JTabbedPane();
		mainTabs.addTab("Makelaars & Kantoren", makelaarPanel);
		mainTabs.addTab("Woningen", woningPanel);
		getContentPane().add(mainTabs);
		
		mainTabs.updateUI();		
	}
	
	
	private void mainLayout() {
		setSize(Settings.dims[0], Settings.dims[1]);
		setBackground(Settings.backgroundColor);
		setTitle(Settings.mainTitle);
		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		notifyPanel=new JPanel();
		makelaarPanel=new JPanel();
		woningPanel=new JPanel();
	}
	
	private void panels() {
		makelaarPanel.setLayout(null);
		woningPanel.setLayout(null);
		notifyPanel.setLayout(null);
	}
	
	private void addMakelaarTextFields() {
		makelaarPanelEls.put ("mkmdwid", new InputField("Zoeken op 'MKMDWID'", new int[]{180, 10, 200, 22}));
		makelaarPanelEls.put ("naam", new InputField("Makelaarnaam", new int[]{180, 70, 200, 22}));
		
		makelaarPanelEls.put ("gebruikersnaam", new InputField("Gebruikersnaam", new int[]{180, 95, 200, 22}));
		makelaarPanelEls.put ("wachtwoord", new InputField("Wachtwoord", new int[]{180, 120, 200, 22}));
		
		makelaarPanelEls.put ("koppel", new InputField("Koppel aan kantoor", new int[]{180, 145, 200, 22}));

		makelaarPanelEls.put("kantoornaam", new InputField("Kantoornaam", new int[]{180, 170, 200, 22}));
		makelaarPanelEls.put("adres", new InputField("Adres", new int[]{180, 195, 200, 22}));
		makelaarPanelEls.put("postode", new InputField("Postcode", new int[]{180, 220, 200, 22}));
		makelaarPanelEls.put("plaats", new InputField("Plaats", new int[]{180, 245, 200, 22}));
		makelaarPanelEls.put("telnr", new InputField("Telefoonnummer", new int[]{180, 270, 200, 22}));
	}
	
	private void addMakelaarButtons() {
		makelaarPanelEls.put("zoekbutton", new InputButton("Zoeken", new int[]{385, 10, 100, 22}));
		makelaarPanelEls.put("verwijderbutton", new InputButton("Verwijder medewerker", new int[]{385, 70, 180, 22}));
		makelaarPanelEls.put("opslaanbutton", new InputButton("Medewerker opslaan", new int[]{385, 95, 180, 22}));
		
		makelaarPanelEls.put("koppelbutton", new InputButton("Koppelen", new int[]{280, 145, 99, 22}));
		makelaarPanelEls.put("zoekbutton", new InputButton("Verwijder kantoor", new int[]{385, 145, 180, 22}));
		makelaarPanelEls.put("opslaanbutton", new InputButton("Kantoorgegevens opslaan", new int[]{385, 170, 180, 22}));
	}	
	
	private void addWoningTextFields() {
		woningPanelEls.put("zoeken", new InputField("Zoeken", new int[]{430, 10, 100, 22}, 80));
		woningPanelEls.put("koppelmkid", new InputField("Koppel MakelaarID", new int[]{150, 70, 250, 22}, 140));
		woningPanelEls.put("adres", new InputField("Adres", new int[]{150, 95, 250, 22}, 140));				
		woningPanelEls.put("postcode", new InputField("Postcode", new int[]{150, 120, 250, 22}, 140));
		woningPanelEls.put("plaats", new InputField("Plaats", new int[]{150, 145, 250, 22}, 140));	
		woningPanelEls.put("prijs", new InputField("Vraagprijs", new int[]{150, 170, 250, 22}, 140));
		woningPanelEls.put("oppervlakte", new InputField("Woonoppervlakte", new int[]{150, 495, 120, 22}, 140));
		woningPanelEls.put("inhoud", new InputField("Inhoud", new int[]{400, 495, 120, 22}, 100));
		woningPanelEls.put("kamers", new InputField("Aantal kamers", new int[]{150, 520, 120, 22}, 140));
		woningPanelEls.put("badkamers", new InputField("Badkamers", new int[]{400, 520, 120, 22}, 100));
		woningPanelEls.put("woonlagen", new InputField("Aantal woonlagen", new int[]{150, 545, 120, 22}, 140));
		woningPanelEls.put("plaatsingsdatum", new InputField("Plaatsingsdatum", new int[]{150, 570, 200, 22}, 140));
		woningPanelEls.put("bouwjaar", new InputField("Bouwjaar", new int[]{150, 245, 120, 22}, 140));
	}	
	
	private void addWoningButtons() {		
		woningPanelEls.put("koppelbutton", new InputButton("Koppelen", new int[]{430, 70, 100, 22}));	
		woningPanelEls.put("opslaan", new InputButton("Opslaan", new int[]{100, 595, 120, 22}));	
		woningPanelEls.put("verwijderen", new InputButton("Verwijderen", new int[]{350, 595, 120, 22}));			
	}
	
	private void addWoningComboBoxes() {		
		woningPanelEls.put("soortobject", new InputCombo("Soort Object", new int[]{150, 195, 120, 22}, 140));
		woningPanelEls.put("soort", new InputCombo("Soort woning", new int[]{400, 195, 180, 22}, 100));
		woningPanelEls.put("type", new InputCombo("Type woning", new int[]{150, 220, 120, 22}, 140));
		woningPanelEls.put("soortbouw", new InputCombo("Soort bouw", new int[]{400, 220, 180, 22}, 100));
		woningPanelEls.put("status", new InputCombo("Status", new int[]{400, 245, 180, 22},100 ));
		woningPanelEls.put("ligging1", new InputCombo("Ligging", new int[]{150, 415, 100,22}, 140));
		woningPanelEls.put("ligging2", new InputCombo("", new int[]{250, 415, 100,22}));
		woningPanelEls.put("ligging3", new InputCombo("", new int[]{350, 415, 100,22}));
		woningPanelEls.put("ligging4", new InputCombo("", new int[]{450, 415, 100,22}));
		woningPanelEls.put("ligging5", new InputCombo("", new int[]{150, 440, 100,22}));
		woningPanelEls.put("ligging6", new InputCombo("", new int[]{250, 440, 100,22}));
		woningPanelEls.put("ligging7", new InputCombo("", new int[]{350, 440, 100,22}));
		woningPanelEls.put("ligging8", new InputCombo("", new int[]{450, 440, 100,22}));		
	}
	
	private void addWoningMiscItems() {
		woningPanelEls.put("omschrijving", new InputTextField("Omschrijving", new int[]{150, 300, 400, 100}, 140));
		woningPanelEls.put("tuinaanwezig", new InputCheckbox("Tuin Aanwezig", new int[]{10, 470, 150,22}));
	}
	
	private void addItemsToPanel(Map<String, InputElement> items, JPanel panel) {	
		Iterator<InputElement> itr = items.values().iterator();
		while (itr.hasNext()) {
			InputElement el = itr.next();
			List<Component> comps = el.getElements();
			for (Component c: comps){ 			
				panel.add(c);
			}			
		}
	}
		
	private void notifyLabels() {
		makelaarNotifyLabel = new JLabel();
		makelaarNotifyLabel.setForeground(Settings.notifyColor);
		makelaarNotifyLabel.setBounds(10, 40, 400, 22);	
		
		woNotifyLabel		= new JLabel();
		woNotifyLabel.setForeground(Settings.notifyColor);
		woNotifyLabel.setBounds(10, 40, 400, 22);
		
		makelaarPanel.add(makelaarNotifyLabel);
		woningPanel.add(woNotifyLabel);
	}
}
