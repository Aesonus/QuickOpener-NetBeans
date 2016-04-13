/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dsnet.quickopener.prefs;

import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.util.List;
import java.util.prefs.BackingStoreException;
import me.dsnet.quickopener.QuickMessages;
import me.dsnet.quickopener.actions.layer.ActionRegistrationService;
import me.dsnet.quickopener.actions.popup.PropertyTableModel;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;
import org.openide.util.Pair;

public final class QuickOpenerPanel extends javax.swing.JPanel {

    private final QuickOpenerOptionsPanelController controller;

    QuickOpenerPanel(QuickOpenerOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        jList1.setSelectedIndex(0);
        generalPanel1.setVisible(true);
        commandsPanel1.setVisible(false);
        generalPanel1.setController(controller);
        commandsPanel1.setController(controller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jRightPanel = new javax.swing.JPanel();
        commandsPanel1 = new me.dsnet.quickopener.prefs.CommandsPanel();
        generalPanel1 = new me.dsnet.quickopener.prefs.GeneralPanel();

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerSize(0);

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "General Options", "Commands", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });

        jLabel1.setLabelFor(jList1);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(QuickOpenerPanel.class, "QuickOpenerPanel.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jList1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jList1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jRightPanel.setLayout(new java.awt.CardLayout());
        jRightPanel.add(commandsPanel1, "commandsPanel1");
        jRightPanel.add(generalPanel1, "generalPanel1");

        jSplitPane1.setRightComponent(jRightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        LayoutManager layout = jRightPanel.getLayout();
        if (layout instanceof CardLayout) {
            CardLayout cardLayout = (CardLayout) layout;

            switch (jList1.getSelectedIndex()) {
                case 0:
                    cardLayout.show(jRightPanel, "generalPanel1");
                    break;
                default:
                    cardLayout.show(jRightPanel, "commandsPanel1");
                    break;
            }
        }
    }//GEN-LAST:event_jList1ValueChanged

    void load() {
        commandsPanel1.loadConfig();
        generalPanel1.loadConfig();
    }

    void store() {
        {
            ActionRegistrationService.unregisterActions("QuickOpener");
            PropertyTableModel tableModel = commandsPanel1.getTableModel();
            List<Pair<String, String>> backingData = tableModel.getBackingData();
            try {
                PrefsUtil.removeAll("command");
            } catch (BackingStoreException ex) {
                Exceptions.printStackTrace(ex);
            }
            for (int i = 0; i < backingData.size(); i++) {
                Pair<String, String> pair = backingData.get(i);

                String description = pair.first();
                String value = pair.second();

                PrefsUtil.store("command" + description, value);

                //TODO escape id
                String id = description;

                //TODO delete previous registrations to prevent duplicates: shortcuts/toolbar-items
//            ActionRegistrationService.unregisterAction(id, "QuickOpener");
                ActionRegistrationService.registerAction(id, "QuickOpener", description, value);

                String originalFile = String.format("%s/%s.instance", ActionRegistrationService.ACTIONS + "QuickOpener", id);
                ActionRegistrationService.registerActionAsMenu(id, originalFile, i);
            }
        }

        {
            PrefsUtil.store("generalseparator", generalPanel1.getTxtPathSeparator().getText());
            PrefsUtil.store("customShell", generalPanel1.getTxtCustomShell().getText());
            PrefsUtil.store("confirmationDialogue", (generalPanel1.getCbConfirmation().isSelected()) ? "true" : "false");
        }
    }

    boolean valid() {
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private me.dsnet.quickopener.prefs.CommandsPanel commandsPanel1;
    private me.dsnet.quickopener.prefs.GeneralPanel generalPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jRightPanel;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
