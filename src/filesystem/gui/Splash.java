package filesystem.gui;

import javax.swing.*;
import java.awt.*;

public class Splash extends JWindow implements Runnable
{
  private Thread t;
  public Splash()
  {
    ImageIcon icon=new ImageIcon("images/splash.jpg");
    int width=icon.getIconWidth();
    int height=icon.getIconHeight();
    Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
    int x=(screen.width-width)/2;
    int y=(screen.height-height)/2;
    JLayeredPane layer = new JLayeredPane();
    JLabel picture = new JLabel(icon);
    layer.add(picture, JLayeredPane.DEFAULT_LAYER);
    layer.setPreferredSize(picture.getPreferredSize());
    picture.setSize(picture.getPreferredSize());
    getContentPane().add("Center", layer);
    setBounds(x,y,width,height);
    Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
    this.setCursor(cursor);
    t = new Thread(this);
    t.start();
  }
  public void run()
  {
    setVisible(true);
    try
    {
      t.sleep(4000);
    }catch(Exception ex){}
    new filesystem.gui.FSGUI();
    setVisible(false);
    dispose();
  }
}
