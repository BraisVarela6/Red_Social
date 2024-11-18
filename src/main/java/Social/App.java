package Social;

import java.util.*;

public class App{

    private static Set<Users> usersSet = new HashSet<>();

    public static void initialUsers() {
        usersSet.add((new Users("Brais")));
    }

    public static void main(String[] args) {
        initialUsers();
        menu();
    }



    public static void menu (){
        System.out.println("1. Explorar usuarios");
        System.out.println("2. Explorar posts");
        System.out.println("3. Publicar un post");
        System.out.println("4. Crear usuario");
        System.out.println("5. Salir de la aplicación");

        int input= Utils.integer("\nSelecciona lo que quieres hacer: \n");

        switch (input) {
            case 1:
                selectUsers();
                break;

            case 2:
                //showPost();
                break;

            case 3:

                break;

            default:
                System.out.printf("Saliendo de la aplicación... \n");
                break;
        }
    }

    public static void showUsers(){
        for (Users user : usersSet) {
            System.out.println("- " + user.getUserName());
        }
    }

    public static void selectUsers() {
        int input;
        String user;
        boolean userFound = false;
        int exit;
        showUsers();


        while (!userFound) {
            user = Utils.string("Introduce el nombre de usuario que quieres seleccionar: ");


            Users selectedUser = null;
            for (Users u : usersSet) {
                if (u.getUserName().equalsIgnoreCase(user)) {
                    selectedUser = u;
                    break;
                }

                if (selectedUser != null) {
                    System.out.println("===================================");

                    System.out.println("1. Llamar \n2. Ver detalles \n3. Dejar de seguir \n4. Volver al menú principal");

                    input = Utils.integer("Selecciona lo que quieres hacer: ");

                    switch (input) {
//                    case 1:
//                        users.callMyNumber();
//                        break;
//                    case 2:
//                        System.out.println("Mostrando información de " + users.getCode());
//                        users.showContactDetails();
//                        break;
                        case 1:
                            usersSet.remove(selectedUser);
                            System.out.println("Dejando de seguir a: " + selectedUser.getUserName());
                            break;
                        case 2:
                            System.out.println("Saliendo al menú principal...");
                            break;

                    }

                    userFound = false;
                } else {
                    exit = Utils.integer("No es posible encontrar el contacto :(\n1. Intentarlo de nuevo" + "\n2. Salir al menú principal " + "\nSeleccione una opción: ");
                    switch (exit) {
                        case 1:
                            System.out.println("Inténtelo de nuevo");
                            break;
                        case 2:
                            System.out.println("Volviendo al menú principal...");
                            userFound = true;
                            break;
                        default:
                            System.out.printf("Opción no válida.");


                    }

                }
            }
        }
    }
}








