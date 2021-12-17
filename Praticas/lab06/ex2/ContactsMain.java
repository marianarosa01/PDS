import java.io.*;

class ContactsMain {

    public static void main(String args[]){
        ContactsManager listContacts = new ContactsManager();

        // TEST TEXT FILE
        File file = new File("text.txt");
        ContactsStorageInterface storage = new ContactsStorageManager(file);
        //Open and load text file to a contact list
        listContacts.openAndLoad(storage);
        //Search contact by name
        listContacts.getByName("Ricardo");
        //Add new contact and check if its been added
        listContacts.add(new Contact("Bernardo Farias", 965741852));
        listContacts.getByName("Bernardo");
        //Remove from list and check if it got removed
        listContacts.remove(listContacts.getByName("João Rodriguez"));
        listContacts.exist(new Contact("Soraia Tavares, 914789521"));
    
        // TEST BINARY FILE
        //Open a binary file and save to contacts list
        file = new File("binary.bin");
        storage = new ContactsStorageManager(file);
        listContacts.saveAndClose(storage);
        for(Contact c: listContacts.getList()){
            c.toString();
        }
        //Clear list and check that it reset
        listContacts.clearList();
        listContacts.getList();
        //Open binary to check if it got saved
        listContacts.openAndLoad(storage);
        for(Contact c: listContacts.getList()){
            c.toString();
        }
    }
}