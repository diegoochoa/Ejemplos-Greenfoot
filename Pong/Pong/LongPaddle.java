import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LongPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LongPaddle extends Actor
{
    private int incx;
    private int incy;
    private int posx;
    private int posy;
    public LongPaddle()
    {
        incx=5;
        incy=5;
        int mx=1;
        int my=1;
        int aleatoriox = Greenfoot.getRandomNumber(10);
        int aleatorioy = Greenfoot.getRandomNumber(10);
        if(aleatoriox >5)
        {
            mx=-1;
        }
        if(aleatorioy >5)
        {
            my=-1;
           
        }
        incx = incx*mx;
        incy = incy*my;
    }
    public void act() 
    {
       //consulta las coordenadas actuales heredadas de actor 
        int posx=this.getX();
        int posy=this.getY();
      
       
        //calculamos las nuevas coordenadas
        int newx = posx + incx;
        int newy = posy + incy;
        
        //accedemos al mundo para conocer su tamaño
        World mundo = this.getWorld();
        if(newx > mundo.getWidth()){ //rebota en el lado derecho
            incx = -incx;
        }
        if(newy > mundo.getHeight()){//rebota en la parte de abajo
            incy = -incy;
        }
        if(newx<0){
            incx = -incx;
        }
        if(newy<0){
            incy = -incy;
        }
        
        if(this.isTouching(Paddle.class))
        {
            mundo.removeObject(this);
            
        }
        //cambiamos de posicion a la pelota
        this.setLocation(newx,newy);
    }    
}
