import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Escenario extends World
{
    public Escenario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,true); 
        prepare();
    }

    @Override
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            System.out.println("Click en el mundo");
            MouseInfo raton = Greenfoot.getMouseInfo();
            System.out.println("Coordenadas x = "+raton.getX() + ", y = "+raton.getY());
            Pelota p = new Pelota();
            super.addObject(p,raton.getX(),raton.getY());
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Pelota pelota = new Pelota();
        addObject(pelota,285,96);
        Pelota pelota2 = new Pelota();
        addObject(pelota2,459,128);
        Pelota pelota3 = new Pelota();
        addObject(pelota3,90,192);
        Jugador jugador = new Jugador();
        addObject(jugador,284,350);
        Pelota pelota4 = new Pelota();
        addObject(pelota4,517,218);
        Pelota pelota5 = new Pelota();
        addObject(pelota5,131,92);
    }
}
