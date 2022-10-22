public class Player {
     
    String Firstname = "";
    String Lastname = "";
    ArrayList<Card> cards= new ArrayList<Card> ();
     
    public String getFiirstname() {
        return Firstname;
    }
     
    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }
 
    public String getLastname() {
        return Lastname;
    }
     
    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }
     
     public ArrayList<Card> getCards() {
        return cards;
    }
 
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
 
    public Player(String fname, String lname) {
        this.Firstname = firstname;
        this.Lastname = lastname;
    }
     
    public void AddCard(Card dealedCard)
    {
       cards.add(dealedCard);
    }
     
    public void ShowCards(){
        System.out.println(Firstname + Lastname + "hold cards");
        for (int i=0;i<cards.size();i++)
        {
            System.out.print(cards.get(i).toString());
        }
        System.out.println();
    }
     
    public void SortCardsByFace(){
        System.out.println(Firstname + Lastname + "hold cards");
        for (int i = 0; i < cards.size() - 1; i++)
        {
            int j = i;
            for (int k = i + 1; k < cards.size(); k++)
            {
                Card c = new Card();
                if (c.toInt(cards.get(k).getFace()) < c.toInt(cards.get(j).getFace()))
                {
                    j=k;
                }
 
            }
 
            Card temp = cards.get(j);
            cards.set(j,cards.get(i));
            cards.set(i,temp);
 
        }
        ShowCards();
    }
   
    public void SortCardsBySuitFace()
    {
     
    }
}
