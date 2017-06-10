/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


/**
 *
 * @author Dougl
 */
public class VentanaPrincipal extends Canvas implements Runnable{
    private static final Long SerialVersion= 1L;
    private static JFrame Ventana;
    private static final int ANCHO= 800;
    private static final int ALTO= 600;
    
    private final String TITLE="The Last Of POO :v";
    private final Toolkit T1= Toolkit.getDefaultToolkit();
    private Dimension D1;
    
    private int aps;
    private int fps;
    
    private Thread HiloGraph;
    private static volatile boolean WORKING;
    
    public VentanaPrincipal(){
        Ventana= new JFrame(TITLE);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setResizable(false);
        
        D1=T1.getScreenSize();
        Ventana.setBounds((D1.width/2)-(ANCHO/2), (D1.height/2)-(ALTO/2), ANCHO, ALTO);
        
        
        
        
        Ventana.setVisible(true);
    }
    
    private void actualizar(){
        aps++;
    }
    
    private void mostrar(){
        fps++;
    }
    
    public synchronized void iniciar(){
        WORKING = true;
        HiloGraph = new Thread(this,"Graficos");
        HiloGraph.start();
    }
    public synchronized void detener(){
        WORKING = false;
        try {
            HiloGraph.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta =0;
        
        requestFocus();
        
        while(WORKING){
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            delta += tiempoTranscurrido/NS_POR_ACTUALIZACION;
            
            while(delta >=1){
                actualizar();
                delta --;
            }
            mostrar();
            if(System.nanoTime()-referenciaContador > NS_POR_SEGUNDO){
                
                Ventana.setTitle(TITLE + " || APS: " + aps + " || FPS: "+fps);
                
                aps=0;
                fps=0;
                referenciaContador= System.nanoTime();
            }
        }
    
    }
    
}
