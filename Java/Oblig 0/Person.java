public class Person {
    private Bil3 bil; // konstruktor oppretter bilobjekt under klassen Bil3
   public Person(Bil3 bil){ // person tar inn bil-objekt som parameter
       this.bil = bil;
   }
   public void skrivPersonBilNr(){
       System.out.println("Person sitt bilnr: " + bil.hentNummer());
   }
}
