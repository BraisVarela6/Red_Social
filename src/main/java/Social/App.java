package Social;

import java.util.*;

public class App {

    public static void main(String[] args) {
        initialUsers();
        initialPosts();
        menuLog();
        menu();
    }

    private static Set<Users> usersSet = new HashSet<>();
    private static Map<Users, List<Post>> postList = new HashMap<>();


    public static void initialUsers() {
        Users user1 = new Users("Brais", "user1");
        Users user2 = new Users("Manuel", "user2");
        Users user3 = new Users("Laura", "user3");
        Users user4 = new Users("Pepe", "user4");
        usersSet.add(user1);
        usersSet.add(user2);
        usersSet.add(user3);
        usersSet.add(user4);


    }

    public static void initialPosts() {
        Post post1 = new Post(new ArrayList<>(), new Date());
        Post post2 = new Post(new ArrayList<>(), new Date());
        Post post3 = new Post(new ArrayList<>(), new Date());
        Post post4 = new Post(new ArrayList<>(), new Date());


        for (Users user : usersSet) {
            if (user.getUserName().equals("Brais")) {
                List<Post> userPosts = postList.get(user);
                if (userPosts == null) {
                    userPosts = new ArrayList<>();
                    postList.put(user, userPosts); // Map usa el nombre del usuario como clave
                }
                postList.get(user).add(post1);
                postList.get(user).add(post2);
                postList.get(user).add(post3);
                postList.get(user).add(post4);
            }

        }
    }

    public static void menuLog() {
        int option;
        do {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");

            option = Utils.integer("Seleccione una opción: ");

            switch (option) {
                case 1:
                    logIn();
                    break;
                case 2:
                    signIn();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación");
                    break;
            }
        } while (option != 3);
    }

    public static void logIn() {
        String userName = Utils.string("Introduzca el nombre de usuario: ");
        String password = Utils.string("Introduzca la contraseña: ");

        Users loggedInUser = null;

        for (Users user : usersSet) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                loggedInUser = user;
                break;
            }
        }

        if (loggedInUser != null) {
            System.out.println("Bienvenido, " + loggedInUser.getUserName() + "!");
            menu();
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }

    public static void signIn() {
        String newUserName = Utils.string("Introduzca nombre de usuario: ");


        for (Users user : usersSet) {
            if (user.getUserName().equalsIgnoreCase(newUserName)) {
                System.out.println("El usuario " + newUserName + " ya existe. Prueba con otro nombre");
                signIn();
                return;
            }
        }
                String newPassword = Utils.string("Introduzca una contraseña: ");
                Users newUser = new Users(newUserName, newPassword);
                usersSet.add(newUser);
                System.out.printf("El usuario " + newUserName + " ha sido creado. \n");
                menu();

    }


    public static void menu() {
        int input;
        do {
            System.out.println("1. Explorar usuarios");
            System.out.println("2. Explorar posts");
            System.out.println("3. Publicar un post");
            System.out.println("4. Crear usuario");
            System.out.println("5. Salir de la aplicación");

            input = Utils.integer("\nSelecciona lo que quieres hacer: \n");

            switch (input) {
                case 1:
                    selectUsers();
                    break;

                case 2:
                    showPosts(user);
                    break;

                case 3:

                    break;
                case 4:
                    createUser();
                    break;

                default:
                    System.out.println("Saliendo de la aplicación... \n");
                    break;
            }
        } while (input != 5);
    }

    public static void showUsers() {
        for (Users user : usersSet) {
            System.out.println("- " + user.getUserName());
        }
    }

    public static void showPosts(Users user) {
        List<Post> posts = postList.get(user);

        if (posts == null || posts.isEmpty()) {
            System.out.println(user.getUserName() + " no tiene ningún post todavía.");
        } else {
            System.out.println("Posts de " + user.getUserName() + ":");


            for (int i = 0; i < posts.size(); i++) {
                Post post = posts.get(i);
                System.out.println("  Post " + (i + 1) + " publicado el " + post.getDate());
            }

        }
    }

    public static void createUser() {
        String newUser = Utils.string("Introduzca nombre de usuario: ");
        String newPassword = Utils.string("Introduzca una contraseña: ");

        for (Users user : usersSet) {
            if (user.getUserName().equalsIgnoreCase(newUser)) {
                System.out.println("El usuario " + newUser + " ya existe. ");

            } else {
                usersSet.add((new Users(newUser, newPassword)));
                System.out.printf("El usuario " + newUser + " ha sido creado. \n");
            }
        }

    }

    public static void selectUsers() {
        int input;
        String userName;
        boolean userFound = false;
        int exit;
        showUsers();


        while (!userFound) {
            userName = Utils.string("Introduce el nombre de usuario que quieres seleccionar: ");

            Users selectedUser = null;
            for (Users user : usersSet) {
                if (user.getUserName().equalsIgnoreCase(userName)) {
                    selectedUser = user;
                    break;
                }
            }

            if (selectedUser != null) {
                System.out.println("===================================");

                System.out.println("1. Ver posts de este usuario:  \n2. Ver comentarios de este usuario:  \n3. Dejar de seguir \n4. Volver al menú principal");

                input = Utils.integer("Selecciona lo que quieres hacer: ");

                switch (input) {
                    case 1:
                        showPosts(selectedUser);
                        break;
//                    case 2:
//                        System.out.println("Mostrando información de " + users.getCode());
//                        users.showContactDetails();
//                        break;
                    case 3:
                        usersSet.remove(selectedUser);
                        System.out.println("Dejando de seguir a: " + selectedUser);
                        break;
                    case 4:
                        System.out.println("Saliendo al menú principal...");
                        break;

                }

                userFound = true;
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








