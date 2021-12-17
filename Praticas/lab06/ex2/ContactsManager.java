import java.util.*;
import java.io.*;

class ContactsManager implements ContactsInterface{
    public List<Contact> list;

    public ContactsManager(){
        this.list = new ArrayList<>();
    }

    public List<Contact> getList(){
        return this.list;
    }

    public boolean clearList(){
        try{
            this.list.removeAll(this.list);
            System.out.println("Contact list cleared!");
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public void openAndLoad(ContactsStorageInterface store){
        this.list.addAll(store.loadContacts());
        
        System.out.println("Contact list added successfully!");
    }

    public void saveAndClose(){
        if(list.size() < 1){
            System.out.println("Contact list must be loaded first!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        String path;

        System.out.println("Insert list to be loaded: ");
        path = sc.nextLine();


        try{
            File file = new File(path);
            ContactsStorageInterface storage = new ContactsStorageManager(file);
            boolean flag = storage.saveContacts(this.list);

            if(flag){
                System.out.println("Saved and closed successfully!");
            } else {
                System.out.println("Error! Could not save contacts.");
            }

        } catch(Exception e){
            System.out.println("Error! " + e.toString());
        }
        sc.close();
    }

    public void saveAndClose(ContactsStorageInterface store){
        if(list.size() < 1){
            System.out.println("Contact list must be loaded first!");
            return;
        }

        boolean flag = store.saveContacts(this.list);

        if(flag){
            System.out.println("Saved and closed successfully!");
        } else {
            System.out.println("Error! Could not save contacts.");
        }
    }

    public boolean exist(Contact contact){
        for(Contact c : this.list){
            if(c.toString().equals(list.toString())){
                System.out.println("Contact exists!");
                return true;
            }
        }
        System.out.println("Contact does NOT exist!");
        return false;
    }

    public Contact getByName(String name){
        for(Contact c : this.list){
            if(c.getName().equals(name)){
                return c;
            }
        }
        System.out.println("Contact does NOT exist!");
        return null;
    }

    public boolean add(Contact contact){
        if(this.exist(contact)){
            System.out.println("Contact already exists!");
            return false;
        } else {
            list.add(contact);
            System.out.println("Contact added successfully!");
            return true;
        }
    }

    public boolean remove(Contact contact){
        if(contact != null && this.exist(contact)) {
            list.remove(contact);
            System.out.println("Contact removed successfully!");
            return true;
        } else {
            System.out.println("Contact could NOT be removed!");
            return false;
        }
    }
}