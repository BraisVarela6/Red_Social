package Social;

import java.util.*;

public class App {

    private static Set<Users> usersSet = new HashSet<>();
    private static Users currentUser = null;


    public static void initial() {

        Users user1 = new Users("Brais", "user1");
        Users user2 = new Users("Manuel", "user2");
        Users user3 = new Users("Laura", "user3");
        Users user4 = new Users("Pepe", "user4");
        usersSet.add(user1);
        usersSet.add(user2);
        usersSet.add(user3);
        usersSet.add(user4);

        String type = Utils.string("Introduzca el tipo de post que quiere subir: ");


        user1.addPosts(new Post(new ArrayList<>(),new Date(),type,1));
        user2.addPosts(new Post(new ArrayList<>(),new Date(),type,2));
        user1.addPosts(new Post(new ArrayList<>(),new Date(),type,3));
        user2.addPosts(new Post(new ArrayList<>(),new Date(),type,4));
        user1.addPosts(new Post(new ArrayList<>(),new Date(),type,5));
        user2.addPosts(new Post(new ArrayList<>(),new Date(),type,6));

    }

    public static void createPost() {
        String content = Utils.string("Introduzca el post: ");
        int postNumber = currentUser.getPosts().size()+1;
        Post newPost = new Post(new ArrayList<>(),new Date(),content, postNumber);
        currentUser.addPosts(newPost);
        System.out.println("\nEl usuario '" + currentUser.getUserName() + "' acaba de publicar un nuevo post: " + content);

    }

//    public static void createComments() {
//        int option;
//        do {
//
//        } while ();
//        String comment = Utils.string("Introduce el comentario aqui: ");
//        Comments comments = new Comments(comment,new Date(), new Users("Brais","sda"));
//    }

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
            currentUser = loggedInUser;
            System.out.println("\n\n\n\n\n\n\n\nBienvenido, " + loggedInUser.getUserName() + "!\n");
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
                currentUser = newUser;
                System.out.printf("\nEl usuario '" + newUserName + "' ha sido creado con éxito.");
                System.out.println("");
                menu();

    }


    public static void menu() {
        int input;
        do {
            System.out.println("\n1. Explorar usuarios");
            System.out.println("2. Explorar posts");
            System.out.println("3. Publicar un post");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Cerrar sesión");
            System.out.println("6. Salir de la aplicación");

            input = Utils.integer("\nSelecciona lo que quieres hacer: \n");

            switch (input) {
                case 1:
                    selectUsers();
                    break;

                case 2:
//                    showAllPosts();
                    break;

                case 3:
                    createPost();
                    break;

                case 4:
                    //deleteUser();
                    break;

                case 5:
                    System.out.println("Cerrando sesión... \n");
                    menuLog();
                    break;

                default:
                    System.out.println("Saliendo de la aplicación... \n");
                    break;
            }
        } while (input != 5);
    }

    public static void menuPosts() {
        int option;
        do {
            System.out.println("\n1. Seleccionar post");
            System.out.println("2. Volver");
            System.out.println("3. Salir al menú principal");
            option = Utils.integer("\n Seleccione lo que quiere hacer: \n");
//            for (int i = 0; i < postList.size(); i++) {
//
//            }
        } while (option !=3);
    }





    public static void showUsers() {
        for (Users user : usersSet) {
            System.out.println("- " + user.getUserName());
        }
    }

//    public static void showAllPosts() {
//        int postNumber = 1;
//        for (Map.Entry<Users, List<Post>> entry : postList.entrySet()) {
//            Users user = entry.getKey();
//            List<Post> posts = entry.getValue();
//
//            if (posts != null && !posts.isEmpty()) {
//                System.out.println("Posts de " + user.getUserName() + ":");
//
//                for (Post post : posts) {
//                    System.out.println("  Post " + postNumber + " publicado el " + post.getDate());
//                    postNumber++;
//                }
//            }
//        }
//        menuPosts();
//    }

    public static void showPosts(Users user) {


            if (user.getPosts().isEmpty() || user.getPosts() == null) {
                System.out.println("\n" + user.getUserName() + " no tiene ningún post todavía.");
                return;
            }
                System.out.println("Posts de " + user.getUserName() + ":");

                for (Post post : user.getPosts()) {
                    System.out.println("  Post " + (post.getPostNumber()) + " publicado el " + post.getDate() + ": ");
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

//    public static void selectPosts(Users selectedUser) {
//        int input;
//        int postNumber;
//        boolean postFound = false;
//        int exit;
//        showPosts(selectedUser);
//
//
//        while (!postFound) {
//            postNumber = Utils.integer("Introduce el número de post que quieres seleccionar: ");
//
//            Post selectedPost = null;
//            for (Post post : selectedUser.getPosts()) {
//                if (post.getPostNumber() == postNumber) {
//                    selectedPost = post;
//                    break;
//                }
//            }
//
//
//            if (selectedUser != null) {
//                System.out.println("===================================");
//
//                System.out.println("1. Ver posts de este usuario:  \n2. Ver comentarios de este usuario:  \n3. Dejar de seguir \n4. Volver al menú principal");
//
//                input = Utils.integer("Selecciona lo que quieres hacer: ");
//
//                switch (input) {
//                    case 1:
//                        showPosts();
//                        break;
////                    case 2:
////                        System.out.println("Mostrando información de " + users.getCode());
////                        users.showContactDetails();
////                        break;
//                    case 3:
//                        usersSet.remove(selectedUser);
//                        System.out.println("Dejando de seguir a: " + postNumber);
//                        break;
//                    case 4:
//                        System.out.println("Saliendo al menú principal...");
//                        break;
//
//                }
//
//                postFound = true;
//            } else {
//                exit = Utils.integer("No es posible encontrar el contacto :(\n1. Intentarlo de nuevo" + "\n2. Cerrar sesión " + "\nSeleccione una opción: ");
//                switch (exit) {
//                    case 1:
//                        System.out.println("Inténtelo de nuevo");
//                        break;
//                    case 2:
//                        System.out.println("Cerrando sesión...");
//                        menuLog();
//                        postFound = true;
//                        break;
//                    default:
//                        System.out.println("Opción no válida.");
//
//
//                }
//
//            }
//
//        }
//    }

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
                        System.out.println("Dejando de seguir a: " + userName);
                        break;
                    case 4:
                        System.out.println("Saliendo al menú principal...");
                        break;

                }

                userFound = true;
            } else {
                exit = Utils.integer("No es posible encontrar el contacto :(\n1. Intentarlo de nuevo" + "\n2. Cerrar sesión " + "\nSeleccione una opción: ");
                switch (exit) {
                    case 1:
                        System.out.println("Inténtelo de nuevo");
                        break;
                    case 2:
                        System.out.println("Cerrando sesión...");
                        menuLog();
                        userFound = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");


                }

            }

        }
    }
}








