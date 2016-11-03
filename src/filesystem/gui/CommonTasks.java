package filesystem.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import filesystem.core.*;

public class CommonTasks
    extends JPanel
    implements ActionListener
{
  private JPanel taskPanel = new JPanel();
  private JPanel graphPanel = new JPanel();
  private JLabel lblFileFolderTaks = new JLabel();
  private JLabel lblDetails = new JLabel();
  private JButton btnCreateFolder = new JButton();
  private JLabel nameLabel = new JLabel();
  private JLabel nameLabel2 = new JLabel();
  private JLabel nameLabel3 = new JLabel();
  private JLabel nameLabel4 = new JLabel();
  private JLabel nameLabel5 = new JLabel();
  private JButton btnDelete = new JButton();
  private JButton btnCopy = new JButton();
  private FSGUI parent;
  private JButton btnRename = new JButton();
  private JLabel nameLabel6 = new JLabel();

  public CommonTasks()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    btnCopy.addActionListener(this);
    btnCreateFolder.addActionListener(this);
    btnDelete.addActionListener(this);
    btnRename.addActionListener(this);
  }

  public void setParentUI(FSGUI parent)
  {
    this.parent = parent;
  }

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource().equals(btnCreateFolder))
    {
      if(parent.isValidLocation())
      {
        String name = JOptionPane.showInputDialog(parent,"Enter Directory Name");
        if(name!=null && name.length() != 0)
        {
          parent.createFolder(name);
        }
      }
      else
      {
        JOptionPane.showMessageDialog(parent, "Please select valid object");
      }
    }
    if(e.getSource().equals(btnDelete))
    {
      parent.deleteNode();
    }
    if(e.getSource().equals(btnRename))
    {
      parent.doRename();
    }
  }

  public void displayDetails(ButtonIcon button)
  {
    clearDescription();
    if(button.getButtonName().equals("mycomputer"))
    {
      nameLabel.setText("My Computer");
      nameLabel2.setText("System Folder");
    }
    else
    {
      if(button.getNode() != null)
      {
        Node n = button.getNode();
        nameLabel.setText(n.getNodeName());
        if(n.getNodeType() == Kernel.ROOT)
        {
          nameLabel2.setText("Local Disk");
          nameLabel3.setText("FileSystem: BK");
          double size = n.getFreeSpace();
          size = (size / 1024) / 1024;
          nameLabel4.setText("Free Space: " +
                             new Double(size).toString().substring(0, 4) +
                             " MB");
          /*if( (freespace/1024/1024) >0)
           nameLabel4.setText("Free Space: " + (n.getFreeSpace()/1024/1024)+" MB");
                 if( (freespace/1024/1024) ==0)
            nameLabel4.setText("Free Space: " + (n.getFreeSpace()/1024)+" KB");
                 else if( (freespace/1024/1024/1024) == 0)
           nameLabel4.setText("Free Space: " + (n.getFreeSpace()/1024)+" KB");*/

          nameLabel5.setText("Total Size:   " +
                             (n.getSizeOnDisk() / 1024 / 1024) +
                             " MB");
        }
        else if(n.getNodeType() == Kernel.DIRECTORY)
        {
          nameLabel2.setText("File Folder");
        }
        else if(n.getNodeType() == Kernel.FILE)
        {
          nameLabel2.setText("File");
          nameLabel3.setText("Size: " + (n.getSizeOnDisk()/1024)+" KB");
          nameLabel4.setText("Last Modified: " + new java.util.Date(n.getLastModified()));
          nameLabel5.setText("Read Only: " + (n.isReadOnly()==true ? "Yes" : "No"));
          nameLabel6.setText("Hidden: " + (n.isHidden()==true? "Yes" : "No"));
        }
      }
    }
  }

  public void clearDescription()
  {
    nameLabel.setText("");
    nameLabel5.setText("");
    nameLabel2.setText("");
    nameLabel3.setText("");
    nameLabel4.setText("");
    nameLabel6.setText("");
  }

  private void jbInit() throws Exception
  {
    this.setLayout(null);
    this.setSize(193, 470);
    taskPanel.setBorder(null);
    taskPanel.setOpaque(false);
    taskPanel.setBounds(new Rectangle(0, 0, 192, 262));
    taskPanel.setLayout(null);
    graphPanel.setBorder(null);
    graphPanel.setOpaque(false);
    graphPanel.setBounds(new Rectangle(1, 262, 192, 220));
    graphPanel.setLayout(null);
    lblFileFolderTaks.setBackground(SystemColor.inactiveCaption);
    lblFileFolderTaks.setFont(new java.awt.Font("Verdana", 1, 11));
    lblFileFolderTaks.setForeground(Color.blue);
    lblFileFolderTaks.setOpaque(true);
    lblFileFolderTaks.setText(" File and Folder Tasks");
    lblFileFolderTaks.setBounds(new Rectangle(0, 0, 194, 27));
    lblDetails.setBounds(new Rectangle( -2, 2, 194, 27));
    lblDetails.setText(" Details");
    lblDetails.setOpaque(true);
    lblDetails.setRequestFocusEnabled(true);
    lblDetails.setForeground(Color.blue);
    lblDetails.setFont(new java.awt.Font("Verdana", 1, 11));
    lblDetails.setBackground(SystemColor.inactiveCaption);
    btnCreateFolder.setFont(new java.awt.Font("Verdana", 0, 11));
    btnCreateFolder.setForeground(SystemColor.activeCaption);
    btnCreateFolder.setBorderPainted(false);
    btnCreateFolder.setContentAreaFilled(false);
    btnCreateFolder.setFocusPainted(false);
    btnCreateFolder.setHorizontalAlignment(SwingConstants.LEFT);
    btnCreateFolder.setHorizontalTextPosition(SwingConstants.LEFT);
    btnCreateFolder.setText("Create a new Folder");
    btnCreateFolder.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    btnCreateFolder.setBounds(new Rectangle( 0, 89, 194, 23));
    btnCreateFolder.setCursor(new Cursor(Cursor.HAND_CURSOR));
    nameLabel.setFont(new java.awt.Font("Verdana", 1, 11));
    nameLabel.setToolTipText("");
    nameLabel.setBounds(new Rectangle(7, 37, 180, 23));
    nameLabel2.setBounds(new Rectangle(6, 62, 180, 23));
    nameLabel2.setToolTipText("");
    nameLabel2.setFont(new java.awt.Font("Verdana", 0, 11));
    nameLabel3.setFont(new java.awt.Font("Verdana", 0, 11));
    nameLabel3.setToolTipText("");
    nameLabel3.setBounds(new Rectangle(6, 89, 180, 23));
    nameLabel4.setBounds(new Rectangle(6, 115, 180, 23));
    nameLabel4.setToolTipText("");
    nameLabel4.setFont(new java.awt.Font("Verdana", 0, 11));
    nameLabel5.setFont(new java.awt.Font("Verdana", 0, 11));
    nameLabel5.setToolTipText("");
    nameLabel5.setBounds(new Rectangle(6, 140, 180, 23));
    btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnDelete.setBounds(new Rectangle(0, 61, 193, 23));
    btnDelete.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    btnDelete.setText("Delete File / Folder");
    btnDelete.setHorizontalTextPosition(SwingConstants.LEFT);
    btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
    btnDelete.setFocusPainted(false);
    btnDelete.setContentAreaFilled(false);
    btnDelete.setBorderPainted(false);
    btnDelete.setForeground(SystemColor.activeCaption);
    btnDelete.setFont(new java.awt.Font("Verdana", 0, 11));
    btnCopy.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnCopy.setBounds(new Rectangle( 0, 31, 195, 23));
    btnCopy.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    btnCopy.setText("Copy File / Folder");
    btnCopy.setHorizontalTextPosition(SwingConstants.LEFT);
    btnCopy.setHorizontalAlignment(SwingConstants.LEFT);
    btnCopy.setFocusPainted(false);
    btnCopy.setContentAreaFilled(false);
    btnCopy.setBorderPainted(false);
    btnCopy.setForeground(SystemColor.activeCaption);
    btnCopy.setFont(new java.awt.Font("Verdana", 0, 11));
    btnRename.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnRename.setBounds(new Rectangle(0, 118, 195, 23));
    btnRename.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    btnRename.setText("Rename Object");
    btnRename.setHorizontalTextPosition(SwingConstants.LEFT);
    btnRename.setHorizontalAlignment(SwingConstants.LEFT);
    btnRename.setFocusPainted(false);
    btnRename.setContentAreaFilled(false);
    btnRename.setBorderPainted(false);
    btnRename.setForeground(SystemColor.activeCaption);
    btnRename.setFont(new java.awt.Font("Verdana", 0, 11));
    nameLabel6.setBounds(new Rectangle(5, 171, 180, 23));
    nameLabel6.setToolTipText("");
    nameLabel6.setFont(new java.awt.Font("Verdana", 0, 11));
    this.add(taskPanel, null);
    taskPanel.add(lblFileFolderTaks, null);
    taskPanel.add(btnDelete, null);
    taskPanel.add(btnCopy, null);
    taskPanel.add(btnCreateFolder, null);
    taskPanel.add(btnRename, null);
    this.add(graphPanel, null);
    graphPanel.add(lblDetails, null);
    graphPanel.add(nameLabel, null);
    graphPanel.add(nameLabel2, null);
    graphPanel.add(nameLabel3, null);
    graphPanel.add(nameLabel4, null);
    graphPanel.add(nameLabel5, null);
    graphPanel.add(nameLabel6, null);
  }

}
