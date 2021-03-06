package jatekprogram;

import Model.Jatekos;
import Model.NPC;
import Model.Serializer;
import Model.Szereplo;
import Model.Targy;
import Model.TulSokTargyException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends javax.swing.JFrame {

    private List<Szereplo> szereplok;
    private Szereplo selectedSzereplo;
    
    public MainFrame() {
        
        initComponents();
        
        szereplok = new ArrayList<Szereplo>();
        
        jListSzereplok.setCellRenderer(new JatekosListCellRenderer());
        jListTargyLista.setCellRenderer(new TargyListCellRenderer());
        
        AddListenerToSzereploList();
        UpdateSzereploLista();
    }
    
    private void AddListenerToSzereploList()
    {
        ListSelectionListener listSelectionListener = (ListSelectionEvent listSelectionEvent) 
                -> 
        {
            JList list = (JList) listSelectionEvent.getSource();
            if(!listSelectionEvent.getValueIsAdjusting()){
                Object szereploTemp = list.getSelectedValue();
                if(szereploTemp != null && szereploTemp instanceof Szereplo)
                {
                    selectedSzereplo = (Szereplo)szereploTemp;
                    jTextFieldJatekosNev.setText(selectedSzereplo.getNev());
                    jTextFieldJatekosSebesseg.setText(Integer.toString(selectedSzereplo.getSebesseg()));
                    jCheckBoxIsJatekos.setSelected(selectedSzereplo instanceof Jatekos);   
                    UpdateTargyLista(selectedSzereplo);
                    UpdateSzereploLista();
                }
            }
        };
        jListSzereplok.addListSelectionListener(listSelectionListener);
    }
    
    private void AddUjJatekos(String nev, boolean isJatekos)
    {
        Szereplo szereplo;
        
        String filePath = nev + ".bin";
        szereplo = LoadSzereplo(filePath);
        
        if(szereplo == null)
        {
            if(isJatekos)
            {
                szereplo = new Jatekos();
            }
            else
            {
                szereplo = new NPC();
            }
            szereplo.setNev(nev);   
        }
        
        szereplok.add(szereplo);
        UpdateSzereploLista();        
    }
    
    private void UpdateSzereploLista()
    {
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < szereplok.size(); i++)
        {
            listModel.addElement(szereplok.get(i));
        }
        jListSzereplok.setModel(listModel);
    }
    
    private void UpdateTargyLista(Szereplo szereplo)
    {
        DefaultListModel listModel = new DefaultListModel();
        var lista = szereplo.getTargyLista();
        for (int i = 0; i < szereplo.getTargyLista().size(); i++)
        {
            listModel.addElement(lista.get(i));
        }
        jListTargyLista.setModel(listModel);
    }
    
    private void SaveSzereplo(Szereplo szereplo)
    {
        try
        {
            Serializer.SerializeToFile(szereplo, szereplo.getNev() + ".bin");
            JOptionPane.showMessageDialog(null, "Sikeres mentes!");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private Szereplo LoadSzereplo(Szereplo szereplo)
    {
        String filePath = szereplo.getNev() + ".bin";
        return LoadSzereplo(filePath);
    }
    
    private Szereplo LoadSzereplo(String filePath)
    {
        try
        {
            Szereplo sz = (Szereplo)Serializer.DeserializeFromFile(new File(filePath));
            JOptionPane.showMessageDialog(null, "Sikeres Automatikus bet??ltes!");
            return sz;
        }
        catch(Exception e){
            return null;
        }
    }
    
    private void TargyFelvesz(Szereplo szereplo)
    {
        Targy targy = new Targy();
            targy.setNev(jTextFieldUjTargyNev.getText());
            targy.setTomeg((int)jSpinnerUjTargyTomeg.getValue());
            try {
                szereplo.TargyFelvesz(targy);
                jTextFieldJatekosSebesseg.setText(Integer.toString(szereplo.getSebesseg()));
                UpdateTargyLista(szereplo);
            } catch (TulSokTargyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    
    private void RendezTargyakNevSzerint(Szereplo szereplo) {
        szereplo.RendezTargyListaNevSzerint();
        UpdateTargyLista(szereplo);
    }
    
    private void RendezTargyakTomegSzerint(Szereplo szereplo) {
        szereplo.RendezTargyListaTomegSzerint();
        UpdateTargyLista(szereplo);
    }
    
    private boolean IsExistsSelectedSzereplo()
    {
        return selectedSzereplo != null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldUjJatekosNev = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonAddUjJatekos = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jRadioButtonIsNPC = new javax.swing.JRadioButton();
        jRadioButtonIsJatekos = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSzereplok = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldJatekosNev = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldJatekosSebesseg = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListTargyLista = new javax.swing.JList<>();
        jButtonRendezNev = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonRendezToemg = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCheckBoxIsJatekos = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldUjTargyNev = new javax.swing.JTextField();
        jSpinnerUjTargyTomeg = new javax.swing.JSpinner();
        jButtonAddUjTargyToJatekos = new javax.swing.JButton();
        jButtonMentes = new javax.swing.JButton();
        jButtonBetoltes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("??j szerepl?? felv??tele"));

        jLabel3.setText("Szerepl?? neve");

        jButtonAddUjJatekos.setText("Felv??tel");
        jButtonAddUjJatekos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddUjJatekosActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonIsNPC);
        jRadioButtonIsNPC.setText("NPC");

        buttonGroup1.add(jRadioButtonIsJatekos);
        jRadioButtonIsJatekos.setSelected(true);
        jRadioButtonIsJatekos.setText("J??t??kos");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jRadioButtonIsJatekos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonIsNPC)
                .addGap(32, 32, 32))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonIsNPC)
                    .addComponent(jRadioButtonIsJatekos))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldUjJatekosNev, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButtonAddUjJatekos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldUjJatekosNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddUjJatekos)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("J??t??kosok"));

        jListSzereplok.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListSzereplok);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Kijel??lt szerepl?? adatai"));

        jLabel4.setText("N??v");

        jTextFieldJatekosNev.setEditable(false);

        jLabel5.setText("Sebess??g");

        jTextFieldJatekosSebesseg.setEditable(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("J??t??kos T??rgyai"));
        jPanel7.setToolTipText("");

        jListTargyLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(jListTargyLista);

        jButtonRendezNev.setText("N??v szerint");
        jButtonRendezNev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRendezNevActionPerformed(evt);
            }
        });

        jLabel1.setText("Rendez??s");

        jButtonRendezToemg.setText("T??meg szerint");
        jButtonRendezToemg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRendezToemgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButtonRendezNev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRendezToemg)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRendezNev)
                    .addComponent(jButtonRendezToemg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel6.setText("J??t??kos?");

        jCheckBoxIsJatekos.setEnabled(false);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("T??rgy felv??tele"));

        jLabel2.setText("N??v");

        jLabel7.setText("T??meg");

        jButtonAddUjTargyToJatekos.setText("Hozz??ad");
        jButtonAddUjTargyToJatekos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddUjTargyToJatekosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddUjTargyToJatekos, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUjTargyNev)
                            .addComponent(jSpinnerUjTargyTomeg))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldUjTargyNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinnerUjTargyTomeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddUjTargyToJatekos))
        );

        jButtonMentes.setText("J??t??kos ment??se");
        jButtonMentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMentesActionPerformed(evt);
            }
        });

        jButtonBetoltes.setText("J??t??kos mentett bet??lt??se");
        jButtonBetoltes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBetoltesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jCheckBoxIsJatekos)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldJatekosNev, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(jTextFieldJatekosSebesseg))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonBetoltes, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonMentes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldJatekosNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonMentes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCheckBoxIsJatekos))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldJatekosSebesseg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBetoltes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddUjJatekosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUjJatekosActionPerformed
        AddUjJatekos(jTextFieldUjJatekosNev.getText(), jRadioButtonIsJatekos.isSelected());
        jTextFieldUjJatekosNev.setText("");
    }//GEN-LAST:event_jButtonAddUjJatekosActionPerformed

    private void jButtonMentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMentesActionPerformed
        if(IsExistsSelectedSzereplo())
        {
            SaveSzereplo(selectedSzereplo);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nincs kijel??lve szerepl??!");
        }
    }//GEN-LAST:event_jButtonMentesActionPerformed

    private void jButtonBetoltesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBetoltesActionPerformed
        if(IsExistsSelectedSzereplo())
        {
            LoadSzereplo(selectedSzereplo);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nincs kijel??lve szerepl??!");
        }
    }//GEN-LAST:event_jButtonBetoltesActionPerformed

    private void jButtonAddUjTargyToJatekosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUjTargyToJatekosActionPerformed
        if(IsExistsSelectedSzereplo())
        {
            TargyFelvesz(selectedSzereplo);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nincs kijel??lve szerepl??!");
        }
    }//GEN-LAST:event_jButtonAddUjTargyToJatekosActionPerformed

    private void jButtonRendezNevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRendezNevActionPerformed
        if(IsExistsSelectedSzereplo())
        {
            RendezTargyakNevSzerint(selectedSzereplo);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nincs kijel??lve szerepl??!");
        }
    }//GEN-LAST:event_jButtonRendezNevActionPerformed

    private void jButtonRendezToemgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRendezToemgActionPerformed
        if(IsExistsSelectedSzereplo())
        {
            RendezTargyakTomegSzerint(selectedSzereplo);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nincs kijel??lve szerepl??!");
        }
    }//GEN-LAST:event_jButtonRendezToemgActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAddUjJatekos;
    private javax.swing.JButton jButtonAddUjTargyToJatekos;
    private javax.swing.JButton jButtonBetoltes;
    private javax.swing.JButton jButtonMentes;
    private javax.swing.JButton jButtonRendezNev;
    private javax.swing.JButton jButtonRendezToemg;
    private javax.swing.JCheckBox jCheckBoxIsJatekos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jListJatekosTargyai;
    private javax.swing.JList<String> jListJatekosTargyai1;
    private javax.swing.JList<String> jListJatekosTargyai2;
    private javax.swing.JList<String> jListSzereplok;
    private javax.swing.JList<String> jListTargyLista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButtonIsJatekos;
    private javax.swing.JRadioButton jRadioButtonIsNPC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinnerUjTargyTomeg;
    private javax.swing.JTextField jTextFieldJatekosNev;
    private javax.swing.JTextField jTextFieldJatekosSebesseg;
    private javax.swing.JTextField jTextFieldUjJatekosNev;
    private javax.swing.JTextField jTextFieldUjTargyNev;
    // End of variables declaration//GEN-END:variables

}
