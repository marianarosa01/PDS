import java.util.*;
import java.io.*;

public class ContactsStorageBinary implements ContactsStorageInterface{
    private File binaryFile;

    public ContactsStorageBinary(File file){
        super();
        this.binaryFile = file;
    }

    @Override
    public List<Contact> loadContacts(){
        try {
            List<Contact> list = new ArrayList<>();
            FileReader fileReader = new FileReader(binaryFile);
            BufferedReader br = new BufferedReader(fileReader);
            String line;

            while((line = br.readLine()) != null){
                String currentLine[] = line.split(" - ");
                for(int i = 0; i < currentLine.length; i++){
                    Contact contact = new Contact(currentLine[i]);
                    list.add(contact);
                }
            }

            br.close();
            fileReader.close();
            return list;

        } catch (Exception e) {
            System.out.println("Error! " + e.toString());
        }

        return null;
    }

    @Override
    public boolean saveContacts(List<Contact> list){
        try {
            FileWriter fileWriter = new FileWriter(this.binaryFile);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            for(Contact c : list){
                bw.write(c.toString());
                bw.newLine();
            }

            bw.close();
            fileWriter.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}