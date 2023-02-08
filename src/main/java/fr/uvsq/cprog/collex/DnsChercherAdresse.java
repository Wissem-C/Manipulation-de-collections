package fr.uvsq.cprog.collex;

/** . Class */
public class DnsChercherAdresse implements Command {
  private Dns dns;
  private Adresseip adresse;

  /** . Constructor. */
  public DnsChercherAdresse(Dns dns, Adresseip adresse) {
    this.dns = dns;
    this.adresse = adresse;
  }

  @Override
  // Calling the getItem method of the dns object.
  public void execute() {
    dns.getItem(adresse);
  }
}
