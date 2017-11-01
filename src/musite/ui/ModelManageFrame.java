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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import musite.Musite;
import musite.MusiteInit;

import musite.prediction.PredictionModel;
import musite.prediction.PredictionModelImpl;
import musite.prediction.PredictionModelManager;

import musite.ui.task.ModelLoadingTask;
import musite.ui.task.ModelSavingTask;
import musite.ui.task.TaskUtil;
import musite.ui.util.checktree.CheckTreeManager;
import musite.ui.util.checktree.TreePathSelectable;

import musite.util.FileExtensionsFilter;
import musite.util.IOUtil;

/**
 *
 * @author Jianjiong Gao
 */
public class ModelManageFrame extends javax.swing.JFrame {

    /** Creates new form ModelManageFrame */
    public ModelManageFrame() {
        initComponents();
        viewModelTable = new ViewModelTable(null);
        viewFileText = new JTextArea();
        viewFileText.setEditable(false);
        viewFileText.setLineWrap(true);
        viewFileText.setWrapStyleWord(true);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
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

        javax.swing.JSplitPane modelManageSplitPane = new javax.swing.JSplitPane();
        javax.swing.JPanel modelManagePanel = new javax.swing.JPanel();
        javax.swing.JScrollPane modelManagerScrollPane = new javax.swing.JScrollPane();
        javax.swing.JPanel operationPanel = new javax.swing.JPanel();
        javax.swing.JButton removeButton = new javax.swing.JButton();
        javax.swing.JButton combineButton = new javax.swing.JButton();
        javax.swing.JPanel viewModelPanel = new javax.swing.JPanel();
        viewModelScrollPane = new javax.swing.JScrollPane();
        modelCommentPanel = new javax.swing.JPanel();
        javax.swing.JScrollPane modelCommentScrollPane = new javax.swing.JScrollPane();
        modelCommentTextArea = new javax.swing.JTextArea();
        javax.swing.JPanel saveCommentPanel = new javax.swing.JPanel();
        javax.swing.JButton saveCommentButton = new javax.swing.JButton();
        javax.swing.JPanel OKPanel = new javax.swing.JPanel();
        javax.swing.JButton closelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Model Management");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        modelManagePanel.setLayout(new java.awt.GridBagLayout());

        modelManagerScrollPane.setMinimumSize(new java.awt.Dimension(300, 500));
        modelManagerScrollPane.setPreferredSize(new java.awt.Dimension(300, 500));

        modelManageTree = new ModelManageTree();
        modelManagerScrollPane.setViewportView(modelManageTree);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        modelManagePanel.add(modelManagerScrollPane, gridBagConstraints);

        removeButton.setVisible(false);
        removeButton.setText("Remove selected models");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        operationPanel.add(removeButton);

        combineButton.setText("Combine the selected models");
        combineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combineButtonActionPerformed(evt);
            }
        });
        operationPanel.add(combineButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        modelManagePanel.add(operationPanel, gridBagConstraints);

        modelManageSplitPane.setLeftComponent(modelManagePanel);

        viewModelPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        viewModelPanel.setLayout(new java.awt.GridBagLayout());

        viewModelScrollPane.setMinimumSize(new java.awt.Dimension(400, 400));

        viewModelTable = new ViewModelTable(null);
        viewModelScrollPane.setViewportView(viewModelTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        viewModelPanel.add(viewModelScrollPane, gridBagConstraints);

        modelCommentPanel.setVisible(false);
        modelCommentPanel.setLayout(new java.awt.GridBagLayout());

        modelCommentScrollPane.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Comments"));

        modelCommentTextArea.setLineWrap(true);
        modelCommentTextArea.setRows(10);
        modelCommentTextArea.setWrapStyleWord(true);
        modelCommentScrollPane.setViewportView(modelCommentTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        modelCommentPanel.add(modelCommentScrollPane, gridBagConstraints);

        saveCommentButton.setText("Save comment");
        saveCommentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCommentButtonActionPerformed(evt);
            }
        });
        saveCommentPanel.add(saveCommentButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        modelCommentPanel.add(saveCommentPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        viewModelPanel.add(modelCommentPanel, gridBagConstraints);

        modelManageSplitPane.setRightComponent(viewModelPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(modelManageSplitPane, gridBagConstraints);

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

    private void closelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closelBtnActionPerformed
        setVisible(false);
        this.dispose();
}//GEN-LAST:event_closelBtnActionPerformed

    private void saveCommentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCommentButtonActionPerformed
        PredictionModel model = modelManageTree.getSelectedModel();
        if (model!=null) {
            model.setComment(modelCommentTextArea.getText());

            String file = model.getFile();

            ModelSavingTask task = new ModelSavingTask(null, file, "gz");

            TaskUtil.execute(task, this);

            if (task.success()) {
                JOptionPane.showMessageDialog(this,"saved");
            } else {
                JOptionPane.showMessageDialog(this,"failed");
            }
        }
    }//GEN-LAST:event_saveCommentButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        List<PredictionModel> models = modelManageTree.getCheckedModels();
        if (models==null || models.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one model.");
            return;
        }

        int op = JOptionPane.showConfirmDialog(this, "Are you sure to remove the selected model(s)?\n" +
                "Note: removing all models from a model file will make that model file removed permanently.",
                "remove?", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.NO_OPTION) {
            return;
        }

        PredictionModelManager manager = Musite.getModelManager();

        Set<String> files = new HashSet();
        int n = models.size();
        for (int i=n-1; i>=0; i--) {
            PredictionModel model = models.get(i);
            String file = model.getFile();
            try {
                manager.removeModelFromFile(file, model);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            files.add(file);
        }

        for (String file : files) {
            List<PredictionModel> ms;
            try {
                ms = manager.loadModels(file);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            if (ms.isEmpty()) {
                manager.removeModelFile(file);
                modelManageTree.removeFile(file);
                IOUtil.deleteFile(file);
            } else {
                ModelSavingTask task = new ModelSavingTask(null, file, "gz");
                TaskUtil.execute(task, this);

                if (!task.success()) {
                    JOptionPane.showMessageDialog(this,"failed to update "+file);
                }

                modelManageTree.addFile(file); // reflesh
            }
        }

        modelManageTree.repaint();

        JOptionPane.showMessageDialog(this,"Done.");
    }//GEN-LAST:event_removeButtonActionPerformed

    private void combineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combineButtonActionPerformed
        List<PredictionModel> models = modelManageTree.getCheckedModels();

        if (models==null || models.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one model.");
            return;
        }

        List<PredictionModel> modelsCopy = new ArrayList(models.size());
        for (PredictionModel model : models) {
            modelsCopy.add(new PredictionModelImpl(model));
        }

        JFileChooser fc = new JFileChooser(MusiteInit.MODEL_DIR);

        String ext = MusiteInit.MODEL_APPEDIX;
        ArrayList<String> exts = new ArrayList<String>(1);
        exts.add(ext);
        fc.setFileFilter(new FileExtensionsFilter(exts,"Model file (."+ext+")"));
        //fc.setAcceptAllFileFilterUsed(true);
        fc.setDialogTitle("Save to...");
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //MusiteInit.defaultPath = file.getParent();

            String filePath = file.getAbsolutePath();
            if (!filePath.endsWith("."+ext)) {
                filePath += "."+ext;
            }

            if (IOUtil.fileExist(filePath)) {
                int op = JOptionPane.showConfirmDialog(this,
                        "Are you sure to replace the existing model file?", "Replace?", JOptionPane.YES_NO_CANCEL_OPTION);
                if (op == JOptionPane.NO_OPTION) {
                    combineButtonActionPerformed(evt);
                    return;
                } else if (op == JOptionPane.CANCEL_OPTION) {
                    return;
                }
            }

            ModelSavingTask task = new ModelSavingTask(modelsCopy, filePath, "gz");

            TaskUtil.execute(task, this);

            if (task.success()) {
                try {
                    Musite.getModelManager().addModelFile(filePath, modelsCopy);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this,"Cannot find "+filePath);
                    return;
                }
                modelManageTree.addFile(filePath);
                modelManageTree.repaint();
                JOptionPane.showMessageDialog(this,"saved");
            } else {
                JOptionPane.showMessageDialog(this,"failed");
            }
        }
    }//GEN-LAST:event_combineButtonActionPerformed

    //private ClassificationModel model;
    private ModelManageTree modelManageTree;
    private ViewModelTable viewModelTable;
    private JTextArea viewFileText;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel modelCommentPanel;
    private javax.swing.JTextArea modelCommentTextArea;
    private javax.swing.JScrollPane viewModelScrollPane;
    // End of variables declaration//GEN-END:variables


    private class ViewModelTable extends JTable {
        private final String headerParam = "Parameter";
        private final String headerValue = "Value";

        public ViewModelTable(PredictionModel model) {
            this.setEnabled(false);
            setClassificationModel(model);
        }

        public void setClassificationModel(PredictionModel model) {
            if (model==null) {
                setModel(new DefaultTableModel());
                return;
            }

            Properties props = model.getModelProperties();

            Set<String> propNames = new TreeSet(props.keySet());

            Object[][] data = new Object[propNames.size()+3][];

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
            data[0] = new Object[]{"Trained on", dateFormat.format(model.getTimeStamp())};
            data[1] = new Object[]{"PTM type", model.getSupportedPTM().getDescription()};
            data[2] = new Object[]{"Type of Sites", model.getSupportedAminoAcid()};

            int i = 3;
            for (String p : propNames) {
                data[i++] = new Object[]{p, props.getProperty(p)};
            }

            setModel(new DefaultTableModel(data, new String[]{headerParam, headerValue}));
        }
    }

    private class ModelManageTree extends JTree {
        private DefaultMutableTreeNode rootNode;
        private final CheckTreeManager checkTreeManager;
        private DefaultTreeModel tree_Model;
        private boolean modified = false;
        private Map<String,DefaultMutableTreeNode> mapFileNode;

        public ModelManageTree() {
            boolean dig = false;
            checkTreeManager = new CheckTreeManager(this, dig,
                    new TreePathSelectable() {
                public boolean isSelectable(TreePath path) {
                    return path.getPathCount()==3;
                }
            });

            init();

            setRootVisible(false);

            getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            
//            this.setExpandsSelectedPaths(true);
        }

        public void init() {
            setupTree();
            setListeners();
        }

//        public void reload() {
//            tree_Model.reload();
//        }

        public boolean isModified() {
            return modified;
        }

        private void setupTree() {
            // set up tree
            rootNode = new DefaultMutableTreeNode("Musite Models");

            tree_Model = new DefaultTreeModel(rootNode);
            setModel(tree_Model);

            mapFileNode = new HashMap();

            PredictionModelManager manager = Musite.getModelManager();
            for (String file : manager.modelFiles()) {
                addFile(file);
            }

            expandPath(new TreePath(new DefaultMutableTreeNode[]{rootNode}));
        }

        public void addFile(String file) {
            DefaultMutableTreeNode fileNode = mapFileNode.get(file);
            if (fileNode==null) {
                fileNode = new DefaultMutableTreeNode(new ModelFileWrapper(file));
                insertAlphabetically(rootNode, fileNode);
                mapFileNode.put(file, fileNode);
            } else {
                // if the file exist, reflesh the node
                //musite.getModelManager().unloadModels(file);
                fileNode.removeAllChildren();
                //this.collapsePath(new TreePath(new DefaultMutableTreeNode[]{rootNode,fileNode}));
            }

            if (Musite.getModelManager().isModelFileLoaded(file)) {
                List<PredictionModel> models;
                try {
                    models = Musite.getModelManager().loadModels(file);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }

                for (PredictionModel model : models) {
                    DefaultMutableTreeNode modelNode = new DefaultMutableTreeNode(model);
                    insertAlphabetically(fileNode, modelNode);
                }
            } else {
                insertAlphabetically(fileNode, new DefaultMutableTreeNode("dummy"));
            }
        }

        public void removeFile(String file) {
            DefaultMutableTreeNode fileNode = mapFileNode.get(file);
            if (fileNode==null) {
                return;
            }

            fileNode.removeFromParent();
            mapFileNode.remove(file);

            this.tree_Model.reload();
        }

//        public void refleshFile(String file) {
//            musite.getModelManager().unloadModel(file);
//
//        }

        private void setListeners() {
            // popup listener
            addMouseListener( new MouseAdapter () {
                @Override
                public void mousePressed(MouseEvent e) {
                    popup(e);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    popup(e);
                }

                private boolean popup(MouseEvent e) {
                    if ( e.isPopupTrigger()) {
                        int row = ModelManageTree.this.getRowForLocation(e.getX(), e.getY());
                        if(row == -1)
                            return true;
                        ModelManageTree.this.setSelectionRow(row);
                        TreePath path = ModelManageTree.this.getPathForLocation(e.getX(), e.getY());

                        switch (path.getPathCount()) {
                            case 3:
                                JPopupMenu popupMenu = new ModelNodePopupMenu((DefaultMutableTreeNode)path.getLastPathComponent());
                                popupMenu.show((JComponent)e.getSource(), e.getX(), e.getY());
                                return true;
                            default:
                                return true;
                        }
                    } else {
                        return false;
                    }
                }
            });

            // expansion listener
            addTreeWillExpandListener(new TreeWillExpandListener() {
                public void treeWillCollapse(TreeExpansionEvent e) {

                }

                public void treeWillExpand(TreeExpansionEvent e) {
                    TreePath path = e.getPath();
                    if (path==null) {
                        //viewModelTable.setClassificationModel(null);
                    } else {
                        Object nodeObj = path.getLastPathComponent();
                        if (nodeObj instanceof DefaultMutableTreeNode) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode)nodeObj;

                            int level = node.getLevel();
                            if (level==1) {
                                ModelFileWrapper mdf = (ModelFileWrapper)node.getUserObject();
                                String file = mdf.file();
                                if (!Musite.getModelManager().isModelFileLoaded(file)) { // load models if not yet
                                    node.removeAllChildren();

                                    ModelLoadingTask task = new ModelLoadingTask(file);
                                    TaskUtil.execute(task, ModelManageFrame.this);
                                    if (!task.success()) {
                                        JOptionPane.showMessageDialog(ModelManageFrame.this, "Failed to load model: "+file);
                                    }

                                    List<PredictionModel> models = task.getModel();
                                    for (PredictionModel model : models) {
                                        DefaultMutableTreeNode modelNode = new DefaultMutableTreeNode(model);
                                        insertAlphabetically(node, modelNode);
                                    }
                                }
                            }
                        }
                    }
                }
            });

            addTreeSelectionListener(new TreeSelectionListener() {
                public void valueChanged(TreeSelectionEvent e) {
                    TreePath path = e.getPath();
                    if (path==null) {
                        //viewModelTable.setClassificationModel(null);
                    } else {
                        Object nodeObj = path.getLastPathComponent();
                        if (nodeObj instanceof DefaultMutableTreeNode) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode)nodeObj;

                            int level = node.getLevel();
                            if (level==1) {
                                Object obj = node.getUserObject();
                                if (!(obj instanceof ModelFileWrapper))
                                    return;
                                ModelFileWrapper mfw = (ModelFileWrapper)obj;
                                viewFileText.setText("Double click on the node to see the trained model(s) in the model file:\n"+mfw.file());
                                viewModelScrollPane.setViewportView(viewFileText);
                                modelCommentPanel.setVisible(false);
                            } else if (node.getLevel()==2) {
                                Object obj = node.getUserObject();
                                if (!(obj instanceof PredictionModel))
                                    return;
                                PredictionModel model = (PredictionModel)obj;
                                viewModelTable.setClassificationModel(model);
                                viewModelScrollPane.setViewportView(viewModelTable);
                                modelCommentPanel.setVisible(true);
                                modelCommentTextArea.setText(model.getComment());
                            } else {
                                viewModelScrollPane.setVisible(false);
                                modelCommentPanel.setVisible(false);
                            }
                        }
                    }
                }
            });
        }

        public PredictionModel getSelectedModel() {
            TreePath path = getSelectionPath();
            Object nodeObj = path.getLastPathComponent();
            if (nodeObj instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)nodeObj;
                if (node.getLevel()==2) {
                    return (PredictionModel)node.getUserObject();
                }
            }

            return null;
        }

        public List<PredictionModel> getCheckedModels() {
            TreePath[] paths = checkTreeManager.getSelectionModel().getSelectionPaths();
            List<PredictionModel> models = new ArrayList(paths.length);
            for (TreePath path : paths) {
                Object nodeObj = path.getLastPathComponent();
                if (nodeObj instanceof DefaultMutableTreeNode) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)nodeObj;
                    if (node.getLevel()==2) {
                        PredictionModel model = (PredictionModel)node.getUserObject();
                        models.add(model);
                    }
                }
            }

            return models;
        }

        private void removeModel(PredictionModel model) {
            if (model==null)
                return;

            int op = JOptionPane.showConfirmDialog(ModelManageFrame.this, "Are you sure to remove the this model?\n" +
                    "Note: removing all models from a model file will make that model file removed permanently.",
                    "remove?", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.NO_OPTION) {
                return;
            }

            PredictionModelManager manager = Musite.getModelManager();

            String file = model.getFile();
            try {
                manager.removeModelFromFile(file, model);
            } catch (Exception e) {
                e.printStackTrace();
            }

            List<PredictionModel> ms = null;
            try {
                ms = manager.loadModels(file);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (ms!=null && ms.isEmpty()) {
                manager.removeModelFile(file);
                this.removeFile(file);
                IOUtil.deleteFile(file);
            } else {
                ModelSavingTask task = new ModelSavingTask(null, file, "gz");
                TaskUtil.execute(task, ModelManageFrame.this);

                if (!task.success()) {
                    JOptionPane.showMessageDialog(ModelManageFrame.this,"failed to update "+file);
                }

                this.addFile(file); // reflesh
            }

            this.repaint();

            JOptionPane.showMessageDialog(this,"Done.");
        }

        private void renameModel(PredictionModel model) {
            if (model==null)
                return;

            String newName = JOptionPane.showInputDialog(ModelManageFrame.this, "New name", model.getName());

            if (newName == null)
                return;

            if (newName.length()==0) {
                JOptionPane.showMessageDialog(ModelManageFrame.this,"Model name cannot be empty.");
            }

            model.setName(newName);

            String file = model.getFile();

            ModelSavingTask task = new ModelSavingTask(null, file, "gz");
            TaskUtil.execute(task, ModelManageFrame.this);

            if (!task.success()) {
                JOptionPane.showMessageDialog(ModelManageFrame.this,"failed to update "+file);
            }

            this.repaint();
        }

        private void insertAlphabetically(DefaultMutableTreeNode parent,
                DefaultMutableTreeNode insertionNode) {
            String insertionValue = insertionNode.getUserObject().toString();
            int n = parent.getChildCount();
            int i=0;
            for (; i<n; i++) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) parent.getChildAt(i);
                if (child.getUserObject().toString().compareTo(insertionValue)>0) {
                    break;
                }
            }

            this.tree_Model.insertNodeInto(insertionNode, parent, i);
//            parent.insert(insertionNode, i);
        }

        private class ModelNodePopupMenu extends TreeNodePopupMenu {
            public ModelNodePopupMenu(final DefaultMutableTreeNode node) {
                super(node);
                setupMenus();
            }

            private void setupMenus() {
                JMenuItem mi = new JMenuItem("Rename");
                mi.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Object obj = getTreeNode().getUserObject();
                        if (obj instanceof PredictionModel) {
                            renameModel((PredictionModel)obj);
                        }
                    }
                });
                add(mi);

                mi = new JMenuItem("Delete");
                mi.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Object obj = getTreeNode().getUserObject();
                        if (obj instanceof PredictionModel) {
                            removeModel((PredictionModel)obj);
                            tree_Model.reload(getTreeNode());
                        }
                    }
                });
                add(mi);                
            }
        }

        private class TreeNodePopupMenu extends JPopupMenu {
            private DefaultMutableTreeNode node;

            public TreeNodePopupMenu(final DefaultMutableTreeNode node) {
                this.node = node;
            }

            public DefaultMutableTreeNode getTreeNode() {
                return node;
            }
        }

    }
}

