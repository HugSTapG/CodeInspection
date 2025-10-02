package labcodeinspection;

import java.util.Locale;

//Clase que representa una cuenta de correo institucional
public class Email {

    // Nombre del usuario
    private final String firstName;

    // Apellido del usuario
    private final String lastName;

    // Contraseña generada para el usuario
    private String password;

    // Departamento asignado
    private String department;

    //Longitud por defecto para la contraseña
    private static final int DEFAULT_PASSWORD_LENGTH = 8;

    //Dirección de correo electrónico generada
    private String email;

    //Constructor de Email.
    public Email(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Muestra la información del email por consola.
    public void showInfo() {
        System.out.println("\nFIRST NAME= " + firstName + "\nLAST NAME= " + lastName);
        System.out.println("DEPARTMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
    }

    // Asigna un departamento según la opción seleccionada.
    public void setDepartment(final int depChoice) {
        switch (depChoice) {
            case 1 -> this.department = "sales";
            case 2 -> this.department = "dev";
            case 3 -> this.department = "acct";
            default -> this.department = "general";
        }
    }

    //Genera una contraseña aleatoria.
    private String randomPassword(final int length) {
        final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
        final char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            final int rand = (int) (Math.random() * set.length());
            password[i] = set.charAt(rand);
        }
        return new String(password);
    }

    //Genera el correo institucional y asigna una contraseña.
    public void generateEmail() {
        this.password = this.randomPassword(DEFAULT_PASSWORD_LENGTH);
        this.email = this.firstName.toLowerCase(Locale.ROOT) 
                   + this.lastName.toLowerCase(Locale.ROOT)
                   + "@" + this.department + ".espol.edu.ec";
    }
}
