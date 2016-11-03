package filesystem.util;

import java.io.*;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.util.*;

public class ClipBoard
{
  public ClipBoard()
  {
  }

  public static File[] getClipboard()
  {
    Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().
                     getContents(null);
    try
    {
      if(t != null && t.isDataFlavorSupported(DataFlavor.javaFileListFlavor))
      {
        List list = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
        File files[] = new File[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
          files[i] = (File) list.get(i);
        }
        if(list.size() > 0)
          return files;
      }
    }
    catch(UnsupportedFlavorException e)
    {
      System.out.println("Clipboard: File Type does not support");
    }
    catch(IOException e)
    {
      System.out.println("ClipBoard: IO Exception "+e.getMessage());
    }
    return null;
  }
  public static boolean isClipboardEmpty()
  {
    if(getClipboard()==null)
      return true;
    return false;
  }
}
