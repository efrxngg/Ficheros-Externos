import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudArchivo {
    public static void constructor()
    {
        String ruta="C:\\Users\\efren\\Escritorio\\Java\\IntelliJ\\FicherosExternos\\src\\Archivos\\Archivos_2.txt";

//        System.out.println("Archivo: "+findFile(ruta));
//        createFile(ruta);
        writeFile(ruta, "1.- Linea");
//        var lista=readFile(ruta);for(Object i: lista) {System.out.println(i);}
//        updateFile(ruta, 1, "2.- Prueba");
//        deleteFile(ruta);
    }

    private static boolean findFile(String ruta){
        boolean existencia=false;
        try{
            File archivo= new File(ruta);
            if(archivo.exists()){
             existencia=true;
            }
        }catch (Exception ex) {
            System.out.println("Error"+ ex.getMessage());
        }
        return existencia;
    }

    private static void createFile(String ruta) {
        if (findFile(ruta)){
            System.out.println("Existing File");
        }
        else{
            try{
                File archivo= new File(ruta);
                archivo.createNewFile();
                System.out.println("File created successfully");
            }
            catch (Exception ex){
                System.out.println("Error: "+ ex.getMessage());
            }
        }
    }
    private static List readFile(String ruta){
        List<String> listaDatos= new ArrayList<String>();
        if(findFile(ruta)) {
            try{
                File archivo= new File(ruta);
                Scanner lector= new Scanner(archivo);
                while(lector.hasNextLine()){
                    String linea=lector.nextLine();
                    listaDatos.add(linea);
                }

            }catch (Exception ex){
                System.out.println("Error: "+ ex);
            }
        }
        else{
            System.out.println("Path is not Found");
        }

        return listaDatos;
    }

    private static void writeFile(String ruta, String texto) {
        if(findFile(ruta)){
            var lista= readFile(ruta);
            lista.add(texto);
            String newText = "";
            try{
                FileWriter archivo= new FileWriter(ruta);
                for(int i=0; i<lista.size(); i++){
//                    System.out.println(lista.get(i));
                    newText+=lista.get(i)+"\n";
                }
                archivo.write(newText);
                archivo.close();

            }catch(Exception ex){
                System.out.println("Error: "+ex);
            }
            finally {
                System.out.println("Process Finish");
            }

        }
        else{
            System.out.println("File not Found");
        }

    }

    private static void updateFile(String ruta, int index, String txtUpdate) {
        var lista=readFile(ruta);
        String newTxt="";
        try {
            FileWriter archivo= new FileWriter(ruta);
            for(int i=0; i<lista.size(); i++){
                if(index==i){
                    lista.set(index, txtUpdate);
                }
                newTxt+=lista.get(i)+"\n";
            }

            archivo.write(newTxt);
            archivo.close();

        }
        catch(Exception ex){
            System.out.println("Error: "+ ex);
        }
        finally {
            System.out.println("Proceso Finalizado");
        }
    }

    private static void deleteFile(String ruta) {
        if(findFile(ruta)){
            File archivo= new File(ruta);
            archivo.delete();
        }
        else{
            System.out.println("Archivo no existente");
        }
    }
}
