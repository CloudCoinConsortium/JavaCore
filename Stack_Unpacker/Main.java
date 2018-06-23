package Stack_Unpacker;


/**
 * Waits for 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args){

        //Watch folder
        //if change call Create Unpacker.
        if(false){
        FileUtils fileUtils = new FileUtils( "rootFolder", "importFolder", "importedFolder", "trashFolder", "receivedFolder");
        Unpacker myUnpacker = new Unpacker( fileUtils);
        myUnpacker.importAll();
        }
    }//end main

        //call the Unpacker's import all method. 
    
    
    }//end class
