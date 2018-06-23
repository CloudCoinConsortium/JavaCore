package Stack_Unpacker;


import java.io.*;
import java.util.*;

/**
 * Help to read, write and change files.
 *
 * ImportStacks_FileUtils has the following differences from FileUtils:
 * Uses ImportStacks_CloudCoin instead of CloudCoin.
 * Uses the following methods from FileUtils:
 * - ImportStacks_CloudCoinFromFile()
 * - deleteCoin()
 * - importJSON()
 * - loadJSON();
 * - moveToImportedFolder()
 * - moveToTrashFolder()
 * - parseJpeg()
 * - selectFileNamesInFolders()
 * - setJSON()
 * - toHexidecimal
 * - toStringArray()
 * - writeTo()
 * - writeToSuspectFolder()
 *
 * @author Sean H. Worthington
 * @version 1/17/2017
 */
class FileUtils
{
    // instance variables
    public  String rootFolder;
    public  String importFolder;
    public  String importedFolder;
    public  String trashFolder;
    public  String receivedFolder;

    /**
     * Constructor for objects of class FileUtils
     */
    public FileUtils(String rootFolder, String importFolder, String importedFolder, String trashFolder, String receivedFolder)
    {
        // initialise instance variables
        this.rootFolder = rootFolder ;
        this.importFolder = importFolder;
        this.importedFolder = importedFolder;
        this.trashFolder = trashFolder;
        this.receivedFolder = receivedFolder;
    }//End constructor

    
    public void moveToTrashFolder(String fileName){
        String source = importFolder + fileName;
        String target = trashFolder + fileName;
        new File(source).renameTo(new File(target));
    }
    
    public boolean writeStackToReceivedFolder(String fileName, String json){
        try{
            boolean goodSave = false;
             File file = new File( receivedFolder + fileName +".stack" );
             if(file.exists() && !file.isDirectory()) {
                //System.out.println("A coin with that SN already exists in the folder.");
               return goodSave;
            }
            FileOutputStream is = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(is);    
                Writer w = new BufferedWriter(osw);
                w.write(json);
                w.close();
            return true;
        }catch(IOException e){
         return false; 
        
        }
    }//end write to received folder
    
      public void moveToImportedFolder(String fileName){
        String source = importFolder + fileName;
        String target = trashFolder + fileName;
        new File(source).renameTo(new File(target));
    }
   
    
    private String loadJSON( String jsonfile) throws FileNotFoundException {
        String jsonData = "";
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader( jsonfile ));
            while ((line = br.readLine()) != null) {
                jsonData += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return jsonData;
    }//end json test

    
        public String[] selectFileNamesInFolder(String directoryPath) {
        File dir = new File(directoryPath);
        String candidateFileExt = "";
        Collection<String> files  =new ArrayList<String>();
        if(dir.isDirectory()){
            File[] listFiles = dir.listFiles();

            for(File file : listFiles){
                if(file.isFile()) {//Only add files with the matching file extension
                    files.add(file.getName());
                }
            }
        }
        return files.toArray(new String[]{});
    }//End select all file names in a folder
}