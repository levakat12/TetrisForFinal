
package tetrisforfinal;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GameThread extends Thread
{
    
    private GameArea ga;
    private GameForm gf;
    private int score;
    private int level = 1;
    private int scorePerLevel = 3;
    
    private int pause = 1000;
    private int speedUpPerLevel = 100;
    
    
    public GameThread(GameArea ga, GameForm gf)
    {
        this.ga = ga;
        this.gf = gf;
        
        gf.updateScore(score);
        gf.updateLevel(level);
    }
    
    @Override
    public void run()
    {   
        while(true)
        {
            ga.spawnBlock();
            while (ga.moveBlockDown())
            {
               
            
                try {


                    Thread.sleep(pause);
                } 
                catch (InterruptedException ex) {
                    return;
                }
            }
            if(ga.isBlockOutOfBounds()){
                TetrisForFinal.gameOver();
                break;
            }
            
            ga.moveBlockToBackground();
            score += ga.clearLines();
            gf.updateScore(score);
            int lvl = score / scorePerLevel + 1;
            if(lvl > level){
                level = lvl;
                gf.updateLevel(level);
                pause -= speedUpPerLevel;
            }
            
            
        }
    }
}
