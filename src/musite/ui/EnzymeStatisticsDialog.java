/**
 * Musite
 * Copyright (C) 2010 Digital Biology Laboratory, University Of Missouri
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package musite.ui;

import java.io.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import musite.MusiteInit;
import musite.Proteins;
import musite.ProteinsUtil;
import musite.PTM;

import musite.io.Reader;
import musite.io.fasta.ModifiedProteinsFastaReaderBuilder;
import musite.io.xml.ProteinsXMLReader;

import musite.ui.task.AbstractTask;
import musite.ui.task.ReadTask;
import musite.ui.task.TaskUtil;

import musite.util.FileExtensionsFilter;
import musite.util.FilePathParser;

/**
 *
 * @author Jianjiong Gao
 */
public class EnzymeStatisticsDialog extends javax.swing.JDialog {

    /** Creates new form MusiteTrainDialog */
    public EnzymeStatisticsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        trainFileButtonActionPerformed(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        javax.swing.JPanel trainPanel = new javax.swing.JPanel();
        javax.swing.JPanel trainFilePanel = new javax.swing.JPanel();
        trainFileTextField = new javax.swing.JTextField();
        javax.swing.JButton trainFileButton = new javax.swing.JButton();
        javax.swing.JPanel inputfileoptionPanel = new javax.swing.JPanel();
        javax.swing.JPanel ptmPanel = new javax.swing.JPanel();
        ptmComboBox = new javax.swing.JComboBox();
        javax.swing.JPanel viewPanel = new javax.swing.JPanel();
        javax.swing.JScrollPane viewScrollPane = new javax.swing.JScrollPane();
        javax.swing.JPanel OKPanel = new javax.swing.JPanel();
        javax.swing.JButton closelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File Statistics");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        trainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Musite XML file"));
        trainPanel.setMinimumSize(new java.awt.Dimension(400, 63));
        trainPanel.setPreferredSize(new java.awt.Dimension(500, 63));
        trainPanel.setLayout(new java.awt.GridBagLayout());

        trainFilePanel.setLayout(new java.awt.GridBagLayout());

        trainFileTextField.setToolTipText("Please select a FASTA training file");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        trainFilePanel.add(trainFileTextField, gridBagConstraints);

        trainFileButton.setText("Open");
        trainFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainFileButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        trainFilePanel.add(trainFileButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        trainPanel.add(trainFilePanel, gridBagConstraints);

        inputfileoptionPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        trainPanel.add(inputfileoptionPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(trainPanel, gridBagConstraints);

        ptmPanel.setVisible(false); //TODO: remove this for PTM
        ptmPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("PTM type"));
        ptmPanel.setLayout(new java.awt.GridBagLayout());

        ptmComboBox.setModel(new javax.swing.DefaultComboBoxModel(PTM.values()));
        ptmComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptmComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        ptmPanel.add(ptmComboBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(ptmPanel, gridBagConstraints);

        viewPanel.setLayout(new java.awt.GridBagLayout());

        viewScrollPane.setViewportView(viewTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        viewPanel.add(viewScrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(viewPanel, gridBagConstraints);

        closelBtn.setText("Close");
        closelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closelBtnActionPerformed(evt);
            }
        });
        OKPanel.add(closelBtn);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(OKPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trainFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainFileButtonActionPerformed
        JFileChooser fc = new JFileChooser(MusiteInit.defaultPath);
        
        ArrayList<String> exts = new ArrayList<String>(1);
        String xml = "xml";
        exts.add(xml);
        fc.addChoosableFileFilter(new FileExtensionsFilter(exts,"XML file (.xml)"));

        fc.setDialogTitle("Select a file...");
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            MusiteInit.defaultPath = file.getParent();

            String filePath = MusiteInit.defaultPath + File.separator + file.getName();
            trainFileTextField.setText(filePath);
            
            String ext = FilePathParser.getExt(filePath);

            Reader<Proteins> reader = ProteinsXMLReader.createReader();

            ReadTask<Proteins> task = new ReadTask(reader, filePath);
            TaskUtil.execute(task);
            if (!task.success()) {
                JOptionPane.showMessageDialog(this, "Failed to read the file");
                return;
            }

            Proteins proteins = task.getResultObject();

            viewTable.setProteins(proteins);
        }
    }//GEN-LAST:event_trainFileButtonActionPerformed

    private void closelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closelBtnActionPerformed
        setVisible(false);
        this.dispose();
}//GEN-LAST:event_closelBtnActionPerformed

    private void ptmComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptmComboBoxActionPerformed
        viewTable.reset();
    }//GEN-LAST:event_ptmComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ptmComboBox;
    private javax.swing.JTextField trainFileTextField;
    // End of variables declaration//GEN-END:variables
    
    private ViewPhosphoTable viewTable = new ViewPhosphoTable();

    class ViewPhosphoTable extends JTable {

        private final String headerParam = "Protein/Residue";
        private final String headerValue = "Count";

        private Proteins proteins;

        public ViewPhosphoTable() {
            //this.setEnabled(false);
            proteins = null;
        }

        public void setProteins(Proteins proteins) {
            this.proteins = proteins;
            reset();
        }

        public void reset() {
            if (proteins==null) {
                setModel(new DefaultTableModel());
                return;
            }

            final PTM ptm = (PTM)ptmComboBox.getSelectedItem();
            final Vector<Vector> data = new Vector();

            AbstractTask task = new AbstractTask("Counting") {
                public void run() {
                    try {
                            taskMonitor.setPercentCompleted(-1);
                            taskMonitor.setStatus("Counting...");

                            Map<String,Integer> mapEnzymeCount = ProteinsUtil.countSitesByEnzymes(proteins, ptm);
                            for (Map.Entry<String,Integer> entry : mapEnzymeCount.entrySet()) {
                                String enzyme = entry.getKey();
                                Integer count = entry.getValue();
                                Vector vec = new Vector(2);
                                vec.add(enzyme==null?"":enzyme);
                                vec.add(count);
                                data.add(vec);
                            }

                            Collections.sort(data, new Comparator<Vector>() {
                                public int compare(Vector vec1, Vector vec2) {
                                    String enzyme1 = (String)vec1.get(0);
                                    String enzyme2 = (String)vec2.get(0);
                                    return enzyme1.compareTo(enzyme2);
                                }
                            });

                            taskMonitor.setPercentCompleted(100);
                            taskMonitor.setStatus("Done.");

                            success = true;
                    } catch (Exception e) {
                            taskMonitor.setPercentCompleted(100);
                            taskMonitor.setStatus("Failed.\n"+e.getMessage());
                            e.printStackTrace();
                            return;
                    }
                }
            };

            TaskUtil.execute(task);

            Vector<String> header = new Vector(2);
            header.add(headerParam);
            header.add(headerValue);
            setModel(new DefaultTableModel(data, header));
        }
    }
}
