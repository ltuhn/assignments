public class BilBruk3 {
    public static void main(String[] args) {
        Bil3 bil = new Bil3("AB 123456"); // lager bilobjekt "bil" under klassen Bil3, sender inn "AB 123456" som bilnummer
        Person person = new Person(bil); // lager personobjekt "person" under klassen Person, sender inn det nyopprettede bilobjektet som argument
        person.skrivPersonBilNr(); // person kaller paa metoden skrivPersonBilNr
    }
}
