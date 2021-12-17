import java.util.List;
import java.io.*;

class ContactsStorageManager implements ContactsStorageInterface{
    public File file;
    public ContactsStorageManager(File file){
        try{
            this.file = file;
        } catch(Exception e) {
            System.out.println("Error! " + e.toString());
            System.exit(1);
        }
    }

    public void changeFile(String path){
        try {
            this.file = new File(path);
        } catch (Exception e) {
            System.out.println("Error! " + e.toString());
            System.exit(1);
        }
    }

    public String checkFileType(){
        String fileType = this.file.getName().split("\\.")[1];
        String format = "";

        if(fileType == "txt"){
            format = "Text";
        } 
        else if (fileType == "bin"){
            format = "Bin";
        }

        return format;
    }

    public List<Contact> loadContacts(){
        String format = checkFileType();

        try {
            if(format.equals("Text")){
                ContactsStorageInterface specificStorage = new ContactsTextStorage(this.file);
                return specificStorage.loadContacts();
            } 
            if(format.equals("Bin")){
                ContactsStorageInterface specificStorage = new ContactsStorageBinary(this.file);
                return specificStorage.loadContacts();
            }
        } catch (Exception e) {
            System.out.println("Error! " + e.toString());
            System.exit(1);
        }
        return null;
    }

    public boolean saveContacts(List<Contact> list){
        String format = checkFileType();

        try {
            if(format.equals("Text")){
                ContactsStorageInterface specificStorage = new ContactsTextStorage(this.file);
                return specificStorage.saveContacts(list);
            } 
            if(format.equals("Bin")){
                ContactsStorageInterface specificStorage = new ContactsStorageBinary(this.file);
                return specificStorage.saveContacts(list);
            }
        } catch (Exception e) {
            System.out.println("Error! " + e.toString());
            System.exit(1);
        }
        return true;
    }
}