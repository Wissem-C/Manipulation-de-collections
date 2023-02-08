package fr.uvsq.cprog.collex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

/** It reads a file and adds the items to a list. */
public class Dns {

  private static List<DnsItem> DnsList = new ArrayList<DnsItem>();

  /**
   * This method is used to read the file and add the items to the list. It reads a file and adds
   * the items to a list.
   */
  public Dns(String path) throws IOException {
    File p = new File("bddproperties.txt");
    p.createNewFile();
    Properties f = new Properties();
    f.setProperty("file", path);
    f.store(new FileWriter("bddproperties.txt"), path);
    String line;
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      while ((line = reader.readLine()) != null) {
        String[] sp = line.split(" ");
        String[] sp1 = sp[0].split("\\.", 4);
        String[] sp2 = sp[1].split("\\.", 3);

        Adresseip adresse = new Adresseip(sp1[0], sp1[1], sp1[2], sp1[3]);
        NomMachine nommachine = new NomMachine(sp2[0], sp2[1], sp2[2]);

        // System.out.println(nommachine.getMachineDomaineLocal());
        // System.out.println(adresse.getAdresse());
        DnsList.add(new DnsItem(adresse, nommachine));
        // System.out.println(sp[1]);
        // System.out.println(sp[0]);

      }
    }
  }

  /**
   * . It returns a DnsItem object from a list of DnsItem objects, if the DnsItem object's IP
   * address matches the IP address passed as a parameter
   *
   * @param adresse the IP address of the machine you want to find.
   * @return The method returns a DnsItem object.
   */
  public DnsItem getItem(Adresseip adresse) {

    for (DnsItem dns : DnsList) {
      if (dns.getDnsItemAdresse().getAdresse().contains(adresse.getAdresse())) {
        System.out.println(
            dns.getDnsItemAdresse().getAdresse()
                + " "
                + dns.getDnsItemMachine().getMachineDomaineLocal());
        return dns;
      }
    }

    System.out.println("{null}" + " Aucun instance correspondant à l'adresse ip à été trouvé.");
    return null;
  }

  /**
   * . It returns the DnsItem object that corresponds to the machine passed as a parameter.
   *
   * @param machine the machine you want to find the DNS item for.
   * @return The method returns the DnsItem object that corresponds to the machine passed as a
   *     parameter.
   */
  public DnsItem getItem(NomMachine machine) {

    for (DnsItem dns : DnsList) {
      if (dns.getDnsItemMachine()
          .getMachineDomaineLocal()
          .contains(machine.getMachineDomaineLocal())) {
        System.out.println(
            dns.getDnsItemAdresse().getAdresse()
                + " "
                + dns.getDnsItemMachine().getMachineDomaineLocal());
        return dns;
      }
    }

    System.out.println("{null}" + " Aucun instance correspondant à l'adresse ip à été trouvé.");
    return null;
  }

  /**
   * . It sorts the list of DNS items by IP address or by name, depending on the command entered by
   * the user
   *
   * @param commande the command entered by the user
   * @param list the list of DnsItem objects
   * @param nomdomainelocal the name of the domain
   * @return The list of DnsItem sorted by the commande given by the user.
   */
  public List<DnsItem> sort(String commande, List<DnsItem> list, String nomdomainelocal) {
    if (commande.equals("ls-a")) {
      Comparator<DnsItem> comparerParIp =
          (item1, item2) ->
              item1
                  .getDnsItemAdresse()
                  .getAdresse()
                  .compareTo(item2.getDnsItemAdresse().getAdresse());
      Collections.sort(DnsList, comparerParIp);
      System.out.println("\n_______________________________\n");
      System.out.println("ITEM TRIÉ PAR ADRESSE : \n");

      for (DnsItem dns : DnsList) {
        if (dns.getDnsItemMachine().getDomaine().equals(nomdomainelocal)) {
          System.out.println(
              dns.getDnsItemAdresse().getAdresse()
                  + " "
                  + dns.getDnsItemMachine().getMachineDomaineLocal());
        }
      }

      System.out.println("_______________________________\n");
    } else if (commande.equals("ls")) {
      Comparator<DnsItem> comparerParNom =
          (item1, item2) ->
              item1
                  .getDnsItemMachine()
                  .getMachineDomaineLocal()
                  .compareTo(item2.getDnsItemMachine().getMachineDomaineLocal());
      Collections.sort(DnsList, comparerParNom);
      System.out.println("\n_______________________________\n");
      System.out.println("ITEM TRIÉ PAR NOM : \n");

      for (DnsItem dns : DnsList) {
        if (dns.getDnsItemMachine().getDomaine().equals(nomdomainelocal)) {

          System.out.println(
              dns.getDnsItemAdresse().getAdresse()
                  + " "
                  + dns.getDnsItemMachine().getMachineDomaineLocal());
        }
      }

      System.out.println("_______________________________\n");

    } else {
      System.out.println("Commande non reconnue");
    }

    return list;
  }

  /**
   * . It returns a list of DnsItem objects that have a specific domain name
   *
   * @param nomdomainelocal the name of the domain
   * @return A list of DnsItem objects.
   */
  public List<DnsItem> getItems(String nomdomainelocal) {
    List<DnsItem> ddns = new ArrayList<DnsItem>();
    System.out.println("La liste des dns avec ce nom de domaine est : ");

    for (DnsItem dns : DnsList) {
      if (dns.getDnsItemMachine().getDomaine().equals(nomdomainelocal)) {
        System.out.println(
            dns.getDnsItemAdresse().getAdresse()
                + " "
                + dns.getDnsItemMachine().getMachineDomaineLocal());
        ddns.add(new DnsItem(dns.getDnsItemAdresse(), dns.getDnsItemMachine()));
      }
    }

    return ddns;
  }

  /**
   * . It adds a new item to the database
   *
   * @param adresse the IP address of the machine
   * @param nommachine the name of the machine
   */
  public void addItem(Adresseip adresse, NomMachine nommachine) throws IOException {

    DnsItem item = new DnsItem(adresse, nommachine);

    for (DnsItem dns : DnsList) {
      if (dns.getDnsItemAdresse().getAdresse().equals(item.getDnsItemAdresse().getAdresse())) {
        System.out.println("ERROR LE DNS ITEM EXISTE DEJA");
        return;
      } else if (dns.getDnsItemMachine()
          .getMachineDomaineLocal()
          .equals(item.getDnsItemMachine().getMachineDomaineLocal())) {
        System.out.println("ERROR LE DNS ITEM EXISTE DEJA");
        return;
      }
    }

    DnsList.add(new DnsItem(item.getDnsItemAdresse(), item.getDnsItemMachine()));

    File file = new File("/Users/wissemcherifi/Desktop/cprog-td3-uvsq21604782/bdd.txt");
    FileWriter fw = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fw);
    String content =
        (item.getDnsItemAdresse().getAdresse()
            + " "
            + item.getDnsItemMachine().getMachineDomaineLocal());
    bw.write("\n" + content);
    bw.close();
    System.out.println("LE DNS À BIEN ÉTÉ AJOUTÉ A LA BASE DE DONNÉE");
    return;
  }

  /**
   * . > This function returns a list of DnsItem objects
   *
   * @return A list of DnsItem objects.
   */
  public List<DnsItem> getList() {
    return Dns.DnsList;
  }

  /**
   * . It prints the content of a list of DnsItem objects
   *
   * @param list the list of DnsItem objects to be displayed
   */
  public static void parcourslist(List<DnsItem> list) {
    for (DnsItem it : list) {

      System.out.println(
          "liste item : "
              + it.getDnsItemAdresse().getAdresse()
              + " "
              + it.getDnsItemMachine().getMachineDomaineLocal()
              + "\n");
    }
  }
}
