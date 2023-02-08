package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

/** Unit test for simple App. */
public class AppTest {

  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  
 /**
  * This function tests the initialization of the NomMachine class
  */
  @Test
  public void initNomMachine() {
      NomMachine test = new NomMachine("www","uvsq","fr");
      assertEquals(test.getMachineDomaineLocal(), "www.uvsq.fr");
  }

  /**
   * It tests that the function getAdresse() returns the correct value
   */
  @Test
    public void initip() {
        Adresseip test = new Adresseip ("196","12","69","32");
        assertEquals(test.getAdresse(), "196.12.69.32");
    }
     /**
    // Testing the initialization of the DnsItem class.
    * 
     */
    @Test
    public void initDnsItemAdressip() {
        Adresseip adresse = new Adresseip ("196","12","69","32");
        NomMachine machine = new NomMachine("www","uvsq","fr");
        DnsItem test = new DnsItem(adresse,machine );
        assertEquals(test.getDnsItemAdresse().getAdresse(), "196.12.69.32");
    }

     /**
    // Testing the initialization of the DnsItem class.
    * 
     */
    @Test
    public void initDnsItemMachine() {
      Adresseip adresse = new Adresseip ("196","12","69","32");
      NomMachine machine = new NomMachine("www","impot","gouv");
      DnsItem test = new DnsItem(adresse,machine );
        assertEquals(test.getDnsItemMachine().getMachineDomaineLocal(), "www.impot.gouv");
    }

    /**
     * It tests the addItem function of the Dns class
     */
    @Test
    public void addelement() throws IOException {
        Dns test = new Dns("bdd.txt");
        Adresseip adresse = new Adresseip ("191","24","25","29");
        NomMachine machine = new NomMachine("monsite","google","fr");
        DnsItem temp = new DnsItem(adresse, machine);
        try {
            test.addItem(temp.getDnsItemAdresse(),temp.getDnsItemMachine());
            assertTrue(true);
        } catch (Exception e) {
            fail("exception");
        }
    }


   /**
    * It tests if the item is present in the file
    */
    @Test
    public void itempresent() throws IOException {
        Dns test = new Dns("bdd.txt");
        Adresseip adresse = new Adresseip ("189","12","69","32");
        NomMachine machine = new NomMachine("wzzzww","impot","gouv");
        DnsItem temp = new DnsItem(adresse, machine);
        try {
            test.getItem(temp.getDnsItemAdresse());
            assertTrue(true);
        } catch (Exception e) {
            fail("exception");
        }
    }


    /**
     * It tests that the getItem method returns null when the element is not present in the file
     */
    @Test
    public void nopresentelement() throws IOException {
        Dns test = new Dns("bdd.txt");
        Adresseip tempo = new Adresseip("0","0","0","0");
        assertNull(test.getItem(tempo));
    }

}
