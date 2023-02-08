package fr.uvsq.cprog.collex;

/** . Class */
public class DnsChercherNom implements Command {
  private Dns dns;
  private NomMachine machine;

  /** . Constructor. */
  public DnsChercherNom(Dns dns, NomMachine machine) {
    this.dns = dns;
    this.machine = machine;
  }

  @Override
  // Calling the getItem method of the dns object.
  public void execute() {
    dns.getItem(machine);
  }
}
