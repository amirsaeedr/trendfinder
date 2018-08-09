package ir.nimbo.moama.trendfinder;

import ir.nimbo.moama.trendfinder.twitter.TwittReader;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        TwittReader twittReader = new TwittReader();
        twittReader.subscribe();
    }
}
