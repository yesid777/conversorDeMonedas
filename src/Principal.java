import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        String mensaje = """
            ********************************************
            *  Bienvenido al Conversor de monedas YDH  *
            ********************************************
            **      Ten en cuenta lo siguente:        **
            ********************************************
            || CODIGO   ||          MONEDA            ||
            --------------------------------------------
            ||   USD    ||  United States Dollar      ||
            ||   EUR    || 	Euro                      ||
            ||   COP    || 	Colombian Peso            ||
            ||   BRL    ||  Brazilian Real            ||
            ||   CNY    ||  Chinese Renminbi          ||
            ||   JPY    || 	Japanese Yen              ||
            ||   ARS    ||  Argentina Peso            ||
            ||   CAD    ||  Canadian Dollar           ||
            ********************************************
            ********************************************
            """;

        //Crea un formato para imprimir solo 2 decimas despues del double
        DecimalFormat frmt = new DecimalFormat("#.##");
        DecimalFormat frmt4 = new DecimalFormat("#.####");


        while (true){
            System.out.println(mensaje);

            //CREAMOS UN OBJETO DE TIPO Conversor con el nombre de consulta
            Conversor consulta = new Conversor();

            try{
                System.out.println("Escribe la moneda que quieres convertir: ");
                var moneda1 = lectura.nextLine();


                System.out.println("Escribe la cantidad de " + moneda1 + " a convertir: ");
                var cantidad =  Double.parseDouble(lectura.nextLine());


                System.out.println("Escribe la moneda a que quieres convertir los " + moneda1 + ":");
                var moneda2 = lectura.nextLine();


                //CREAMOS UN OBJETO DE TIPO Moneda Y ASIGNAMOS EL RESULTADO DEL METODO convertirA
                System.out.println("*************************************************");
                Moneda moneda = consulta.convertirA(moneda1, moneda2);
                System.out.println("La moneda " + moneda1 + " cotiza hoy en: $" + frmt4.format(moneda.conversion_rate()) +" " + moneda2);

                double operacion = moneda.conversion_rate() * cantidad;

                System.out.println("Tus "+cantidad + " " + moneda1 +" Equivalen hoy a $" + frmt.format(operacion) + " "+ moneda2);

            }catch (NumberFormatException e){
                System.out.println("Numero no encontrado " + e.getMessage());

            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Vuelve a intentarlo..");
            }
            System.out.println("*************************************************");
            System.out.println("¿Desea continuar? (S/N): ");
            var continuar = lectura.nextLine();
            System.out.println(continuar);

            if (continuar.equals("n") ||continuar.equals("N") ) {
                System.out.println("*************************************************");
                System.out.println("Gracias por utilizar nuestro Conversor !!!");
                System.out.println("*************************************************");
                break;
            }

        }



    }
}
