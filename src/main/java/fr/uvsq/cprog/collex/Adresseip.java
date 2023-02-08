package fr.uvsq.cprog.collex;

/** . Class. */
public class Adresseip {

  private String adr;
  private String es;
  private String se;
  private String ip;

  /** . Constructor. */
  public Adresseip(String adr, String es, String se, String ip) {
    this.es = es;
    this.adr = adr;
    this.se = se;
    this.ip = ip;
  }

  /**
   * . It returns a string that is the concatenation of the four variables adr, es, se, and ip,
   * separated by periods
   *
   * @return The IP address of the computer.
   */
  public String getAdresse() {
    return this.adr + "." + this.es + "." + this.se + "." + this.ip;
  }
}
