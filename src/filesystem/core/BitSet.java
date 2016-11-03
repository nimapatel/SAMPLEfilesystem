package filesystem.core;

/*
  For now I am using this class for setting file attributes. later I will
  use this to store all the filesystem information in storage device.
 */
public class BitSet
{
  private byte b; //use single byte now. later it can be an array of byte

  public BitSet(){}
  public BitSet(byte b)
  {
    this.b= b;
  }

  /*
   * Set a specified bit to 1 (true).
   */
  public void setBit(int whichBit)
  {
    b |= (byte) (1 << (whichBit % 8));
  }

  /*
   * Set a specifed bit to a specified boolean value.
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

  /*
   * Checks to see if the specified bit of the block is set (1) or
   * reset (0).
   */
  public boolean isBitSet(int whichBit)
  {
    return(b & (byte) (1 << (whichBit % 8))) != 0;
  }

  /*
   * Sets the specified bit of the block to 0 (false).
   */
  public void resetBit(int whichBit)
  {
    b &= ~ (byte) (1 << (whichBit % 8));
  }
  public void setByte(byte b)
  {
    this.b=b;
  }
  public byte getByte()
  {
    return b;
  }
}
