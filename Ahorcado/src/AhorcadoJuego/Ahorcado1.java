package AhorcadoJuego;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author García, Basualdo, Giusti
 */
public class Ahorcado1 {
    JTextField jt;
    JLabel lb;
    JLabel lb2;
    private boolean play =false;
    private String[] diccionario = {"ESCALOFRIO","ORNITORRINCO","PROGRAMACION","PERIODICO","CUMPLEAÑOS","RAMILLETE","OCEANO","SILENCIO",
    "DICCIONARIO","EPISODIO","REVERENCIA","ANACONDA","DIOPTRIA","MAQUIAVELICA","CELOSO","GUARDIA","PRIMAVERA","ARMARIO","VAQUERIA",
    "NATURAL","ABOGADO","ASALTANTE","FUTBOL","TRANSFORMACION","INGENIERIA","ABURRIMIENTO","TRANSUMANTE","LIBERTAD","REVOLUCION","ESTIO",
    "ASTERISCO","ELEFANTE","BEIJING","DEPREDADOR","ECLIPSE","DEUTERONOMIO","SOSO","ESTELAR","SUPERNOVA","APROBADO","CRISTIANO","PERIODICO"};
    
    private char[] palabra_secreta;
    private char[] palabra;
    
    int intentos = 0;
    boolean cambios=false;
    
    
    public Ahorcado1(){}
    
    public Ahorcado1(JTextField texto, JLabel emo, JLabel emo2){
        System.out.println("Juego del ahorcado");
        this.palabra_secreta = Random().toCharArray();        
        String s="";
        //llena un string con "_" 
        for(int i=0;i<=this.palabra_secreta.length-1;i++){
          s = s + "_";
          System.out.print(this.palabra_secreta[i]); //no haga trampa
        }      
        //convierte este en un array
        this.palabra = s.toCharArray();        
        
        this.jt=texto;
        this.lb= emo;
        this.lb2= emo2;
        
        jt.setText(s);
        lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/emo0.jpg"))); 
        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ahorcado_0.jpg"))); 
        this.play=true;
    }

    /**
     * evalua el juego de acuerdo a los caracteres que se le pase
     * @param word
     */
    public void evaluar(char word){
    	if(play){
        String p="";
        //controla que aun se pueda jugar
        if(this.intentos==6){
           JOptionPane.showMessageDialog(null,"HAS PERDIDO, LO SIENTO");
        }  
        else{     
           //evalua caracter por caracter
           for(int j=0;j<=this.palabra_secreta.length-1;j++){
             //si el caracter se encuentra en la palabra secreta            
             if(this.palabra_secreta[j]==word){                
                this.palabra[j]= word;//se asigna para que se pueda ver en pantalla
                this.cambios=true;
             }          
             p = p + this.palabra[j];
           }//for
           //si no se produjo ningun cambio, quiere decir que el jugador se equivoco
           if(this.cambios==false){
             this.intentos+=1; //se incrementa            
             lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/emo"+this.intentos+".jpg"))); 
             lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ahorcado_"+this.intentos+".jpg")));              
             if(this.intentos<6){
                JOptionPane.showMessageDialog(null,"Sigue intentandolo,\nte quedan " + (6-this.intentos) + " intentos más");
             }             
           }else{
               this.cambios=false;               
           }
           this.jt.setText(p);
           //comprobamos el estado del juego
           gano();           
         }        
       }
    }
    
    private void gano(){
        boolean win=false;
        for(int i=0;i<=this.palabra_secreta.length-1;i++){
            if(this.palabra[i]==this.palabra_secreta[i]){            
                win=true;
            }else{
                win=false;
                break;
            }
        }
        if(win){             
             JOptionPane.showMessageDialog(null,"ENHORABUENA\nHAS ESCAPADO DE LA HORCA!!");
             lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/win.jpg"))); 
        }       
    }
    
    private String Random(){   
    int num = (int)(Math.random()*(diccionario.length));   
    return diccionario[num];
    }
}
