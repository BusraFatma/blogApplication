package africa.semicolon.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Main {
//    private static final PostController postController = new PostController();
//    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
//        displayMainMenu();
    }

//    private static void displayMainMenu() {
//        String mainMenu = """
//                Press 1 for create post
//                Press 2 for view post""";
//
//        String userInput = input(mainMenu);
//        switch (Integer.parseInt(String.valueOf(userInput.charAt(0)))){
//            case 1-> createPost();
//            case 2-> viewPost();
//            case 3-> exitFromApp();
//        }
//    }
//
//    private static void exitFromApp() {
//        print("Thanks")
//    }
//
//    private static void viewPost() {
//        String userInput = input("Enter post id");
//        print(postController.viewPost(Integer.parseInt(userInput)));
//    }
//
//    private static String input(String prompt) {
//        display(prompt);
//        return scanner.nextLine();
//    }
}
