/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Dougl
 */
public class ColeccionSprites {
    private final int Ancho;
    private final int Alto;
    public final int[] Pixeles;
    
    public ColeccionSprites(final String Ruta,final int Ancho, final int Alto){
        this.Ancho = Ancho;
        this.Alto = Alto;
            
        Pixeles = new int[Ancho*Alto]; // Coleccion de pixeles de colores RGB
        BufferedImage imagen;    
        try {    
            imagen = ImageIO.read(ColeccionSprites.class.getResource(Ruta));
            imagen.getRGB(0, 0, Ancho, Alto, Pixeles, 0, Ancho);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
