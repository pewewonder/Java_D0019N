/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d007njavaprojuppg.view;

import d007njavaprojuppg.control.ArbetsuppgiftMngr;
import d007njavaprojuppg.control.ArendeMngr;
import d007njavaprojuppg.model.ArbetsuppgiftEntity;
import d007njavaprojuppg.model.ArendeEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author P
 */
public class HandleCaseUI extends javax.swing.JFrame {
    DefaultListModel pagaendeArendeList = new DefaultListModel();
    DefaultListModel arbUppgList = new DefaultListModel();
    

    public HandleCaseUI() {
        initComponents();
        initArendeList();
        btnAvslutaarende.setEnabled(false);
        
    }
    private void initArendeList() {
        listArende.setModel(pagaendeArendeList);
        //Töm lista
        pagaendeArendeList.clear();
        //deklarera lista med studenter
        List <ArendeEntity> arendeList = new ArrayList<>();
        try {
            //Skapa controller objekt Entitymngr som innehåller JPA metoder för datahantering
            ArendeMngr amgr = new ArendeMngr();
            arendeList = amgr.getArendeInDb(); //returnerar lista med StudentEntity objekt
            //töm listan i formuläret innan inläsning av nya
            pagaendeArendeList.clear();
            //Lägg till i jListan med ärenden
            for (ArendeEntity ae : arendeList){
                pagaendeArendeList.addElement(ae.toString()); 
            }
        //Fånga eventuella run-time fel
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        }
    }
    private String newRef(){
        int sistaNR = 0;
        List <ArendeEntity> arendeList = new ArrayList<>();
        try {
            //Skapa controller objekt Arendemngr som innehåller JPA metoder för datahantering
            ArendeMngr emgr = new ArendeMngr();
            arendeList = emgr.getArendeInDb();
            //returnerar lista med ärenden
            //hämtar det senaste referensnummret samt adderar med 1 för att få nytt värde
            for (ArendeEntity ae : arendeList){
                sistaNR = (ae.getReferensnummer())+1;
            }
            
        //Fånga eventuella run-time fel
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        }
        //Omvandlar till string
        return sistaNR+"";
    }
    private int newArbUppgNr(){

        int sistaNR = 0;
        List <ArbetsuppgiftEntity> arendeList = new ArrayList<>();
        try {
            //Skapa controller objekt Entitymngr som innehåller JPA metoder för datahantering
            ArbetsuppgiftMngr emgr = new ArbetsuppgiftMngr();
            arendeList = emgr.getArbetsuppgiftInDb();
            //returnerar lista med StudentEntity objekt
            //Lägg till i listan med studenter i formuläret
            for (ArbetsuppgiftEntity aue : arendeList){
                sistaNR = (aue.getArbetsuppgiftnr())+1;
            }
            
        //Fånga eventuella run-time fel
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        }
        return sistaNR;
    }
    private void skapaArende() {
        //Skapar nytt ärendeentityobjekt, hämtar värden från de inmatade alternativen
        ArendeEntity arende = new ArendeEntity();
        arende.setReferensnummer(Integer.parseInt(labelRefNr.getText()));
        arende.setArbetsstatus("Påbörjad         ");
        arende.setArendetyp(combArendeTyp.getSelectedItem().toString());
        arende.setBudgettimmar((Integer)spinnerBudgetTotArende.getValue());
        arende.setKlardatum(txtKlarDatum.getText());
        arende.setSkapaddatum(todaysDate());
        arende.setKommentar(txtKommentar.getText());
        try{
            //Anropa metod i StudentMngr (control-klassen) för att lägga till student
            ArendeMngr emgr = new ArendeMngr();
            if (emgr.addArendeToDb(arende).equals("success")){
                JOptionPane.showMessageDialog(this, "Ärendet lades till i databasen");
            }else{
                JOptionPane.showMessageDialog(this, "Kunde inte lägga till Ärende!");
            }
        //Fånga eventuella run-time fel: vanligast i detta fall är försök att lägga till poster
        //med samma PK    
        } catch (RollbackException ex) {
            JOptionPane.showMessageDialog(this, "Databasfel!\r "
                    + "Exekvering mot db avbröts eftersom det skulle ha orsakat en dubblettnyckel i tabellen Ärende ");   
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        
        }
        clearInputs();
    }
     private void clearInputs() {
     labelRefNr.setText(newRef());
     txtKommentar.setText("Ingen kommentar");
     txtKlarDatum.setText(todaysDate());
     spinnerBudgetTotArende.setValue(220);
     }
    
