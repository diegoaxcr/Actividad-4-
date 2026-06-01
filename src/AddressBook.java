
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {

    private HashMap<String, String> contacts;
    private final String fileName;

    public AddressBook(String fileName) {
        this.fileName = fileName;
        contacts = new HashMap<>();
    }

    // Cargar contactos desde archivo
    public void load() {
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("No existe archivo de contactos. Se creará uno nuevo.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 2) {
                    contacts.put(data[0], data[1]);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar contactos: " + e.getMessage());
        }
    }

    // Guardar contactos en archivo
    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar contactos: " + e.getMessage());
        }
    }

    // Mostrar contactos
    public void list() {
        System.out.println("\nContactos:");

        if (contacts.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Crear contacto
    public void create(String phone, String name) {
        contacts.put(phone, name);
        System.out.println("Contacto agregado correctamente.");
    }

    // Eliminar contacto
    public void delete(String phone) {

        if (contacts.containsKey(phone)) {
            contacts.remove(phone);
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("No existe un contacto con ese número.");
        }
    }
}



