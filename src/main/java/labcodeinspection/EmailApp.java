package labcodeinspection;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Aplicación principal para probar la clase Email.
 */
public final class EmailApp {

    /** Logger para la aplicación */
    private static final Logger LOGGER = Logger.getLogger(EmailApp.class.getName());

    // Constructor privado para evitar instanciación (clase de utilidad)
    private EmailApp() { }

    /**
     * Método principal de la aplicación.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Enter first name: ");
            }
            final String firstName = scanner.nextLine();

            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Enter last name: ");
            }
            final String lastName = scanner.nextLine();

            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\nEnter department code:");
            }
            final int depChoice = scanner.nextInt();

            final Email email = new Email(firstName, lastName);
            email.setDepartment(depChoice);
            email.generateEmail();

            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, "\nFIRST NAME= {0}\nLAST NAME= {1}", new Object[]{firstName, lastName});
            }
        }
    }
}
