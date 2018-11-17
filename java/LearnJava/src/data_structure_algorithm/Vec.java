import java.awt.desktop.SystemSleepEvent;
import java.util.*;
import java.io.*;


public class Vec {
    public static void main(String[] args){
            trial t = new trial();
            try{
                    FileOutputStream fout = new FileOutputStream("/home/zhuokun/Desktop/trial.ser");
                    ObjectOutputStream oout = new ObjectOutputStream(fout);
                    oout.writeObject(t);
                    oout.close();
                    fout.close();
                    System.out.println("Serialisation completed");
            }
            catch (IOException i){
                    i.printStackTrace();
            }

    }

}

interface prototype{
        void print();
        void print2();
}

class trial implements prototype,java.io.Serializable{
        private String love1,love2,love3;
        private String loc1,loc2,loc3;
        private transient String love4 = "IDK";
        /*
        * It marks a member variable not to be serialized when
        * it is persisted to streams of bytes. When an object is
        * transferred through the network, the object needs to be
        * 'serialized'. Serialization converts the object state to
        * serial bytes. Those bytes are sent over the network and
        * the object is recreated from those bytes. Member variables marked by
        * the java transient keyword are not transferred, they are lost intentionally.
         * */

        trial(){
                this.love1 = "Brandy";
                this.love2 = "Zishen";
                this.love3 = "Vivian";
                this.loc1 = "Australia";
                this.loc2 = "United Kingdom";
                this.loc3 = "Canada";

        }

        @Override
        public void print() {
                System.out.println("Brandy");
        }

        @Override
        public void print2() {
                System.out.println("Zishen");
        }
        public void print3(){
                System.out.println("Vivian");
        }
}