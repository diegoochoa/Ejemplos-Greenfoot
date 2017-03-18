import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Paddle  extends Actor
{
    private int incx;
    private int player;
    private int band=1;
    private SimpleTimer timer1 = new SimpleTimer();
    public Paddle(int auxp)
    {
        player=auxp;
        incx=20;   
        timer1.mark();
    }
    
    @Override
    public void act() 
    {
        World mundo = this.getWorld();
        if(player == 1 && Greenfoot.isKeyDown("left"))
        {
            this.setLocation(this.getX()-incx,this.getY());
        }
        
        if(player == 1 && Greenfoot.isKeyDown("right") )
        {
            this.setLocation(this.getX()+incx,this.getY());
        }
        
        if(player ==2 && Greenfoot.isKeyDown("a"))
        {
            this.setLocation(this.getX()-incx,this.getY());
        }
        
        if(player ==2 && Greenfoot.isKeyDown("s"))
        {
            this.setLocation(this.getX()+incx,this.getY());
        }
       
        if(timer1.millisElapsed()>15000 && band==1)
        {
            LongPaddle lp = new LongPaddle();
            mundo.addObject(lp,mundo.getWidth()/2,mundo.getHeight()/2);
            band=0;
        }
        
        if(this.isTouching(LongPaddle.class))
        {
            timer1.mark();
            band=1;
            if(this.getY()>mundo.getHeight()/2)
            {
               
                mundo.addObject(new Paddle(2),this.getX()+40, this.getY());
            }
            else
            {
                mundo.addObject(new Paddle(1),this.getX()+40, this.getY());
            }
            
        }
    }
    
    
    
}

