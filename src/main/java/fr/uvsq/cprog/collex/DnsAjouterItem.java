package fr.uvsq.cprog.collex;

import java.io.IOException;

/** . Class. */
public class DnsAjouterItem implements Command {
  private Dns dns;
  private Adresseip adresse;
  private NomMachine nommachine;

  /** . Constructor. */
  public DnsAjouterItem(Adresseip adresse, NomMachine nommachine, Dns dns) {
    this.adresse = adresse;
    this.nommachine = nommachine;
    this.dns = dns;
  }

  /** . It adds an item to the dns */
  @Override
  public void execute() {
    try {
      dns.addItem(adresse, nommachine);
    } catch (IOException e) {

      e.printStackTrace();
    }
  }
}
