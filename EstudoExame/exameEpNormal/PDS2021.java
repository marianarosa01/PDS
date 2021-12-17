import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import a3.CamperServiceNotifyProxy;

// Notas:
// Não altere o código apresentado na alinea 1
// Deve completar o código das alineas 2 e 3
// Pode comentar código para garantir que vai executando parcialmente

public class PDS2021 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("pds2021.txt"));
		test(System.out); // executa e escreve na consola
		fl.println(System.getProperty("user.dir"));
		test(fl); // executa e escreve no ficheiro
		fl.close();
	}

	private static void test(PrintStream out) {
		alinea1(out);
		alinea2(out);
		alinea3(out);
	}

	private static void alinea1(PrintStream out) {
		out.println("\nAlínea 1) ----------------------------------\n");
		BasicCamperService onwheels = new BasicCamperService();

		Cliente c1 = new Cliente("Marcos Silva", "Setúbal", 32);
		Cliente c2 = new Cliente("Joana Inácio", "Viseu", 54);
		Cliente c3 = new Cliente("Carolina Marques", "Vila Real", 27);
		Cliente c4 = new Cliente("Telma Sousa", "Coimbra", 51);

		ICamper h1 = onwheels.registaCamper(4, "MotorHome com quatro lugares, 3 camas, cozinha, mesa, WC.");
		ICamper h2 = onwheels.registaCamper(4, "Camper van com quatro lugares, 2 camas, mesa.");
		ICamper h3 = onwheels.registaCamper(2, "Camper van com dois lugares, 1 cama, cozinha, mesa, WC.");
		ICamper h4 = onwheels.registaCamper(2, "Tenda de tejadilho para duas pessoas, de montagem rápida.");

		out.println("\n--- Campers disponíveis :");
		for (ICamper camper : onwheels.getCampersDisponiveis())
			out.println(camper);
		out.println("\n");

		out.println(onwheels.registaAluguer(c1, h4));
		out.println(onwheels.registaAluguer(c2, h3));

		out.println("\n--- Campers disponíveis :");
		for (ICamper camper : onwheels.getCampersDisponiveis())
			out.println(camper);
		out.println("\n");

		out.println(onwheels.terminaAluguer(c1, h4));

		out.println("\n--- Campers disponíveis :");
		for (ICamper camper : onwheels.getCampersDisponiveis())
			out.println(camper);
		out.println("\n");

	}

	private static void alinea2(PrintStream out) {
		out.println("\n\nAlínea 2 (exemplo de output) ----------------------------------\n");

		// Funciona como Adapter para os novos métodos
		CamperService broker = new CamperService(new BasicCamperService());

		Proprietario p1 = new Proprietario("António Silva", "Viseu", 32);
		Proprietario p2 = new Proprietario("Joana Sousa", "Coimbra", 54);

		Cliente c1 = new Cliente("Marcos Silva", "Setúbal", 32);
		Cliente c2 = new Cliente("Joana Inácio", "Viseu", 54);
		Cliente c3 = new Cliente("Carolina Marques", "Vila Real", 27);
		Cliente c4 = new Cliente("Telma Sousa", "Coimbra", 51);

		ICamper h1 = broker.registaCamper(p1, 4, "MotorHome com quatro lugares, 3 camas, cozinha, mesa, WC.");
		ICamper h2 = broker.registaCamper(p2, 4, "Camper van com quatro lugares, 2 camas, mesa.");
		ICamper h3 = broker.registaCamper(p1, 2, "Camper van com dois lugares, 1 cama, cozinha, mesa, WC.");
		ICamper h4 = broker.registaCamper(p2, 2, "Tenda de tejadilho para duas pessoas, de montagem rápida.");

		out.println(broker.registaPedido(c1, h4));
		out.println(broker.registaPedido(c2, h3));
		out.println(broker.registaPedido(c3, h2));

		out.println("\n--- Campers disponíveis :");
		for (ICamper camper : broker.getCampersDisponiveis())
			out.println(camper);
		out.println("\n");

		out.println(broker.aceitaPedido(c1, h4));
		out.println(broker.rejeitaPedido(c2, h3));

		out.println("\n--- Campers disponíveis :");
		for (ICamper camper : broker.getCampersDisponiveis())
			out.println(camper);
		out.println("\n");

		out.println(broker.cancelaPedido(c3, h2));

		out.println("\n--- Campers disponíveis :");
		for (ICamper camper : broker.getCampersDisponiveis())
			out.println(camper);
		out.println("\n");
	}

	private static void alinea3(PrintStream out) {
		out.println("\n\nAlínea 3) ----------------------------------\n");

		// Dá override aos métodos necessários para enviar notificações
		a3.CamperService broker = new CamperServiceNotifyProxy(new a3.BasicCamperService());

		a3.Proprietario p1 = new a3.Proprietario("António Silva", "Viseu", 32);
		a3.Proprietario p2 = new a3.Proprietario("Joana Sousa", "Coimbra", 54);

		a3.Cliente c1 = new a3.Cliente("Marcos Silva", "Setúbal", 32);
		a3.Cliente c2 = new a3.Cliente("Joana Inácio", "Viseu", 54);
		a3.Cliente c3 = new a3.Cliente("Carolina Marques", "Vila Real", 27);
		a3.Cliente c4 = new a3.Cliente("Telma Sousa", "Coimbra", 51);

		a3.ICamper h1 = broker.registaCamper(p1, 4, "MotorHome com quatro lugares, 3 camas, cozinha, mesa, WC.");
		a3.ICamper h2 = broker.registaCamper(p2, 4, "Camper van com quatro lugares, 2 camas, mesa.");
		a3.ICamper h3 = broker.registaCamper(p1, 2, "Camper van com dois lugares, 1 cama, cozinha, mesa, WC.");
		a3.ICamper h4 = broker.registaCamper(p2, 2, "Tenda de tejadilho para duas pessoas, de montagem rápida.");

		out.println(broker.registaPedido(c1, h4));
		out.println(broker.registaPedido(c2, h3));
		out.println(broker.registaPedido(c3, h2));

		out.println("\n--- Campers disponíveis :");
		for (a3.ICamper camper : broker.getCampersDisponiveis())
			out.println(camper);
		out.println("\n");

		out.println(broker.aceitaPedido(c1, h4));
		out.println(broker.rejeitaPedido(c2, h3));

		out.println("\n--- Campers disponíveis :");
		for (a3.ICamper camper : broker.getCampersDisponiveis())
			out.println(camper);
		out.println("\n");

		out.println(broker.cancelaPedido(c3, h2));

		out.println("\n--- Campers disponíveis :");
		for (a3.ICamper camper : broker.getCampersDisponiveis())
			out.println(camper);
		out.println("\n");
	}
}
