package fr.uvsq.cprog.collex;

/** . Class. */
public class DnsChercherDomaineTri implements Command {
  private Dns dns;
  String nomdomaine;
  String commande;

  /** . The constructor of the class DnsChercherDomaineTri */
  public DnsChercherDomaineTri(Dns dns, String nomdomaine, String commande) {
    this.dns = dns;
    this.nomdomaine = nomdomaine;
    this.commande = commande;
  }

  /** . It sorts the list of domains by the commande given */
  @Override
  public void execute() {
    dns.sort(commande, dns.getList(), nomdomaine);
  }
}
