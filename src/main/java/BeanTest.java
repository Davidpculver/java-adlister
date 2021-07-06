import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args) {

//        Author author1 = new Author("Nelson", "Mandela");
//        Author author2 = new Author("Michael", "Jordan");
//        Quote quote1 = new Quote("It always seems impossible until it's done.", author1);
//        Quote quote2 = new Quote("Everyone can rise above their circumstances and achieve success if they are dedicated to and passionate about what they do.", author1);
//        Quote quote3 = new Quote("A winner is a dreamer who never gives up.", author1);
//        Quote quote4 = new Quote("You miss 100 percent of the shots you dont take.", author2);
//
//        ArrayList<Quote> quotes = new ArrayList<>();
//        quotes.add(quote1);
//        quotes.add(quote2);
//        quotes.add(quote3);
//        quotes.add(quote4);
//
//        for (Quote quote : quotes){
//            System.out.println("Author: " + quote.getAuthor().getFirstName() + " " + quote.getAuthor().getLastName());
//            System.out.println("Quote: " + quote.getContent());
//        }

//        INSTRUCTOR EXAMPLE
        Album greatestHits = new Album(1, "Kenny Chesney", "Greatest Hits", 2004, 2, "country, notRnB");

        Author hdt = new Author(1, "Henry David", "Thoreau");
        Quote quoteOfTheDay = new Quote(1, "Todays quote of the day here.", hdt);

        System.out.println(quoteOfTheDay.getContent());
        System.out.println(quoteOfTheDay.getAuthor().getFirstName());
        System.out.println(greatestHits.getGenre());

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quoteOfTheDay);
        quotes.add(new Quote(2, "Tomorrows quote of the day goes here", new Author(2, "Bob", "Dole")));
        quotes.add(new Quote(3, "Yet another quote of the day goes here", hdt));

        for (Quote quote : quotes){
            System.out.println("Here's a quote for ya: ");
            System.out.printf("\"%s\"%n    - %s %s%n", quote.getContent(), quote.getAuthor().getFirstName(), quote.getAuthor().getLastName());
        }


    }
}