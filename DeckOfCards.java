
import java.util.*;

class Card {
    // private static int no_of_cards = 52;
    public String[] Suits = { "SPADES", "DIAMONDS", "HEARTS", "CLUBS" };
    public String[] Ranks = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING" };
    public int myRank, mySuits;
    
    public Card() // default constructor
    {
        this.myRank = 0;
        this.mySuits = 0;
    }
    
    public Card(int myRank, int mySuits) {
        this.myRank = myRank;
        this.mySuits = mySuits;
    }

    public int getmyRank() {
        return myRank;
    }

    public void printCard() {
        System.out.print("" + Ranks[myRank] + " -> " + Suits[mySuits]);
    }

    public boolean cardIsSame(Card w1, Card w2) {
        return (w1.mySuits == w2.mySuits && w1.myRank == w2.myRank);
    }

    public int compareCard(Card w2) {
        if (this.mySuits == w2.mySuits) {
            if (this.myRank > w2.myRank) {
                return 1;
            } else if (this.myRank < w2.myRank) {
                return 2;
            } else
                return -1;
        } else
            System.out.print("\nSuits are different, can't compare");
        return 0;
    }

    public void findCard(List<Card> card) { //Listclass is the parentclass of vctor and arraylist class
        int count = 1;
        Card w2 = new Card(this.myRank, this.mySuits);
        for (Card c : card) {             //c is the reference of the object
            if (cardIsSame(c, w2)) {
                System.out.println(" This Card is present at: " + count);
            }
            count++;
        }
        if (count > 53) {
            System.out.println("Not Found in the deck at all !!");
        }
    }

    public void dealCard(List<Card> cards) {
        System.out.println("\nRandom 5 Cards: ");
        for (int i = 1; i <= 5; i++) {
            int random = (int) (Math.random() * 52); //Math.random returns random values between 0 to 1, hence we tycasted random to int
            int count = 1;   //count is for card nos 1 to 52
            for (Card c : cards) { //c is the reference object here
                if (count == random) {
                    c.printCard();
                    System.out.println("");
                    count++;
                }
                count++;
            }
        }
    }
}

class sortCard implements Comparator {
    @Override
    public int compare(Object w3, Object w4) {   //general object 
        Card c3 = (Card) w3;
        Card c4 = (Card) w4;
        if (c3.getmyRank() == c4.getmyRank()) {
            return 0;
        } else if (c3.getmyRank() > c4.getmyRank()) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class DeckOfCards {
    static Scanner x = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");      //Clear screen
        //Card[] deckCards = new Card[52];
        int count = 0, myRank, mySuits, choice = 1;
        ArrayList<Card> cards = new ArrayList<Card>();
        while (choice == 1) {
            System.out.println("\n1) CREATE A NEW DECK");
            System.out.println("2) DISPLAY THE DECK");
            System.out.println("3) SORT THE DECK");
            System.out.println("4) SEARCH THE CARD");
            System.out.println("5) COMPARE THE DECK");
            System.out.println("6) RANDOM GOOD CARDS");
            System.out.print("Enter your Choice : ");
            int ch = x.nextInt();
            switch (ch) {
            case 1: {
                for (int s = 0; s < 4; s++) {
                    for (int r = 0; r < 13; r++) {
                        if (count > 52) {
                            break;
                        } else {
                            cards.add(new Card(r, s));
                            count++;
                        }
                    }
                }
                System.out.println("\nDECK IS CREATED SUCCESSFULLY !!");
                break;
            }
            case 2: {
                System.out.println("\nDISPLAYING YOUR DECK\n");
                for (Card s : cards) {
                        s.printCard();
                        System.out.println("");
                }
                break;
            }
            case 3: {
                Collections.sort(cards, new sortCard());  //sortCard is the default constructor of class sortCard
                Iterator it = cards.iterator();
                while (it.hasNext()) {
                    Card s = (Card) it.next(); //fetched nxt element from iterator and stored inside s object
                    s.printCard();
                    System.out.println("");
                }
                break;
            }
            case 4: {
                System.out.println("SEARCH CARD");
                System.out.print("Enter Card Rank (1-13) : ");
                myRank = x.nextInt();
                System.out.print("Enter Card Suit (1-4) : ");
                mySuits = x.nextInt();
                Card c1 = new Card(myRank -1, mySuits -1);
                System.out.print(" Card : ");
                c1.printCard();
                c1.findCard(cards);
                break;
            }
            case 5: {
                System.out.println("\nCOMPARE CARDS");

                System.out.println("CARD 1 :");
                System.out.print("Enter Card Rank (1-13) : ");
                myRank = x.nextInt();
                System.out.print("Enter Card Suit (1-4) : ");
                mySuits = x.nextInt();
                Card c3 = new Card(myRank - 1, mySuits - 1);

                System.out.println("CARD 2 :");
                System.out.print("Enter Card Rank (1-13) : ");
                myRank = x.nextInt();
                System.out.print("Enter Card Suit (1-4) : ");
                mySuits = x.nextInt();
                Card c4 = new Card(myRank - 1, mySuits - 1);

                int uCompare = c3.compareCard(c4);
                System.out.print("\n");
                if (uCompare == -1) {
                    c3.printCard();
                    System.out.println(" = ");
                    c4.printCard();
                } else if (uCompare == 1) {
                    c3.printCard();
                    System.out.print(" > ");
                    c4.printCard();
                } else if (uCompare == 2) {
                    c3.printCard();
                    System.out.print(" < ");
                    c4.printCard();
                }
                System.out.print("\n");
                c3 = null;
                c4 = null;
                Runtime.getRuntime().gc();    //Garbage Collector
                break;
            }
            case 6: {
                Card c5 = new Card();
                c5.dealCard(cards);
                c5 = null;
                Runtime.getRuntime().gc();
                break;
            }
            default: {
                System.out.println("INVALID CHOICE: ");
            }
                System.out.println(
                        "Do you want to continue ahead." + "\nIf Yes then press '1' otherwise press 'anything' :");
                choice = x.nextInt();
            }
        }
    }
}