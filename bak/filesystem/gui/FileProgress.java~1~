package filesystem.gui;

import javax.swing.*;
import java.awt.*;

public class FileProgress extends JDialog
{
  private JLabel heading = new JLabel();
  private JProgressBar progressBar = new JProgressBar();


  public FileProgress()
  {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(windowSize.width/3,windowSize.height/3,203,95);
    this.setVisible(true);
  }
  public void setHeading(String h)
  {
    heading.setText(h);
  }
  public void setMinMax(int min, int max)
  {
    progressBar.setMinimum(min);
    progressBar.setMaximum(max);
  }
  public void setProgressValue(int v)
  {

    progressBar.setValue(v);
    double percent = progressBar.getPercentComplete()*100;
    int p = (int) percent;
    progressBar.setString(String.valueOf(p)+"%");
  }
  private void jbInit() throws Exception
  {
    heading.setBounds(new Rectangle(2, 4, 193, 22));
    this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    this.getContentPane().setLayout(null);
    progressBar.setBounds(new Rectangle(2, 31, 189, 24));
    this.getContentPane().add(heading, null);
    this.getContentPane().add(progressBar, null);
    progressBar.setStringPainted(true);
  }
}
