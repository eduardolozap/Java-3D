/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3dprimer;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.ColorCube;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.BranchGroup;

/**
 *
 * @author Dr.Eduardo Eloy
 */
public class Java3DPrimer extends Applet {

    
    
    
    public Java3DPrimer(){
    
        
        //Se establecen los bordes y configuracion por defecto.
    setLayout(new BorderLayout());
    GraphicsConfiguration config=SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas3D=new Canvas3D(config);
    add("Center",canvas3D);
    
    //Creamos la representacion
    BranchGroup escena=createEsceneGraph();
    
    //Compilamos la escena para optimizar la ejecucion
    escena.compile();
    
    //Usamos SimpleUniverse para simplificar la rana de representacion
    
    SimpleUniverse simpleU=new SimpleUniverse(canvas3D);
    
    
    //Retrasamos el punto de visin para poder ver los objetos
    
    simpleU.getViewingPlatform().setNominalViewingTransform();
    
    //añadimos la rama de contenido a la raiz del arbol
    
    simpleU.addBranchGraph(escena);
    
        
    }
    
    
    
    public BranchGroup createEsceneGraph(){
        
        
        //Creamos una nueva  rama de contenido
        BranchGroup objRoot=new BranchGroup();
        //Añadimos una nueva rama un hijoo el cubo.
        
        objRoot.addChild(new ColorCube(.5));
        //a la llamada devolvemos la rama objRoot
        
        return objRoot;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Frame frame=new MainFrame(new Java3DPrimer(),256,256);
        
        
    }
    
}