     private String todaysDate(){
        Calendar currentDate = Calendar.getInstance(); //Hämta nuvarande datum
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy"); //formatera om
        return formatter.format(currentDate.getTime()).toUpperCase();
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listArende = new javax.swing.JList();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        arendeActionText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKommentar = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        btnSkapaArande = new javax.swing.JButton();
        labelRefNr = new javax.swing.JLabel();
        labelArendeStatus = new javax.swing.JLabel();
        combArendeTyp = new javax.swing.JComboBox();
        spinnerBudgetTotArende = new javax.swing.JSpinner();
        txtKlarDatum = new javax.swing.JTextField();
        btnUpdArende = new javax.swing.JButton();
        btnAvslutaarende = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jPanel10 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listArbUppg = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnLaggTillArbUppg = new javax.swing.JButton();
        btnTaBortArbUppg = new javax.swing.JButton();
        combArbUppg = new javax.swing.JComboBox();
        combAnsvPersonal = new javax.swing.JComboBox();
        spinnerKostnadPerTimma = new javax.swing.JSpinner();
        spinnerBudgetTidUtforande = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Ärenden");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        listArende.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listArende.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listArendeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(listArende);

        jLabel20.setText("ReferensNr");

        jLabel21.setText("Klardatum");

        jLabel22.setText("Status");

        jLabel23.setText("Kommentar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(25, 25, 25)
                .addComponent(jLabel22)
                .addGap(55, 55, 55)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        arendeActionText.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        arendeActionText.setText("Skapa nytt ärende: ");

        jLabel4.setText("Ärendestatus:");

        jLabel5.setText("Ärendetyp:");

        jLabel6.setText("Budget(Timmar):");

        jLabel7.setText("Klardatum:");

        txtKommentar.setColumns(20);
        txtKommentar.setLineWrap(true);
        txtKommentar.setRows(5);
        jScrollPane2.setViewportView(txtKommentar);

        jLabel8.setText("Kommentar:");

        btnSkapaArande.setText("Skapa ärende");
        btnSkapaArande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaArandeActionPerformed(evt);
            }
        });

        labelRefNr.setText(newRef());

        labelArendeStatus.setText("Påbörjad");

        combArendeTyp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nätverk      ", "Applikation", "Säkerhet     ", "Användare " }));

        spinnerBudgetTotArende.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(220), null, null, Integer.valueOf(1)));

        txtKlarDatum.setText(todaysDate());

        btnUpdArende.setText("Uppdatera Ärende");
        btnUpdArende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdArendeActionPerformed(evt);
            }
        });

        btnAvslutaarende.setText("Avsluta ärende");
        btnAvslutaarende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvslutaarendeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(arendeActionText)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelArendeStatus)
                            .addComponent(combArendeTyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRefNr))
                        .addGap(303, 303, 303))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerBudgetTotArende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKlarDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdArende)
                                    .addComponent(btnSkapaArande, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAvslutaarende, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(72, 72, 72))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arendeActionText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRefNr)
                    .addComponent(btnAvslutaarende))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelArendeStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combArendeTyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerBudgetTotArende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtKlarDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnUpdArende)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSkapaArande))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pågående Ärenden", jPanel3);

        jList5.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jList5);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jLabel24.setText("Referensnummer");

        jLabel25.setText("Klardatum");

        jLabel26.setText("Status");

        jLabel27.setText("Kommentar");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addContainerGap(579, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 76, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(603, 603, 603))))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Avslutade Ärende", jPanel9);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        listArbUppg.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Välj ett ärende i rutan ovan för att få upp lista över arbetsuppgifter" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listArbUppg);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("Arbetsuppgifter");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setText("Arbetsuppgift:");

        jLabel12.setText("Ansvarig personal:");

        jLabel13.setText("Kostnad per timma:");

        jLabel14.setText("Budgetterad tid för utförande:");

        btnLaggTillArbUppg.setText("Lägg till arbuppgift");
        btnLaggTillArbUppg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillArbUppgActionPerformed(evt);
            }
        });

        btnTaBortArbUppg.setText("Ta bort arbuppgift");
        btnTaBortArbUppg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortArbUppgActionPerformed(evt);
            }
        });

        combArbUppg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Installation", "Systemtest", "Support     ", "Felsök      " }));

        combAnsvPersonal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Per Vennström", "Lasse Granqvist", "Tomas Brolin" }));

        spinnerKostnadPerTimma.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(240), null, null, Integer.valueOf(1)));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel10.setText("Hantera arbetsuppgifter");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spinnerKostnadPerTimma)
                    .addComponent(spinnerBudgetTidUtforande))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLaggTillArbUppg)
                    .addComponent(btnTaBortArbUppg, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combAnsvPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combArbUppg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(combArbUppg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combAnsvPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerKostnadPerTimma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(spinnerBudgetTidUtforande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnLaggTillArbUppg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaBortArbUppg)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setText("Kostnad/h");

        jLabel16.setText("Arbetsuppgift");

        jLabel17.setText("Tidsåtgång");

        jLabel18.setText("Status");

        jLabel19.setText("Ansvarig");

        jLabel9.setText("Nr");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16)
                    .addComponent(jLabel9))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(91, 91, 91))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdArendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdArendeActionPerformed

        btnAvslutaarende.setEnabled(true);
        try {
            //Skapa controller objekt Entitymngr som innehåller JPA metoder för datahantering
            ArendeMngr arm = new ArendeMngr();
            Integer refNr = new Integer(listArende.getSelectedIndex())+1;
            ArendeEntity ar = arm.getArendeInDb(refNr);
            //töm listan i formuläret innan inläsning av nya

            /*for (ArendeEntity au : arendeList){
                arbUppgList.addElement(au.toString());
            }
            */
            labelRefNr.setText(ar.getReferensnummer().toString());
            arendeActionText.setText("Uppdatera Ärende:");
            combArendeTyp.setName(ar.getArendetyp());
            txtKommentar.setText(ar.getKommentar());
            txtKlarDatum.setText(ar.getKlardatum());
            spinnerBudgetTotArende.setValue(ar.getBudgettimmar());
            btnSkapaArande.setEnabled(false);
            
            
        //Fånga eventuella run-time fel
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        
                   }
    
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdArendeActionPerformed

    private void btnLaggTillArbUppgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillArbUppgActionPerformed
        ArbetsuppgiftEntity aue = new ArbetsuppgiftEntity();
        aue.setAnsvarig(combAnsvPersonal.getSelectedItem().toString());
        aue.setArbetsuppgift(combArbUppg.getSelectedItem().toString());
        aue.setKostnadpertimma((Integer)spinnerKostnadPerTimma.getValue());
        aue.setBudgetteradtimmar((double)(Integer)spinnerBudgetTidUtforande.getValue());
        aue.setArbetsuppgiftnr(newArbUppgNr());
        aue.setAntaltimmar(0);
        aue.setArbetsstatus("Påbörjad");
        aue.setReferensnummer(listArende.getSelectedIndex()+1);      
        
        try {    
          //Anropa metod i StudentMngr (control-klassen) för att lägga till student
            ArbetsuppgiftMngr amgr = new ArbetsuppgiftMngr();
            if (amgr.addArbUppgToDb(aue).equals("success")){
                JOptionPane.showMessageDialog(this, "Ny arbetsuppgift sparades i db!");
            }else{
                JOptionPane.showMessageDialog(this, "Kunde inte lägga till arbetsuppgift!");
            }
        //Fånga eventuella run-time fel: vanligast i detta fall är försök att lägga till poster
        //med samma PK    
       // } //catch (RollbackException ex) {
          //  JOptionPane.showMessageDialog(this, "Databasfel!\r "
          //          + "Exekvering mot db avbröts eftersom det skulle ha orsakat en dubblettnyckel i tabellen studenter ");   
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        }
        initArbUppgList();
                                                    
    }//GEN-LAST:event_btnLaggTillArbUppgActionPerformed
        private void initArbUppgList() {    
        listArbUppg.setModel(arbUppgList);
        //Töm lista
        arbUppgList.clear();
       List <ArbetsuppgiftEntity> arbuppgList = new ArrayList<>();
        try {
            //Skapa controller objekt Entitymngr som innehåller JPA metoder för datahantering
            ArbetsuppgiftMngr aue = new ArbetsuppgiftMngr();
            Integer refNr = new Integer(listArende.getSelectedIndex())+1;
            arbuppgList = aue.getArbetsuppgiftInDb(refNr);
            //töm listan i formuläret innan inläsning av nya
            arbUppgList.clear();
            for (ArbetsuppgiftEntity au : arbuppgList){
                arbUppgList.addElement(au.toString());
            }
            
        //Fånga eventuella run-time fel
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        
                   }
    
    }

    private void btnTaBortArbUppgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortArbUppgActionPerformed
        delArbUppg();
        
    }//GEN-LAST:event_btnTaBortArbUppgActionPerformed

    private void btnSkapaArandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaArandeActionPerformed
    skapaArende();   
    initArendeList();
    }//GEN-LAST:event_btnSkapaArandeActionPerformed

    private void listArendeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listArendeMouseClicked
        initArbUppgList();
    }//GEN-LAST:event_listArendeMouseClicked

    private void btnAvslutaarendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvslutaarendeActionPerformed
        try {
            //Skapa controller objekt Entitymngr som innehåller JPA metoder för datahantering
            ArendeMngr arm = new ArendeMngr();
            Integer refNr = new Integer(listArende.getSelectedIndex())+1;
            ArendeEntity ar = arm.getArendeInDb(refNr);
            uppdateraArendeStatus(ar);
            initArendeList();
        //Fånga eventuella run-time fel
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        
                   }
    }//GEN-LAST:event_btnAvslutaarendeActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HandleCaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HandleCaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HandleCaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HandleCaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HandleCaseUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arendeActionText;
    private javax.swing.JButton btnAvslutaarende;
    private javax.swing.JButton btnLaggTillArbUppg;
    private javax.swing.JButton btnSkapaArande;
    private javax.swing.JButton btnTaBortArbUppg;
    private javax.swing.JButton btnUpdArende;
    private javax.swing.JComboBox combAnsvPersonal;
    private javax.swing.JComboBox combArbUppg;
    private javax.swing.JComboBox combArendeTyp;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelArendeStatus;
    private javax.swing.JLabel labelRefNr;
    private javax.swing.JList listArbUppg;
    private javax.swing.JList listArende;
    private javax.swing.JSpinner spinnerBudgetTidUtforande;
    private javax.swing.JSpinner spinnerBudgetTotArende;
    private javax.swing.JSpinner spinnerKostnadPerTimma;
    private javax.swing.JTextField txtKlarDatum;
    private javax.swing.JTextArea txtKommentar;
    // End of variables declaration//GEN-END:variables

    private void delArbUppg() {
        //Hämtar det unika arbetsuppgiftnumret och omvandlar det till integer för att kunna hitta rätt i databasen
        String arbUppg = listArbUppg.getSelectedValue().toString();
        String arbNUppg = ""+ String.valueOf(arbUppg.charAt(0));
        int arbNr = Integer.parseInt(arbNUppg);
 
        try {    
            ArbetsuppgiftMngr emgr = new ArbetsuppgiftMngr();
            //Anropa metod i entityMngr för att ta bort arbetsuppgift från db
            if (emgr.delArbUppgFromDb(arbNr).equals("success")){
                JOptionPane.showMessageDialog(this, "Arbetsuppgift bortagen!");
            }else{
                JOptionPane.showMessageDialog(this, "Kunde inte ta bort student!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        }
        initArbUppgList();//Ladda listan med arbetsuppgifter från db
       
    
    }

    private void uppdateraArendeStatus(ArendeEntity arende) {
    try{
            //Anropa metod i StudentMngr (control-klassen) för att lägga till student
            ArendeMngr emgr = new ArendeMngr();
            if (emgr.updArendeStatus(arende).equals("success")){
                JOptionPane.showMessageDialog(this, "Ärendets status uppdaterades");
                //Ändrar ärendestatus till avslutad
                labelArendeStatus.setText("avslutad");
                //Öppnar nytt handleCaseUI fönster
                OppnaNyttFonster();
            }else{
                JOptionPane.showMessageDialog(this, "Kunde inte uppdatera ärendet");
            }
        //Fånga eventuella run-time fel: vanligast i detta fall är försök att lägga till poster
        //med samma PK    
        } catch (RollbackException ex) {
            JOptionPane.showMessageDialog(this, "Databasfel!\r "
                    + "Exekvering mot db avbröts eftersom det skulle ha orsakat en dubblettnyckel i tabellen Ärende ");   
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "FEL! " + ex.getMessage());
        
        }    
    }

    private void OppnaNyttFonster() {
        HandleCaseUI myFrame = new HandleCaseUI();
        myFrame.setTitle("Administrera jobb");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null); //centrerad
        myFrame.pack(); //anpassar JFrame dialogen till kontrollernas storlek
        myFrame.setVisible(true);
    }


   
}
