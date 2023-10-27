import  java.util.Scanner;
import  java.security.SecureRandom;

public class aprendizaje1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        int nivel, tipo, correcto = 0, incorrecto = 0;

        // Pida al usuario que elija el nivel de dificultad y el tipo de operación aritmética a estudiar

        System.out.print("Introduce el nivel de dificultad (1-3): ");
        nivel = input.nextInt();
        System.out.print("Introduzca el tipo de operación aritmética (1-4): ");
        tipo = input.nextInt();

         // Generar problemas aritméticos aleatorios basados en la entrada del usuario

         for (int i = 1; i <= 10; i++) {
            int num1, num2, respuesta, resultado;
            String operador = "";

            // Genere números aleatorios basados en la entrada del usuario

            if (nivel == 1) {
                num1 = random.nextInt(10);
                num2 = random.nextInt(10);
            } else if (nivel == 2) {
                num1 = random.nextInt(90) + 10;
                num2 = random.nextInt(90) + 10;
            } else {
                num1 = random.nextInt(900) + 100;
                num2 = random.nextInt(900) + 100;
            } 

            // Determinar el tipo de operación aritmética que se va a realizar en función de la entrada del usuario

            if (tipo == 1) {
                operador = "+";
                resultado = num1 + num2;
            } else if (tipo == 2) {
                operador = "-";
                resultado = num1 - num2;
            } else if (tipo == 3) {
                operador = "*";
                resultado = num1 * num2;
            } else {
                operador = "/";
                resultado = num1 / num2;
            }

            // Pida al usuario que resuelva los problemas y proporcione comentarios basados en su respuesta
            System.out.printf("Pregunta %d: ¿Qué es %d %s %d? ", i, num1, operador, num2);
            respuesta = input.nextInt();

            if (respuesta == resultado) {
                correcto++;
                System.out.println(getPositiveFeedback());
            } else {
                incorrecto++;
                System.out.println(getNegativeFeedback());
                while (respuesta != resultado) {
                    System.out.print("Por favor, inténtelo de nuevo: ");
                    respuesta = input.nextInt();
                    if (respuesta == resultado) {
                        correcto++;
                        System.out.println(getPositiveFeedback());
                    } else {
                        incorrecto++;
                        System.out.println(getNegativeFeedback());   
                    }
                }
            }
        }

        // Realice un seguimiento de la puntuación del usuario y proporcione comentarios al final del programa
        double percentage = (double) correcto / 10 * 100;
        if (percentage < 75) {
            System.out.println("Por favor, pida ayuda adicional a su instructor.");
        } else {
            System.out.println("Felicitaciones, estás listo para pasar al siguiente nivel!");
        }
        System.out.printf(". Has respondido correctamente a las preguntas %d y a las preguntas %d incorrectamente.Su puntuación es %.2f%%.\n", correcto, incorrecto, percentage);
    }

    // Proporcionar comentarios positivos al usuario
    public static String getPositiveFeedback() {
        String[] feedback = {"¡Buen trabajo!\", \"¡Excelente!\", \"¡Bien hecho!\", \"¡Seguid así!"};
        SecureRandom random = new SecureRandom();
        return feedback[random.nextInt(feedback.length)];
    }

    // Proporcionar comentarios negativos al usuario
    public static String getNegativeFeedback() {
        String[] feedback = {"No. Por favor, inténtelo de nuevo.\", \"Incorrecto. Por favor, inténtalo de nuevo.\", \"¡No te rindas!\", \"No. Sigue intentándolo."};
        SecureRandom random = new SecureRandom();
        return feedback[random.nextInt(feedback.length)];
    }
}