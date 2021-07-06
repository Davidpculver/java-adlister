import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args) {

        Author author1 = new Author("Nelson", "Mandela");
        Author author2 = new Author("Michael", "Jordan");
        Quote quote1 = new Quote("It always seems impossible until it's done.", author1);
        Quote quote2 = new Quote("Everyone can rise above their circumstances and achieve success if they are dedicated to and passionate about what they do.", author1);
        Quote quote3 = new Quote("A winner is a dreamer who never gives up.", author1);
        Quote quote4 = new Quote("You miss 100 percent of the shots you dont take.", author2);

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quote1);
        quotes.add(quote2);
        quotes.add(quote3);
        quotes.add(quote4);

        for (Quote quote : quotes){
            System.out.println("Author: " + quote.getAuthor().getFirstName() + " " + quote.getAuthor().getLastName());
            System.out.println("Quote: " + quote.getContent());
        }
    }
}