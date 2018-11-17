package fileio;

import javax.xml.crypto.Data;
import java.io.*;

public class dir_play {

    public static void main(String[] args){

        data_stream o1 = new data_stream();
        o1.write();
        o1.read();
    }

}


// file specific: File i-/o stream
class file_input_stream{
    public void run() {
        String pwd = System.getProperty("user.dir");
        String filename = "/src/fileio/text1.txt";
        try {

            //File f1 = new File(pwd + filename);
            // File object needed for another kind of construction method
            FileInputStream in = new FileInputStream(pwd+filename);
            // byte[] total = new byte[(int) f1.length()];
            byte[] total = new byte[(int)(new File(pwd+filename)).length()];
            in.read(total);
            for (byte i : total) {
                System.out.print((char) i);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class file_output_stream{
    public void run(){
        String i = "I hope to see someone who loves me.\nHowever she is not gonna be Brandy\n";
        String pwd = System.getProperty("User.dir");
        String file = "/src/fileio/filetextout.txt";
        File fout = new File(pwd+file);

        try{
            FileOutputStream out = new FileOutputStream(fout);
            DataOutputStream outdata = new DataOutputStream(out);
            // sort of a wrapper to articulate methods that are more convenient
            outdata.writeBytes(i);
            // write UTF is just gonna be a mess
            outdata.close();
            out.close();
        }catch (IOException e){e.printStackTrace();}

    }

    public void run_otherlanguages(){
        String i = "I hope to see someone who loves me.\nHowever she is not gonna be Brandy\n我就是我";
        String pwd = System.getProperty("user.dir");
        String file = "/src/fileio/filetextout.txt";
        File fout = new File(pwd+file);

        try{
            FileOutputStream out = new FileOutputStream(fout);
            // DataOutputStream outdata = new DataOutputStream(out);
            OutputStreamWriter writer = new OutputStreamWriter(out,"UTF-8");

            writer.append(i);
            writer.close();
            out.close();
        }catch (IOException e){e.printStackTrace();}
    }
}
// data type specific: Data io streams, wrapper of stream objects

class data_stream{
    static final String dataFile = "invoicedata.txt";

    static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    static final int[] units = { 12, 8, 13, 29, 50 };
    static final String[] descs = {
            "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain"
    };

    DataOutputStream out;
    DataInputStream in;
    private File fout = new File(System.getProperty("user.dir")+"/src/fileio/"+this.dataFile);
    public void write(){
        try {
            this.out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fout)));
            for (int i = 0; i < prices.length; i++) {
                this.out.writeDouble(prices[i]);
                this.out.writeInt(units[i]); //...
                this.out.writeUTF(descs[i]);
            }
            this.out.close();

        }catch (Exception e){e.printStackTrace();}

    }
    public void read(){

        double price;
        int unit;
        String desc;
        double total = 0.0;

        try {
            in = new DataInputStream(new
                    BufferedInputStream(new FileInputStream(fout)));
            while (true) {
                price = this.in.readDouble();
                unit = this.in.readInt();
                desc = this.in.readUTF();
                System.out.format("You ordered %d" + " units of %s at $%.2f%n",
                        unit, desc, price);
                total += unit * price;
            }
        } catch (EOFException e) {
            try {this.in.close();}catch (IOException ee){}
        }catch (FileNotFoundException e){}
        catch (IOException e){}
    }

}

// object specific
