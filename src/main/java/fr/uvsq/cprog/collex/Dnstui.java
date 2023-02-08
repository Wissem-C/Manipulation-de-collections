package fr.uvsq.cprog.collex;

/** > The DnsTUI class is a text user interface for the Dns class. */
public class Dnstui {
  private Dns dns;

  /*
   * Constructor.
   *
   * @param dns
   *.
   */
  public Dnstui(Dns dns) {
    this.dns = dns;
  }

  /**
   * It takes a string and returns a command.
   *
   * @param command the command to be executed
   * @return The command that the user wants to execute.
   */
  public Command nextCommande(String command) {
    String[] spCommand = command.split(" ");

    if (spCommand[0].equals("AdresseIP")) {
      String[] spAdresse = spCommand[1].split("\\.");
      return new DnsChercherAdresse(
          dns, new Adresseip(spAdresse[0], spAdresse[1], spAdresse[2], spAdresse[3]));
    } else if (spCommand[0].equals("NomMachine")) {
      String[] spNom = spCommand[1].split("\\.");
      return new DnsChercherNom(dns, new NomMachine(spNom[0], spNom[1], spNom[2]));
    } else if (spCommand[0].equals("AjouterDns")) {
      String[] spAdresseipp = spCommand[1].split("\\.");
      String[] spNomMachine = spCommand[2].split("\\.");
      return new DnsAjouterItem(
          new Adresseip(spAdresseipp[0], spAdresseipp[1], spAdresseipp[2], spAdresseipp[3]),
          new NomMachine(spNomMachine[0], spNomMachine[1], spNomMachine[2]),
          dns);

    } else if (spCommand[0].equals("Rechercher")) {
      return new DnsChercherDomaine(dns, spCommand[1]);
    } else if (spCommand[0].equals("ls")) {
      return new DnsChercherDomaineTri(dns, spCommand[1], spCommand[0]);
    } else if (spCommand[0].equals("ls-a")) {
      return new DnsChercherDomaineTri(dns, spCommand[1], spCommand[0]);
    } else if (spCommand[0].equals("Quitter")) {
      return new DnsQuitter();
    } else {
      return null;
    }
  }

  /**
   * The affiche function takes a Command object as a parameter and calls the execute method on it.
   *
   * @param commande the command to be executed
   */
  public void affiche(Command commande) {
    commande.execute();
  }
}
