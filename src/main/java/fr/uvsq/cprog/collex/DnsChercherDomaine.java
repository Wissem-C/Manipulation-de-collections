package fr.uvsq.cprog.collex;

/** . Class. */
public class DnsChercherDomaine implements Command {
  private Dns dns;
  String nomdomaine;

  /** . Constructor. */
  public DnsChercherDomaine(Dns dns, String nomdomaine) {
    this.dns = dns;
    this.nomdomaine = nomdomaine;
  }

  /** It calls the function `getItems()` of the class `DNS` with the parameter `nomdomaine`. */
  @Override
  public void execute() {
    dns.getItems(nomdomaine);
  }
}
