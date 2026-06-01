
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook("contactos.txt");

        addressBook.load();

        int option;

        do {
            System.out.println("\n===== AGENDA TELEFÓNICA =====");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar cambios");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    addressBook.list();
                    break;

                case 2:
                    System.out.print("Ingrese número telefónico: ");
                    String phone = scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String name = scanner.nextLine();

                    addressBook.create(phone, name);
                    break;

                case 3:
                    System.out.print("Ingrese número telefónico a eliminar: ");
                    String deletePhone = scanner.nextLine();

                    addressBook.delete(deletePhone);
                    break;

                case 4:
                    addressBook.save();
                    System.out.println("Cambios guardados.");
                    break;

                case 5:
                    addressBook.save();
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (option != 5);

        scanner.close();
    }
}
