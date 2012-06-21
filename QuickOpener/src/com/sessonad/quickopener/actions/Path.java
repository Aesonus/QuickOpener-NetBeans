package com.sessonad.quickopener.actions;

import com.sessonad.quickopener.PathFinder;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.loaders.DataObject;
import org.openide.util.NbBundle.Messages;


/**
 *
 * @author SessonaD
 */
@Messages("CTL_Path=Copy path in the clipboard")
public final class Path implements ActionListener {

    private final DataObject dataObj;

    public Path(DataObject dataObj) {
        this.dataObj = dataObj;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String path=PathFinder.getPathFromDataObject(dataObj);
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            StringSelection strSel = new StringSelection(path);
            clipboard.setContents(strSel, null);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
