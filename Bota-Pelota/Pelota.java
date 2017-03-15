import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pelota extends Actor
{
    private int incx;
    private int incy;
    
    public Pelota()
    {
        incx=10;
        incy=10;
    }
    
    @Override
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
        //cambiamos de posicion a la pelota
        this.setLocation(newx,newy);
    }    
}

