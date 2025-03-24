
package tetrisforfinal;

import javax.swing.JOptionPane;


public class TetrisForFinal {

    
    private static GameForm gf;
    private static Main_Menu_Form mm;
    
    public static void start(){
        gf.setVisible(true);
        mm.setVisible(false);
        gf.StartGame();
    }
    
    public static void showMenu(){
        mm.setVisible(true);
    }
    
    public static void gameOver(){
        var Yes = JOptionPane.showConfirmDialog(mm, "Game Over\nDo you like the game?");
            if (Yes == 0) {
              JOptionPane.showMessageDialog(mm, "Thank you!");
              gf.setVisible(false);
              mm.setVisible(true);
            }
            if (Yes == 1) { 
              JOptionPane.showMessageDialog(mm, "Good Day, SIR!");
              System.exit(0);
            }
            if (Yes == 2) { 
              JOptionPane.showMessageDialog(mm, "I don't know why this option even exists.");
              gf.setVisible(false);
              mm.setVisible(true);
            }
        
    }
    
    public static void main(String[] args) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               gf = new GameForm();
               mm = new Main_Menu_Form();

               mm.setVisible(true);
            }
        });
        
       
    }
 }


