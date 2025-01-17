package Pokemon.Combate;

import Pokemon.Combate.Movimientos.Movimiento;
import Pokemon.Database.MySQL;
import Pokemon.Database.PokemonCRUD;
import Pokemon.Funcionalidad.Funcion;
import Pokemon.Pokemon.Pokemon;

import java.util.LinkedList;

public class Rival {

    protected String nombre;
    protected String foto;
    protected static LinkedList<Pokemon> equipo;


    /**
     *
     * @return Este método genera un rival aleatorio y lo devuelve.
     */

    public static Rival generarRival() { //Añadir fotos

        Rival rival = new Rival();

        String[] rivales = {
                "Entrenador Iniesta",
                "Entrenador Guti",
                "Entrenador Hamilton",
                "Montañero Marín",
                "Campista Puja"
        };

        int random = Funcion.random(0,4);

        String nombreRival = rivales[random];

        rival.setNombre(nombreRival);
        rival.setEquipo(equipoRival());

        return rival;

    }

    public static Pokemon pokemonRival() {

        int random = Funcion.random(0, 5);

        Pokemon pokemon = equipo.get(random);
        asignarMovimiento(pokemon);


        return pokemon;
    }

    public static void asignarMovimiento(Pokemon pokemon) {

        pokemon.setMovimiento1(PokemonCRUD.generarMovimiento());
        pokemon.setMovimiento2(PokemonCRUD.generarMovimiento());
        pokemon.setMovimiento3(PokemonCRUD.generarMovimiento());
        pokemon.setMovimiento4(PokemonCRUD.generarMovimiento());

    }

    public static Movimiento cogerMovimiento(Pokemon pokemon) {

        Movimiento movimiento;

        int random = Funcion.random(1, 4);

        if(random == 1) {
            movimiento = pokemon.getMovimiento1();
        } else if (random == 2) {
            movimiento = pokemon.getMovimiento2();
        } else if (random == 3) {
            movimiento = pokemon.getMovimiento3();
        } else {
            movimiento = pokemon.getMovimiento4();
        }

        return movimiento;
    }

    public static Movimiento movimientoRandom(Pokemon pokemon) {

        pokemonRival();

        int random = Funcion.random(1, 4);

        if(random == 1) {
            return pokemon.getMovimiento1();
        } else if(random == 2) {
            return pokemon.getMovimiento2();
        } else if (random == 3) {
            return pokemon.getMovimiento3();
        } else {
            return pokemon.getMovimiento4();
        }
    }


    /**
     * Crea una LinkedList y le añade 6 pokemons aleatorios de la DB.
     * @return LinkedList con 6 pokemons
     */

    public static LinkedList<Pokemon> equipoRival() {
        LinkedList<Pokemon> equipo = new LinkedList<Pokemon>();

        for (int i = 0; i < 6; i++) {
            Pokemon pokemon = PokemonCRUD.generarPokemon();
            equipo.add(pokemon);
        }

        return equipo;
    }

    public Rival(String nombre, String foto, LinkedList<Pokemon> equipo) {
        this.nombre = nombre;
        this.foto = foto;
        this.equipo = equipo;
    }

    public Rival() {
        this.nombre = "";
        this.foto = "";
        this.equipo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public LinkedList<Pokemon> getEquipo() {
        return equipo;
    }

    public void setEquipo(LinkedList<Pokemon> equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Equipo: " + equipo;
    }

    public static void main(String[] args) {

        pokemonRival();


    }
}


