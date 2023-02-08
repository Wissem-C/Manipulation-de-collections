package fr.uvsq.cprog.collex;

/** . Class. */
public class DnsQuitter implements Command {
  /** . The implementation of the execute method of the Command interface. */
  @Override
  public void execute() {
    System.out.println("FIN DU PROGRAMME");
    return;
  }
}
