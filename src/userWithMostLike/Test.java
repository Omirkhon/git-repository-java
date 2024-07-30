package userWithMostLike;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        User[] users = new User[10];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < users.length; i++) {
            String userName = "User #" + (i + 1);
            int userAge = 20 + i;
            Post[] posts = new Post[random.nextInt(1, 6)];
            for (int j = 0; j < posts.length; j++) {
                String postTitle = userName + " Post #" + (j + 1);
                String description = userName + " some description #" + (j + 1);
                int likesCount = random.nextInt(0, 1_000_000);
                posts[j] = new Post(postTitle, description, likesCount);
            }
            users[i] = new User(userName, userAge, posts);
        }

        builder.append("[");
        int userCount = 1;
        for (User user : users) {
            Post mostLikedPost = user.posts[0];
            builder.append("\t{\"name\": \"");
            builder.append(user.name);
            builder.append("\",\"age\": ");
            builder.append(user.age);
            builder.append(",\"posts\": [ \t");
            int postCount = 1;
            for (Post post : user.posts) {
                builder.append("{ \t");
                builder.append("\"title\": \t \"");
                builder.append(post.title);
                builder.append("\",\"description\": \"");
                builder.append(post.description);
                builder.append("\",\"likes_Count\":");
                builder.append(post.likesCount);
                if (postCount == user.posts.length) {
                    builder.append("}");
                } else {
                    builder.append("},");
                }
                if (post.likesCount > mostLikedPost.likesCount) {
                    mostLikedPost  = post;
                }
                postCount++;
            }
            builder.append("],");
            builder.append("\"most_liked_post\": { \t");
            builder.append("\"title\": \t \"");
            builder.append(mostLikedPost.title);
            builder.append("\",\"description\": \"");
            builder.append(mostLikedPost.description);
            builder.append("\",\"likes_Count\":");
            builder.append(mostLikedPost.likesCount);
            builder.append("}");
            if (userCount == users.length) {
                builder.append("}");
            } else {
                builder.append("},");
            }
            userCount++;
        }
        builder.append("]");
        String asString = builder.toString();
        System.out.println(asString);
    }
}

class User {
    public int id;
    public String name;
    public int age;
    public Post[] posts;

    private static int serial = 1;

    public User(String name, int age, Post[] posts) {
        id = serial++;
        this.name = name;
        this.age = age;
        this.posts = posts;
    }
}

class Post {
    public int id;
    public String title;
    public String description;
    public int likesCount;

    private static int serial = 1;

    public Post(String title, String description, int likesCount) {
        id = serial++;
        this.title = title;
        this.description = description;
        this.likesCount = likesCount;
    }
}