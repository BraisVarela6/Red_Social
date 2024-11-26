package Social;

import jdk.jshell.execution.Util;

import javax.sound.midi.Soundbank;
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



        user1.addPosts(new Post(new ArrayList<>(),new Date(),"Texto",1));
        user2.addPosts(new Post(new ArrayList<>(),new Date(),"Texto",2));
        user1.addPosts(new Post(new ArrayList<>(),new Date(),"Texto",3));
        user2.addPosts(new Post(new ArrayList<>(),new Date(),"Texto",4));
        user1.addPosts(new Post(new ArrayList<>(),new Date(),"Texto",5));
        user2.addPosts(new Post(new ArrayList<>(),new Date(),"Texto",6));
        user3.addPosts(new Post(new ArrayList<>(),new Date(),"Texto",7));

        user1.addFollowers(user4);
        user1.addFollowers(user3);

//        Post p1 = new Post(new ArrayList<>(), new Date(),"Texto", 8);

//        p1.addComments(new Comments("Probando", new Date(),user1,1));

    }

    public static void createPost() {

        String text = "Texto";
        String image = "Imagen";
        String video = "Video";

        System.out.println("1. TEXTO");
        System.out.println("2. IMAGEN");
        System.out.println("3. VIDEO");

        int type = Utils.integer("Introduzca el tipo de post que quiere subir: ");
        int postCount = 0;
        for (Users user : usersSet ) {
            postCount += user.getPosts().size();
        }


        switch (type) {
            case 1:
                String content = Utils.string("Escriba el contenido: ");
                PostText newPostText = new PostText(new ArrayList<>(),new Date(),text, postCount, content);
                currentUser.addPosts(newPostText);
                System.out.println("\n" + currentUser.getUserName() + "' acaba de publicar un nuevo post de tipo texto: " + content);
                break;
            case 2:
                String title = Utils.string("Introduzca un título: ");
                int height = Utils.integer("Introduzca una altura: ");
                int width = Utils.integer("Introduzca un ancho: ");
                PostImage newPostImage = new PostImage (new ArrayList<>(),new Date(),image, postCount, title, height, width);
                currentUser.addPosts(newPostImage);
                System.out.println("\nEl usuario '" + currentUser.getUserName() + "' acaba de publicar un nuevo post de tipo Imagen: " + type);
                break;
            case 3:
                String titleVid = Utils.string("Introduzca un título: ");
                String quality = Utils.string("Introduzca la calidad: ");
                int duration = Utils.integer("Introduzca una duración: ");
                PostVideo newPostVideo = new PostVideo(new ArrayList<>(),new Date(),video, postCount, titleVid, quality, duration);
                currentUser.addPosts(newPostVideo);
                System.out.println("\nEl usuario '" + currentUser.getUserName() + "' acaba de publicar un nuevo post de tipo Video: " + type);
                break;
        }
    }

    public static void createComment(Post selectedPost) {
        int commentNumber = 1;
        String comment = Utils.string("Introduzca el comentario: ");
        Comments newComments = new Comments(comment, new Date(), currentUser, commentNumber++);
        selectedPost.addComments(newComments);
        System.out.println("Enhorabuena!!, has publicado: " + comment + " en el post número: " + selectedPost.getPostNumber());
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
            logIn();
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
            System.out.println("4. Ver a quien sigues");
            System.out.println("5. Cerrar sesión");
            System.out.println("6. Eliminar cuenta");
            System.out.println("7. Salir de la aplicación");

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
                    showFollow();
                    break;
                case 5:
                    System.out.println("Cerrando sesión... \n");
                    menuLog();
                    break;

                case 6:
                    deleteAccount();
                    menuLog();
                    break;

                default:
                    System.out.println("Saliendo de la aplicación... \n");
                    System.exit(0);
                    break;
            }
        } while (input != 6);
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

    public static void showAllComments(Users selectedUser) {
        System.out.println("Mostrando todos los comentarios de: " + selectedUser.getUserName());

        List<Post> userPost = selectedUser.getPosts();
            for (Post post : userPost) {
                List<Comments> comments = post.getComments();
                if (!comments.isEmpty())
                    for (Comments comment : comments) {
                        System.out.println("- " + comment.getComment());
                }
            }

    }

    public static void showComments(Post post, Users user) {
        if (post.getComments().isEmpty() || post.getComments() == null) {
            System.out.println("\nEl post " + post.getPostNumber() + " no tiene ningún comentario todavía.");
            return;
        }
        System.out.println("\nComentarios del post: \n");

        for (Comments comments : post.getComments()) {
            System.out.println(comments.getCommentNumber() + ". " + user.getUserName() + " ha comentado " + comments.getComment() + " -- " + post.getDate() + "\n");
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

    public static void deleteAccount() {
        usersSet.remove(currentUser);
        System.out.println("Eliminando su cuenta...");
        System.out.println("Cuenta eliminada");
    }

    public static void selectComments(Users selectedUser, Post selectedPost) {
        showComments(selectedPost, selectedUser);
        int input;
        int commentNumber;
        boolean commentFound = false;
        int exit;



        while (!commentFound) {
            commentNumber = Utils.integer("Introduce el número de comentario que quieres seleccionar: ");

            Comments selectedComment = null;
            for (Comments comments : selectedPost.getComments()) {
                if (comments.getCommentNumber() == commentNumber) {
                    selectedComment = comments;
                    break;
                }
            }


            if (selectedComment != null) {
                System.out.println("===================================");

                System.out.println("1. Darle like.  \n2. Ver los likes de este comentario.  \n3. Eliminar comentario. \n4. Volver al menú principal");

                input = Utils.integer("Selecciona lo que quieres hacer: ");

                switch (input) {
                    case 1:
//                        createComment(selectedPost);
                        break;
                    case 2:
                        showComments(selectedPost, selectedUser);
                        break;
                    case 3:
                        selectedPost.getComments().remove(selectedComment);
                        System.out.println("Eliminando el comentario: " + selectedComment.getComment() + " de " + selectedUser.getUserName());
                        break;
                    case 4:
                        System.out.println("Saliendo al menú principal...");
                        break;

                }

                commentFound = true;
            } else {
                exit = Utils.integer("No es posible encontrar el comentario :(\n1. Intentarlo de nuevo" + "\n2. Salir " + "\n3. Cerrar sesión " + "\nSeleccione una opción: ");
                switch (exit) {
                    case 1:
                        System.out.println("Inténtelo de nuevo");
                        break;
                    case 2:
                        System.out.println("Saliendo...\n");
                        menu();
                        break;
                    case 3:
                        System.out.println("Cerrando sesión...");
                        menuLog();
                        commentFound = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");


                }

            }

        }
    }

    public static void selectPosts(Users selectedUser) {
        showPosts(selectedUser);
        int input;
        int postNumber;
        boolean postFound = false;
        int exit;



        while (!postFound) {
            postNumber = Utils.integer("Introduce el número de post que quieres seleccionar: ");

            Post selectedPost = null;
            for (Post post : selectedUser.getPosts()) {
                if (post.getPostNumber() == postNumber) {
                    selectedPost = post;
                    break;
                }
            }


            if (selectedPost != null) {
                System.out.println("===================================");

                System.out.println("1. Comentar en este post.  \n2. Ver los comentarios de este post.  \n3. Eliminar post. \n4. Volver al menú principal");

                input = Utils.integer("Selecciona lo que quieres hacer: ");

                switch (input) {
                    case 1:
                        createComment(selectedPost);
                        break;
                    case 2:
                        selectComments(selectedUser, selectedPost);
                        break;
                    case 3:
                        selectedUser.getPosts().remove(selectedPost);
                        System.out.println("Eliminando el post número: " + postNumber);
                        break;
                    case 4:
                        System.out.println("Saliendo al menú principal...");
                        break;

                }

                postFound = true;
            } else {
                exit = Utils.integer("No es posible encontrar el contacto :(\n1. Intentarlo de nuevo" + "\n2. Cerrar sesión " + "\nSeleccione una opción: ");
                switch (exit) {
                    case 1:
                        System.out.println("Inténtelo de nuevo");
                        break;
                    case 2:
                        System.out.println("Cerrando sesión...");
                        menuLog();
                        postFound = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");


                }

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

                System.out.println("1. Ver posts de este usuario:  \n2. Ver comentarios de este usuario:  \n3. Seguir \n4. Eliminar usuario \n5. Volver al menú principal");

                input = Utils.integer("Selecciona lo que quieres hacer: ");

                switch (input) {
                    case 1:
                        selectPosts(selectedUser);

                        break;
                    case 2:
                        showAllComments(selectedUser);
                        break;
                    case 3:
                        checkFollow(selectedUser);
                        break;
                        case 4:
                            usersSet.remove(selectedUser);
                            System.out.println("Eliminando a:" + userName);
                            System.out.println("El usuario " + userName + " ha sido eliminado");
                            break;
                    case 5:
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

    public static void checkFollow(Users selectedUser) {
        int option;
            if (currentUser.getFollowers().contains(selectedUser)) {
                System.out.println("Ya estás siguiendo a " + selectedUser.getUserName() + ". ¿Quieres dejar de seguirlo? :o");
                System.out.println("1. Si");
                System.out.println("2. No");
                option = Utils.integer("Selecciona lo que quieres hacer: ");

                switch (option) {
                    case 1:
                        currentUser.removeFollowers(selectedUser);
                        System.out.println("Has dejado de seguir a " + selectedUser.getUserName() + " :(");
                        break;
//                    case 2:
//                        selectUsers();
//                        break;
                }
            } else {
                currentUser.addFollowers(selectedUser);
                System.out.println("Has empezado a seguir a " + selectedUser.getUserName() + "!!!");
            }

    }

    public static void showFollow() {
        if (currentUser.getFollowers().isEmpty()) {
            System.out.println("No has seguido a nadie todavía");
        } else {
            System.out.println("Siguiendo a: ");
            for (Users followers : currentUser.getFollowers())
            System.out.println("- " + followers.getUserName());
        }
    }
}








