package fr.uvsq.cprog.collex;

/** . The class NomMachine has three private attributes: nomMachine, domaine, and local. */
public class NomMachine {

  private String nomMachine;
  private String domaine;
  private String local;

  /** . Constructor. */
  public NomMachine(String nomMachine, String domaine, String local) {
    this.nomMachine = nomMachine;
    this.domaine = domaine;
    this.local = local;
  }

  /**
   * . This function returns the name of the machine
   *
   * @return The name of the machine.
   */
  public String getNomMachine() {
    return this.nomMachine;
  }

  /**
   * . This function returns the domain name of the email address.
   *
   * @return The domain name.
   */
  public String getDomaine() {
    return this.domaine + "." + this.local;
  }

  /**
   * . This function returns the local variable
   *
   * @return The local variable.
   */
  public String getLocal() {
    return this.local;
  }

  /**
   * . It returns the name of the machine, the domain and the local
   *
   * @return The name of the machine, the domain, and the local.
   */
  public String getMachineDomaineLocal() {
    return this.nomMachine + "." + this.domaine + "." + this.local;
  }

  /**
   * . > This function sets the name of the machine
   *
   * @param nom The name of the machine
   */
  public void setNomMachine(String nom) {
    this.nomMachine = nom;
  }

  /**
   * . This function sets the value of the attribute domaine of the object to the value of the
   * parameter domaine
   *
   * @param domaine The domain name of the website you want to crawl.
   */
  public void setDomaine(String domaine) {
    this.domaine = domaine;
  }

  /**
   * . This function sets the local variable to the value of the local parameter.
   *
   * @param local The local path to the file you want to upload.
   */
  public void setLocal(String local) {
    this.local = local;
  }
}
