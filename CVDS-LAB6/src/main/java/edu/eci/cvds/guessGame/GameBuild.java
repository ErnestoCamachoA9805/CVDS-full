package edu.eci.cvds.guessGame;


import java.util.ArrayList;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


@ManagedBean(name = "guessBean")
@SessionScoped
public class GameBuild {
    private int numero;
    private int valor;
    private int numeroIntentos;
    private int premio;
    private String mensaje;
    private ArrayList<Integer> valoresIntentados = new ArrayList<>();
    
    public GameBuild() {
        numero = (int) (Math.random() *10 ) + 1;
        numeroIntentos = 0;
        premio = 0;
        mensaje = "¿Listo para Jugar?";
      
    }

    public int getNumero() {
		return numero;
	}

    public void setNumero(int numero) {
		this.numero = numero;
	}

    public int getValor() {
		return valor;
	}

    public void setValor(int valor) {
		this.valor = valor;
	}

    public int getNumeroIntentos() {
		return numeroIntentos;
	}

    public void setNumeroIntentos(int numeroIntentos) {
		this.numeroIntentos = numeroIntentos;
	}

    public int getPremio() {
		return premio;
	}

    public void setPremio(int premio) {
		this.premio = premio;
	}

    public String getMensaje() {
		return mensaje;
	}

    public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

    public ArrayList<Integer> getValoresIntentados() {
		return valoresIntentados;
	}

    public void setValoresIntentados(ArrayList<Integer> valoresIntentados) {
		this.valoresIntentados = valoresIntentados;
	}

    public void guess(int intento) {
        mensaje = "No gano!";
        valor = intento;
        if (valor >= 0 && valor <=20  && !valoresIntentados.contains(valor)){
            if (valor == numero){
            	premio = 100000-(numeroIntentos*10000);
                numeroIntentos ++;
                if(premio < 0){
                    premio= 0;
                }
                mensaje = "Ganó";
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Has Adivinado el Numero de la ronda anterior!, tu puntaje fue: "," "+premio+" y con una cantidad de "+(numeroIntentos-1)+" intentos fallidos ;) El juego se Ha reiniciado ")); 
                restart();
            }else{
            	numeroIntentos ++;
                valoresIntentados.add(intento); 
            }
            
        }
        else{
            mensaje= "Escribiste un dato invalido o un elemento repetido";
        }
        
    }

    public void restart(){   
        numero = (int) (Math.random() *10 ) + 1;
        numeroIntentos = 0;
        premio= 0;
        mensaje = "¿Listo Para Jugar?";
        valoresIntentados = new ArrayList<>();
        
    }
}