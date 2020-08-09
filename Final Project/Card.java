
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    private int number;
    private String carrier;
    
    public Card()
    {
        //dont use this.
        this.number=0;
        this.carrier="ERROR 0xE0FFFFF";
    }
    public Card(int numIn, String carIn)
    {
        this.number=numIn;
        this.carrier=carIn;
    }
    
    public int getNumber()
    {
        return this.number;
    }
    public void setNumber(int in)
    {
        this.number=in;
    }
    
    public String getCarrier()
    {
        return this.carrier;
    }
    public void setCarrier(String in)
    {
        this.carrier=in;
    }
}

