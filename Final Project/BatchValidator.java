import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * Write a description of class BatchValidator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BatchValidator
{
    private HashMap carrierTable;
    private ArrayList<Card> valid;
    private ArrayList<String> invalid;
    private ArrayList<String> preValid;
    private ArrayList<String> workingArray;
    //private String outputString;
    
    public BatchValidator()
    {
        this.carrierTable=new HashMap();
        this.populateCarrierHashmap();
        
        this.valid=new ArrayList<Card>();
        this.invalid=new ArrayList<String>();
        this.preValid=new ArrayList<String>();
        
        this.workingArray=new ArrayList<String>();
        this.stringArrayFromFile("input.txt");
        
        this.initialCleanup(this.workingArray); //now preValid is ready.
        this.setCards();
        
        this.dataToFile();
        
        //this.outputString="";
    }
    
    public BatchValidator(String filenameIn)
    {
        this.carrierTable=new HashMap();
        this.populateCarrierHashmap();
        
        this.valid=new ArrayList<Card>();
        this.invalid=new ArrayList<String>();
        this.preValid=new ArrayList<String>();
        
        this.workingArray=new ArrayList<String>();
        this.stringArrayFromFile(filenameIn);
        
        this.initialCleanup(this.workingArray); //now preValid is ready.
        this.setCards();
        
        this.dataToFile();//makes output.txt
        
        //this.outputString="";
    }
    
    /**
        * @param String in
        * @return none
        * @throws IOException
        * Converts a file specified by filename to a String[].
    */
    public void stringArrayFromFile(String in)
    {
        try{
            Scanner s = new Scanner(new File(in));
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()){
                list.add(s.next());
            }
            s.close();
            //String[] res=new String[list.size()];
            for(int i=0;i<list.size();i++)
            {
                this.workingArray.add(list.get(i));
            }
        }catch(IOException e)
        {
            System.out.println("Error during file read.");
        }
    }
    
    /**
        * @param none
        * @return none
        * @throws IOException
        * Writes the pertinent data in the object to a new file, output.txt.
    */
    public void dataToFile()
    {
        StringBuilder vs=new StringBuilder();
        vs.append("VALID CC'S:"+"\n");
        vs.append("NUMBER     ----     CARRIER"+"\n");
        for(int i=0;i<this.valid.size();i++)
        {
            String newVal=Integer.toString(this.valid.get(i).getNumber());
            String newCarrier=this.valid.get(i).getCarrier();
            vs.append(newVal+"     ----     "+newCarrier+"\n");
        }
        vs.append("\n\n"+"INVALID:"+"\n");
        for(int i=0;i<this.invalid.size();i++)
        {
            String newVal=this.invalid.get(i);
            vs.append(newVal+"\n");
        }
        try
        {
            FileWriter writer=new FileWriter("output.txt");
            //what am I writing here again?  oh yesh, appending vs.
            writer.write(vs.toString()); //i think thats it.
            writer.close();//there we go.
        }catch(IOException e)
        {
            System.out.println("Error during file write.");
        }
    }

    /**
        * @param none
        * @return none
        * @throws none
        * From a list of valid numbers, creates a new card with the corresponding carrier.
    */
    public void setCards()
    {
        for(int i=0;i<this.preValid.size();i++)
        {
            for(int f=5;f>=0;f--)
            {
                Integer substring=(Integer)Integer.parseInt(this.preValid.get(i).substring(0,f));
                if(this.carrierTable.containsKey(substring)==true)
                {
                    String newCarrier=this.carrierTable.get(substring).toString();
                    int newNum=Integer.parseInt(this.preValid.get(i));
                    this.valid.add(new Card(newNum,newCarrier));
                }else
                {
                    this.invalid.add(preValid.get(i));
                }
            }
        }
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Populates the carrier Hashmap with IIN's and their corresponding carriers.
    */
    public void populateCarrierHashmap()
    {
        ArrayList<Integer> amex=new ArrayList<Integer>();
        Integer[] amexP={34,37};
        amex.addAll(Arrays.asList(amexP));
        String ccN="AMEX";
        //now is time to send to hashtable.
        for(int i=0;i<amexP.length;i++)
        {
            this.carrierTable.put(ccN,amex.get(i));
        }

        ArrayList<Integer> dinersCB=new ArrayList<Integer>();
        Integer[] dinersCBp={300,301,302,303,304,305};
        dinersCB.addAll(Arrays.asList(dinersCBp));
        ccN="DINERS-CB";
        for(int i=0;i<dinersCB.size();i++)
        {
            this.carrierTable.put(ccN,dinersCB.get(i));
        }

        ArrayList<Integer> dinersCI=new ArrayList<Integer>();
        dinersCI.add(36);
        this.carrierTable.put("DINERS-CI",dinersCI.get(0));

        ArrayList<Integer> dinersUSAC=new ArrayList<Integer>();
        dinersUSAC.add(54);
        this.carrierTable.put("DINERS-USAC",dinersUSAC.get(0));

        ArrayList<Integer> discover=new ArrayList<Integer>(); //this has that range
        //make the range!
        ArrayList<Integer> discRange=new ArrayList<Integer>();
        for(int i=622126;i<=622925;i++)
        {
            discRange.add(i);
        }
        discover.addAll(discRange);
        //now the regular numbers!
        Integer[] discP={6011,644,645,646,647,648,649,65};
        discover.addAll(Arrays.asList(discP));
        ccN="DISCOVER";
        for(int i=0;i<discover.size();i++)
        {
            this.carrierTable.put(ccN,discover.get(i));
        }

        ArrayList<Integer> instapayment=new ArrayList<Integer>();
        Integer[] inP={637,638,639};
        ccN="INTAPAYMENT";
        for(int i=0;i<instapayment.size();i++)
        {
            this.carrierTable.put(ccN,instapayment.get(i));
        }

        ArrayList<Integer> jcb=new ArrayList<Integer>(); //also has range
        for(int i=3528;i<=3589;i++)
        {
            jcb.add(i);
        }
        ccN="JCB";
        for(int i=0;i<jcb.size();i++)
        {
            this.carrierTable.put(ccN,jcb.get(i));
        }

        ArrayList<Integer> laser=new ArrayList<Integer>();
        Integer[] lasP={6304,6706,6771,6709};
        laser.addAll(Arrays.asList(lasP));
        ccN="LASER";
        for(int i=0;i<laser.size();i++)
        {
            this.carrierTable.put(ccN,laser.get(i));
        }

        ArrayList<Integer> maestro=new ArrayList<Integer>();
        Integer[] maeP={5018,5020,5038,5893,6304,6759,6761,6762,6763};
        maestro.addAll(Arrays.asList(maeP));
        ccN="MAESTRO";
        for(int i=0;i<maestro.size();i++)
        {
            this.carrierTable.put(ccN,maestro.get(i));
        }

        ArrayList<Integer> mc=new ArrayList<Integer>();
        for(int i = 51;i<=55;i++){mc.add(i);}
        ccN="MASTERCARD";
        for(int i=0;i<mc.size();i++){this.carrierTable.put(ccN,mc.get(i));}

        ArrayList<Integer> visa=new ArrayList<Integer>();
        visa.add(4);
        this.carrierTable.put("VISA",visa.get(0));

        ArrayList<Integer> visaElectron=new ArrayList<Integer>();
        Integer[] visP={4026,417500,4508,4844,4913,4917};
        ccN="VISA-ELECTRON";
        for(int i=0;i<visaElectron.size();i++)
        {
            this.carrierTable.put(ccN,visaElectron.get(i));
        }

        //Ta-da!
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Trims the initial data of invalid values.
    */
    public void initialCleanup(ArrayList<String> init)
    {
        ArrayList<String> phaseOne=new ArrayList<String>();
        int sl=init.size();
        boolean add=true;

        //Remove strings containing non-numerics. Add to invalid.
        for(int i=0;i<sl;i++)
        {
            int ml=init.get(i).length();
            for(int j=0;j<ml;j++)
            {
                if(Character.isDigit(init.get(i).charAt(j))==false)
                {
                    add=false;
                    break;
                }
            }
            if(add==true)
            {
                phaseOne.add(init.get(i));
            }else
            {
                this.invalid.add(init.get(i));
            }
        }

        //Remove too-shorts and too-longs.
        ArrayList<String> phaseTwo=new ArrayList<String>();
        sl=phaseOne.size();
        for(int i=0;i<sl;i++)
        {
            if(phaseOne.get(i).length()>=13&&phaseOne.get(i).length()<=19)
            {
                phaseTwo.add(phaseOne.get(i));
            }else
            {
                this.invalid.add(phaseOne.get(i));
            }
        }

        //Prepare to be passed back.  Oh hey, no need for that, cause type didn't change.
        this.preValid.addAll(phaseTwo);
    }
    
    /**
        * @param none
        * @return boolean isValid
        * @throws none
        * Validates true or false based on the Luhn algorithm.
    */
    public boolean luhnValidate(String in)
    {
        boolean res=false;
        int il=in.length();
        int[] zi=new int[il];

        for(int i=0;i<il;i++)
        {
            zi[i]=Character.getNumericValue(in.charAt(i));
        }

        int lastDigit=zi[il];
        il-=1; //iterator now ignoring last digit

        //reverse the remaining digits.
        int[] iz=new int[il];
        for(int i=0;i<il;i++)
        {
            iz[i]=zi[il-i];
        }
        
        //now operating on iz instead of zi.
        //multiply odd digits by two.
        for(int i=0;i<il;i++)
        {
            if(iz[i]%2==0)
            {
                //dont do it
            }else
            {
                //do it
                iz[i]*=2;
            }
        }
        
        //now add the digits in each tile.
        for(int i=0;i<il;i++)
        {
            if(iz[i]>10)
            {
                //break it up
                String s=Integer.toString(iz[i]);
                int sl=s.length();
                int m=0;//add digits to this
                for(int j=0;j<sl;j++)
                {
                    m+=Character.getNumericValue(s.charAt(j));
                }
                iz[i]=m;
            }
        }
        
        //add all digits.
        int sum=0;
        for(int i=0;i<il;i++)
        {
            sum+=iz[i];
        }
        
        //if that + lastDigit % 10==0, valid.
        if((sum+lastDigit)%10==0)
        {
            res=true;
        }else
        {
            res=false;
        }
        
        //return true/false.
        return res;
    }
}
