import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Archivos_1 {
    public static void constructor()
    {
//        ejemplo1();
//        ejemplo2();
//        ejemplo3();
//        ejemplo4();
    }

    static void ejemplo1()
    {
        String ruta="C:\\\\Users\\\\efren\\\\Escritorio\\\\Java\\\\IntelliJ\\\\FicherosExternos\\\\src\\\\Archivos\\\\Archivos_1.txt";
        File archivo = new File(ruta);
        System.out.println("Legibilidad del archivo: "+ archivo.canRead());
        System.out.println("Si se puede Escribir: "+ archivo.canWrite());
//        System.out.println();archivo.createNewFile(ruta);
        System.out.println("Elimina un archivo: "+ archivo.delete());
        System.out.println("Prueba si el archivo Existe: "+ archivo.exists());
        System.out.println("Retorna el nombre del archivo: "+ archivo.getName());
        System.out.println("Devuelve la ruta absoluta del archivo "+ archivo.getAbsolutePath());
        System.out.println("Retorna el tamaño del archivo "+ archivo.length());
        System.out.println("Retorna una matriz de los archivos del directorio: "+ archivo.list());
        System.out.println("Crea un acceso directo "+ archivo.mkdir());
    }

    static void ejemplo2()
    {
//        Creacion de archivo
        try
        {
            String ruta="C:\\Users\\efren\\Escritorio\\Java\\IntelliJ\\FicherosExternos\\src\\Archivos\\Archivos_1.csv";
            File archivo = new File(ruta);
            if(archivo.createNewFile())
            {
                System.out.println("Archivo Creado: "+ archivo.getName());
                System.out.println("Ruta: "+archivo.getAbsolutePath());
            }
            else
            {
                System.out.println("El archivo ya existe!");
            }

        }catch(Exception ex)
        {
            System.out.println("Error: "+ex);
        }
    }

    static void ejemplo3()
    {
//        ESCRITURA EN ARCHIVOS
        String ruta="C:\\Users\\efren\\Escritorio\\Java\\IntelliJ\\FicherosExternos\\src\\Archivos\\Archivos_1.txt";
        try
        {
            FileWriter lapiz= new FileWriter(ruta);
            lapiz.write("Escribiendo desde java");
            System.out.println("Completado");
            lapiz.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ ex.getMessage());
        }

    }

    static void ejemplo4()
    {
//        Lectura de archivos Externnos
        try
        {
            String ruta="C:\\Users\\efren\\Escritorio\\Java\\IntelliJ\\FicherosExternos\\src\\Archivos\\Archivos_1.txt";
            File archivo= new File(ruta);

            System.out.println("Tamaño del archivo: "+ archivo.length());

            Scanner lector = new Scanner(archivo);
            while(lector.hasNextLine()){
                String info = lector.nextLine();
                System.out.println(info);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Archivo no encontrado");
        }

    }


}
