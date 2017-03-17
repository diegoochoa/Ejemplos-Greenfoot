import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Jugador extends Actor
{
    private boolean disparando;
    private int cont = 0;
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
        // va en el condicional Greenfoot.isKeyDown("space") CON ESTE SALEN MUCHAS BALAS A LA VEZ
        //Con esta condicional permite solo un disparo en el mundo
        /*if(key == "space" && !disparando){
            Disparo d = new Disparo();
            World mundo = this.getWorld();
            mundo.addObject(d,this.getX(),this.getY()-35);
            disparando=true;
        }*/ 
        
        //Con esta condicional permite un numero maximo de disparos, en este caso 3
        if(key == "space" && cont<5){
            Disparo d = new Disparo();
            World mundo = this.getWorld();
            mundo.addObject(d,this.getX(),this.getY()-35);
            cont++;
        }
        
        //Checa los disparos existentes en pantalla, funciona para uno o mas de uno
        World mundo = this.getWorld();
        List lista = mundo.getObjects(Disparo.class);
        if(lista.isEmpty()){
            cont=0;
            //disparando=false;    
        }
    }
}
