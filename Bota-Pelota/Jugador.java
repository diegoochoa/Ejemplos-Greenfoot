import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Jugador extends Actor
{
    private boolean disparando;
    public Jugador()
    {
        disparando=false;
    }
    @Override
    public void act() 
    {
        //si presiona la flecha derecha
        if(Greenfoot.isKeyDown("right")){
            this.setLocation(this.getX()+10, this.getY());
        }
        //si presiona flecha izquierda
        if(Greenfoot.isKeyDown("left")){
            this.setLocation(this.getX()-10, this.getY());
        }
        if(Greenfoot.isKeyDown("up")){
            this.setLocation(this.getX(), this.getY()-10);
        }
        if(Greenfoot.isKeyDown("down")){
            this.setLocation(this.getX(), this.getY()+10);
        }
        
        String key = Greenfoot.getKey();
        //Greenfoot.isKeyDown("space") CON ESTE SALEN MUCHAS BALAS A LA VEZ
        if(key == "space" && !disparando){
            Disparo d = new Disparo();
            World mundo = this.getWorld();
            mundo.addObject(d,this.getX(),this.getY()-35);
            disparando=true;
        }
        
        World mundo = this.getWorld();
        List lista = mundo.getObjects(Disparo.class);
        if(lista.isEmpty()){
            disparando=false;    
        }
    }
}
