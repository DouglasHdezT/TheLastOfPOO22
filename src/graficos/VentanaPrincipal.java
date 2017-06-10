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
    
    private Thread NEPE;
    private static volatile boolean WORKING;
    
    public VentanaPrincipal(){
        Ventana= new JFrame(TITLE);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setResizable(false);
        
        D1=T1.getScreenSize();
        Ventana.setBounds((D1.width/2)-(ANCHO/2), (D1.height/2)-(ALTO/2), ANCHO, ALTO);
        
        
        
        
        Ventana.setVisible(true);
    }
    
    @Override
    public void run() {
        
    }
    
}
