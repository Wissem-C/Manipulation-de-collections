package fr.uvsq.cprog.collex;

/** > The DnsTUI class is a text user interface for the Dns class. */
public class DnsItem {
  private NomMachine nomMachine;
  private Adresseip adresseip;
  /*
   * Constructor
   *
   * @param dns
   * .
   */

  // The constructor of the class DnsItem.
  public DnsItem(Adresseip adresseip, NomMachine machine) {
    this.nomMachine = machine;
    this.adresseip = adresseip;
  }

  /**
   * . It returns a string containing the IP address and the name of the machine
   *
   * @return The IP address and the name of the machine.
   */
  public String getDnsItem() {
    return this.adresseip.getAdresse() + " " + this.nomMachine.getNomMachine();
  }

  /**
   * . > This function returns the IP address of the DNS item
   *
   * @return The IP address of the DNS item.
   */
  public Adresseip getDnsItemAdresse() {
    return this.adresseip;
  }

  /**
   * . > This function returns the value of the variable `nomMachine`
   *
   * @return The name of the machine.
   */
  public NomMachine getDnsItemMachine() {
    return this.nomMachine;
  }

  /**
   * . > This function sets the IP address of the DNS item
   *
   * @param adresse the IP address of the DNS server
   */
  public void setDnsItemAdresse(Adresseip adresse) {
    this.adresseip = adresse;
  }

  /**
   * . > This function sets the machine of the DNS item
   *
   * @param machine The machine to which the DNS item belongs.
   */
  public void setDnsItemMachine(NomMachine machine) {
    this.nomMachine = machine;
  }
}
