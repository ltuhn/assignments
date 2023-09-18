import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.HashMap;
import java.util.*;

public class Monitor {
    private Lock hattVirusLaas = new ReentrantLock();
    private Lock ikkeHattVirusLaas = new ReentrantLock();
    private HashBeholder hattVirusBeholder;
    private HashBeholder ikkeHattVirusBeholder;
    private Condition hattVirusLagtTil = hattVirusLaas.newCondition();
    private Condition ikkeHattVirusLagtTil = ikkeHattVirusLaas.newCondition();

    public Monitor(HashBeholder hattVirusBeholder, HashBeholder ikkeHattVirusBeholder) {
        this.hattVirusBeholder = hattVirusBeholder;
        this.ikkeHattVirusBeholder = ikkeHattVirusBeholder;
    }

    public void leggTil(HashMap<String, SubSekvens> subsekvensMap, boolean hattVirus) {
        if (hattVirus == true) {
            hattVirusLaas.lock();
            try {
                hattVirusBeholder.leggTil(subsekvensMap);
                hattVirusLagtTil.signalAll();
            } finally {
                hattVirusLaas.unlock();
            }
        } else if (hattVirus == false) {
            ikkeHattVirusLaas.lock();
            try {
                ikkeHattVirusBeholder.leggTil(subsekvensMap);
                ikkeHattVirusLagtTil.signalAll();
            } finally {
                ikkeHattVirusLaas.unlock();
            }
        }
    }

    public ArrayList<HashMap<String, SubSekvens>> flett(boolean hattVirus, int hattVirusTraader, int ikkeHattVirusTraader) { // *
        ArrayList<HashMap<String, SubSekvens>> nySubsekvensMap = new ArrayList<>();
        if (hattVirus == true) {
            hattVirusLaas.lock();
        
            try {
                while (hattVirusBeholder.hentAntall() < 2) {
                    if (hattVirusTraader == 0) {
                        if (hattVirusBeholder.hentAntall() == 1) {
                            System.out.println("FEIL: Returnerer null fordi det er bare en hashMap igjen i hattVirusBeholder");
                            return null; // returnerer null dersom det ikke er nok hashmaps aa flette sammen, og ingen traader som arbeider
                        }
                    }
                    hattVirusLagtTil.await();
                }

                for (int i = 0; i < 2; i++) {
                    nySubsekvensMap.add(hattVirusBeholder.fjernHashMap()); // henter ut to hashmaps fra hattVirusBeholder, legger dem til i arraylisten nySubsekvensMap
                }
                hattVirusTraader++;
                return nySubsekvensMap;
            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                hattVirusLaas.unlock(); // uansett hva, vil laasen laases opp slik at andre traader kan arbeide i denne
            }
        } else if (hattVirus == false) {
            ikkeHattVirusLaas.lock();

            try {
                while (ikkeHattVirusBeholder.hentAntall() < 2) {
                    if (ikkeHattVirusTraader == 0) {
                        if (ikkeHattVirusBeholder.hentAntall() == 1) {
                            System.out.println("FEIL: Returnerer null fordi det er bare en hashMap igjen i ikkeHattVirusBeholder");
                            if (ikkeHattVirusTraader == 0) {
                                return null;
                            }
                        }
                    }
                    ikkeHattVirusLagtTil.await();
                }

                for (int i = 0; i < 2; i++) {
                    nySubsekvensMap.add(ikkeHattVirusBeholder.fjernHashMap());
                }
                ikkeHattVirusTraader++;
                return nySubsekvensMap;
            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                ikkeHattVirusLaas.unlock();
            }
        }
        return null;
    }

    public ArrayList<HashMap<String, SubSekvens>> hentHashbeholder(boolean hattVirus) {
        if (hattVirus) {
            hattVirusLaas.lock();

            try {
                while (hattVirusBeholder.hentAntall() < 1) { // hvis det ikke er noe aa hente, vent paa signal om at noe har blitt lagt til
                    hattVirusLagtTil.await();
                }
                return hattVirusBeholder.hentHashbeholder();
            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                hattVirusLaas.unlock();
            }
        } else {
            ikkeHattVirusLaas.lock();

            try {
                while (ikkeHattVirusBeholder.hentAntall() < 1) {
                    ikkeHattVirusLagtTil.await();
                }
                return ikkeHattVirusBeholder.hentHashbeholder();
            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                ikkeHattVirusLaas.unlock();
            }
        }
        return null;
    }

}