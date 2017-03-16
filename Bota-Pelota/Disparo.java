import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Disparo extends Actor 
{
    
    public void act() 
    {
        this.setLocation(this.getX(),this.getY()-5);
        if(this.getY() == 0){
            World mundo = this.getWorld();
            mundo.removeObject(this);
        }
        
        else if(this.isTouching(Pelota.class))
        {
            this.removeTouching(Pelota.class);
        }
    }    
}
