/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package explorador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author matiasgel
 */
public final class SimpleTree extends JPanel {
    //Cambiar directorio a buscar
  String directorio =  "c:/Intel/Logs";
  JTree tree;
  DefaultMutableTreeNode root;
  public SimpleTree() {
    root = new DefaultMutableTreeNode("root", true);
    getList(root, new File(directorio));
    setLayout(new BorderLayout());
    tree = new JTree(root);
    tree.setRootVisible(false);
    add(new JScrollPane((JTree)tree),"Center");
    }

    @Override
  public Dimension getPreferredSize(){
    return new Dimension(200, 120);
    }
/*
 * Busca todos los archivos de un directorio , y los agrega al componente jtree
 * Falta filtrar por tipo de imagenes jpg
 */
  public void getList(DefaultMutableTreeNode node, File f) {
     if(f.isDirectory()) {  
         File fList[] = f.listFiles();
         for(File file:f.listFiles())
         {  
             DefaultMutableTreeNode child = new DefaultMutableTreeNode(file);
              node.add(child);
         }
     }
    }
  

}