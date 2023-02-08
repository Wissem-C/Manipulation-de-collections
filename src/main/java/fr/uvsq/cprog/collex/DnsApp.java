package fr.uvsq.cprog.collex;

import java.util.Scanner;

/**
 * . . class DnsApp.
 *
 * @return.
 */
public class DnsApp {

  /**
   * . Constructor.
   *
   * @return.
   */
  public static void main(String[] args) throws Exception {
    // System.out.println(machine.getDnsNomMachine());
    // System.out.println(item.getDnsItem());
    // System.out.println(item).getDnsItemAdresse());
    // System.out.println(item.getDnsItemMachine());
    Dns dns = new Dns("/Users/wissemcherifi/Desktop/cprog-td3-uvsq21604782/bdd.txt");
    // Dns.ParcoursList(dns.getList());
    // System.out.println(dns.getList().size());
    // dns.getItem(adresse2);
    // dns.getItem(machine2);
    // dns.getItems("google.fr");
    // 3dns.addItem(adresse2, machine2);
    // DnsTUI dnsT = new DnsTUI(dns);
    // Scanner scan = new Scanner(System.in);
    // Command com = dnsT.nextCommande(scan.nextLine());
    // dnsT.affiche(com);
    // scan.close();
    run(dns);
    // dns.sort("ls -a", dns.getList(), "uvsq.fr");
  }

  /**
   * . . It displays a menu and returns the user's choice.
   *
   * @return The menu is being returned.
   */
  public static int menu() {

    System.out.println("\nMENU : Tapez le chiffre de votre choix parmis : \n");
    System.out.println("1 : Recherche par adresse ip");
    System.out.println("2 : Recherche par nom");
    System.out.println("3 : Ajout d'un item");
    System.out.println("4 : Afficher la liste des machines d'un domaine non triée");
    System.out.println("5 : Afficher la liste des machines d'un domaine triée par machine");
    System.out.println("6 : Afficher la liste des machines d'un domaine triée par adresse ip");
    System.out.println("7 : Quitter");
    int selection = 0;
    Scanner sc = new Scanner(System.in);
    selection = sc.nextInt();
    return selection;
  }

  /**
   * . . It's a menu that allows the user to choose between the different commands that can be used
   * in the program.
   *
   * @param dns The Dns object that will be used to execute the commands.
   */
  public static void run(Dns dns) {
    Dnstui dnsT = new Dnstui(dns);
    int selection = menu();
    do {
      switch (selection) {
        case 1:
          System.out.println("Tapez [AdresseIP] [Votre adresse]\n");
          Scanner scan = new Scanner(System.in);
          Command com = dnsT.nextCommande(scan.nextLine());
          dnsT.affiche(com);
          selection = menu();
          break;
        case 2:
          System.out.println("Tapez [NomMachine][Votre nom.machine.domaine.local]");
          Scanner scan2 = new Scanner(System.in);
          Command com2 = dnsT.nextCommande(scan2.nextLine());
          dnsT.affiche(com2);
          selection = menu();
          break;
        case 3:
          System.out.println("Tapez [Votre adresse ip] [Votre nom.machine.domaine.local]");
          Scanner scan3 = new Scanner(System.in);
          Command com3 = dnsT.nextCommande(scan3.nextLine());
          dnsT.affiche(com3);
          selection = menu();
          break;
        case 4:
          System.out.println("Tapez [Rechercher7] [Votre domaine.local]");
          Scanner scan4 = new Scanner(System.in);
          Command com4 = dnsT.nextCommande(scan4.nextLine());
          dnsT.affiche(com4);
          selection = menu();
          break;
        case 5:
          System.out.println("Tapez [ls] [Votre nom de domaine]");
          Scanner scan5 = new Scanner(System.in);
          Command com5 = dnsT.nextCommande(scan5.nextLine());
          dnsT.affiche(com5);
          selection = menu();
          break;
        case 6:
          System.out.println("Tapez [ls-a] [Votre nom de domaine]");
          Scanner scan6 = new Scanner(System.in);
          Command com6 = dnsT.nextCommande(scan6.nextLine());
          dnsT.affiche(com6);
          selection = menu();
          break;
        case 7:
          System.out.println("Tapez [Quitter] pour terminer le programme");
          break;
        default:
      }
    } while (selection != 7);
  }
}
