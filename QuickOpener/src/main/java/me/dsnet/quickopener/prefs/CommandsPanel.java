/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dsnet.quickopener.prefs;

import me.dsnet.quickopener.QuickMessages;
import me.dsnet.quickopener.actions.popup.PropertyTableModel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author SessonaD
 */
public class CommandsPanel extends javax.swing.JPanel {

    private QuickOpenerOptionsPanelController controller;

    /**
     * Creates new form CommandsPanel
     */
    public CommandsPanel() {
        super();
        initComponents();
        loadConfig();
        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(400);
        jTable2.getColumnModel().getColumn(0).setMinWidth(100);

        jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                final int row = jTable2.getSelectedRow();
                btnEdit.setEnabled(-1 != row);
                btnDelete.setEnabled(-1 != row);
            }
        });
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

    }

    public PropertyTableModel getTableModel() {
        return (PropertyTableModel) jTable2.getModel();
    }

    void loadConfig() {
        jTable2.setModel(new PropertyTableModel("command"));
        jTable2.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                controller.changed();
            }
        });
    }

    void setController(QuickOpenerOptionsPanelController controller) {
        this.controller = controller;
    }

    private void focusFirstEntry() {
        //select first command if available
        if (jTable2.getModel().getRowCount() >= 1) {
            jTable2.changeSelection(0, 0, false, false);
        }
        jTable2.requestFocusInWindow();
        jTable2.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(btnAdd, org.openide.util.NbBundle.getMessage(CommandsPanel.class, "CommandsPanel.btnAdd.text")); // NOI18N
        btnAdd.setToolTipText(org.openide.util.NbBundle.getMessage(CommandsPanel.class, "CommandsPanel.btnAdd.toolTipText")); // NOI18N
        btnAdd.setRequestFocusEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnDelete, org.openide.util.NbBundle.getMessage(CommandsPanel.class, "CommandsPanel.btnDelete.text")); // NOI18N
        btnDelete.setRequestFocusEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        org.openide.awt.Mnemonics.setLocalizedText(btnEdit, org.openide.util.NbBundle.getMessage(CommandsPanel.class, "CommandsPanel.btnEdit.text")); // NOI18N
        btnEdit.setRequestFocusEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(CommandsPanel.class, "CommandsPanel.jLabel2.text")); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setLabelFor(jTable2);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(CommandsPanel.class, "CommandsPanel.jLabel1.text")); // NOI18N
        jLabel1.setToolTipText(org.openide.util.NbBundle.getMessage(CommandsPanel.class, "CommandsPanel.jLabel1.toolTipText")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        final EditCommandPanel form = new EditCommandPanel();

        DialogDescriptor desc = new DialogDescriptor(form, "Add");
        Object result = DialogDisplayer.getDefault().notify(desc);
        if (result != NotifyDescriptor.OK_OPTION) {
            return;
        }

        String description = form.getCmddescription().getText();
        description = description.replaceAll(" ", "_");
        String value = form.getCmdvalue().getText();
        if (description.isEmpty()) {
            NotifyDescriptor d = new NotifyDescriptor.Message(QuickMessages.DESCRIPTION_MANDATORY, NotifyDescriptor.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(d);
            return;
        }
        PropertyTableModel model = (PropertyTableModel) jTable2.getModel();
        model.addItem(description, value);
        focusFirstEntry();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        PropertyTableModel model = (PropertyTableModel) jTable2.getModel();
        model.removeItem(jTable2.getSelectedRow());

        focusFirstEntry();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        final int row = jTable2.getSelectedRow();
        if (-1 == row) {
            return;
        }
        final EditCommandPanel form = new EditCommandPanel();

        {
            //setup with current values
            String description = (String) jTable2.getModel().getValueAt(row, 0);
            String command = (String) jTable2.getModel().getValueAt(row, 1);
            form.getCmddescription().setText(description);
            form.getCmdvalue().setText(command);
        }

        DialogDescriptor desc = new DialogDescriptor(form, "Edit");
        Object result = DialogDisplayer.getDefault().notify(desc);
        if (result != NotifyDescriptor.OK_OPTION) {
            return;
        }

        String description = form.getCmddescription().getText();
        description = description.replaceAll(" ", "_");
        String value = form.getCmdvalue().getText();
        if (description.isEmpty()) {
            NotifyDescriptor d = new NotifyDescriptor.Message(QuickMessages.DESCRIPTION_MANDATORY, NotifyDescriptor.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(d);
            return;
        }
        PropertyTableModel model = (PropertyTableModel) jTable2.getModel();
        model.addItem(description, value);
        focusFirstEntry();
    }//GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
