import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

	public Persistencia() {
		
		
		
	}
	
	
	
	public void guardarDatos(String cedula, String caballo, int monto, String fecha,String resultado) throws IOException {
		
		
		File archivo=new File("bdTurf.txt");
		FileWriter escribir=new FileWriter(archivo,true);
		escribir.write(cedula+" "+ caballo+" "+ monto+" "+ fecha+" "+resultado+" ");
		
		escribir.close();

		}
	
	public String cargarDatos(String usuario) throws IOException {
		
		String cedula;
		String caballo; 
		int monto;
		String fecha;
		String resultado;
		String retorno= "";
		
		
		FileReader leer= new FileReader("bdTurf.txt");
		
		BufferedReader br= new BufferedReader(leer);
		String[] linea= br.readLine().split(" ");
	
		
		
		int i=0;
		
		while(i<linea.length) {
			
			
			cedula= linea[i];
			
			if(cedula.equals(usuario)) {
			i++;
			caballo= linea[i];
			i++;
			monto= Integer.parseInt(linea[i]);
			i++;
			fecha= linea[i];
			i++;
			resultado= linea[i];
			i++;
			
		retorno += "Id: "+"   "+cedula+"   "+ "Caballo: "+ caballo+ "   "+"Monto: "+monto+"   "+"Fecha: "+fecha+"   "+"Resultado: "+ resultado+"<br>";	
		
			}
			
			else
			i+=5;	
			}
		
		br.close();
		
		return retorno;
	}
	
	public boolean login(String usuario) throws IOException {
		
		String cedula;
		
		boolean retorno=false;
		
		FileReader leer= new FileReader("bdTurf.txt");
		
		BufferedReader br= new BufferedReader(leer);
		String[] linea= br.readLine().split(" ");
		ArrayList<String > cedulas= new ArrayList<String>();
		
		int i=0;
		while(i<linea.length) {
			
			cedula= linea[i];
			i++;
			i++;
			i++;
			i++;
			i++;
			cedulas.add(cedula);
		}
		
		br.close();
		if(cedulas.contains(usuario)) {
			
			retorno =true;
		}
		
		return retorno;
		
	}
	public static void main(String []args) {
		
		Persistencia p= new Persistencia();
		
		try {
			
		
			System.out.println(p.cargarDatos("123"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
