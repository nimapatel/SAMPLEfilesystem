package filesystem.core;

import java.io.*;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.util.*;


public class Test
{
  byte b;
  public Test()
  {
  }

  /**
   * Set a specified bit to 1 (true).
   * @param whichBit the bit to set
   */
  public void setBit(int whichBit)
  {
    b |= (byte) (1 << (whichBit % 8));
  }

  /**
   * Set a specifed bit to a specified boolean value.
   * @param whichBit the bit to set
   * @param value the value to which the bit should be set
   */
  public void setBit(int whichBit, boolean value)
  {
    if(value)
    {
      setBit(whichBit);
    }
    else
    {
      resetBit(whichBit);
    }
  }

  /**
   * Checks to see if the specified bit of the block is set (1) or
   * reset (0).
   * @param whichBit the bit to check.
   * @return true if set; false if reset.
   */
  public boolean isBitSet(int whichBit)
  {
    return(b & (byte) (1 << (whichBit % 8))) != 0;
  }

  /**
   * Sets the specified bit of the block to 0 (false).
   * @param whichBit bit to set to 0 (false).
   */
  public void resetBit(int whichBit)
  {
    b &= ~ (byte) (1 << (whichBit % 8));
  }
  public static String getClipboard() {
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

        try {
            if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String text = (String)t.getTransferData(DataFlavor.stringFlavor);
                return text;
            }
            if (t != null && t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
              List files = (List)  t.getTransferData(DataFlavor.javaFileListFlavor);
              for(int i=0;i < files.size(); i++)
              {
                System.out.println(files.get(i).getClass());
              }
            }

        } catch (UnsupportedFlavorException e) {
        } catch (IOException e) {
        }
        return null;
    }

  public static void main(String[] args) throws Exception
  {
    System.out.println(Test.getClipboard());
    /*Test t =new Test();
         boolean b[] = {true,false,true,false,true,true,true,true};
         for(int i=0; i < b.length; i++)
      t.setBit(i,b[i]);

         for(int i=0; i <b.length; i++)
      System.out.println(i+" "+t.isBitSet(i));*/

    /*FileInputStream fin = new FileInputStream("c:\\out.txt");
        byte b;
        while ( (b=(byte)fin.read()) != -1)
        {
          System.out.print((char)b);
        }
        fin.close();*/

  }
}
