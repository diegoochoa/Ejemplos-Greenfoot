import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball  extends Actor
{
    private int incx;
    private int incy;
    private int posx;
    private int posy;
    private int cont1;
    private int cont2;
    private boolean termino=false;
    private int band;
    private SimpleTimer timer = new SimpleTimer();
    public Ball(){
        incx=3;
        incy=3;
        int mx=1;
        int my=1;
        int aleatoriox = Greenfoot.getRandomNumber(10);
        int aleatorioy = Greenfoot.getRandomNumber(10);
        cont1 = 0;
        cont2 = 0;
        band=1;
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
        Greenfoot.delay(100);
        //timer.mark();
        
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
            //timer.mark();
            cont1++;
            newx=mundo.getWidth()/2;
            newy=mundo.getHeight()/2;
            this.setLocation(newx,newy);
            band=1;
            Greenfoot.delay(100);
        }
        if(newx<0 ){ //rebota en el lado izquierdo
            incx = -incx;
        }
        if(newy<0){ //rebota en la parte de arriba
            //timer.mark();
            cont2++;
            newx=mundo.getWidth()/2;
            newy=mundo.getHeight()/2;
            this.setLocation(newx,newy);
            band=1;
            Greenfoot.delay(100);
        }
        if(this.isTouching(Paddle.class))
        {
            incy = -incy;
            newy= this.getY()+incy;
        }
        mundo.showText("Player 1: "+cont1, 50,50);
        mundo.showText("Player 2: "+cont2, 50,450);
        if(cont1 == 5 || cont2 == 5)
        {
            termino=true;
            if(cont1>cont2){
                mundo.showText("Player 1 es el ganador",mundo.getWidth()/2,mundo.getHeight()/2);
            }
            else{
                mundo.showText("Player 2 es el ganador",mundo.getWidth()/2,mundo.getHeight()/2);
            }
        }
        if(termino==true){
             mundo.removeObject(this);
        }
        
        
        
        //cambiamos de posicion a la pelota
        this.setLocation(newx,newy);
        
        
    }     
}

