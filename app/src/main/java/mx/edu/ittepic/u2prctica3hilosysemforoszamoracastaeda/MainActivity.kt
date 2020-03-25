package mx.edu.ittepic.u2prctica3hilosysemforoszamoracastaeda


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var contador = 0
    var hiloControl: HiloControl? = null
    var RU1 = arrayOf(0, 0, 0, 0)
    var RU2 = arrayOf(0, 0, 0, 0)
    var RU3 = arrayOf(0, 0, 0, 0)
    var RU4 = arrayOf(0, 0, 0, 0)
    var R1 = arrayOf(0, 0, 0, 0)

    var i = 1
    var ram1 = 0
    var ram2 = 0
    var turno = 0

    //Nota nuestro hilo se creo pero no tiene asignada memoria
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hiloControl = HiloControl(this) //Asignamos memoria a nuestro objeto de HiloControl
        setTitle("BIENVENIDO")
        Jugadores.setText("...")
        iniciar.setOnClickListener { //Creamos el evento de OnClickListener de nuestro Botton inciar
            try { //Evitamos un error en ejecucion con TryCach
                if (hiloControl!!.isAlive) { //Verificamos que nuestro hilo esta vivo
                    //en el caso que nuestro hilo siga en ejecion entonces mandamos un mensaje de error y retonamos el OnClickListener
                    Mensaje("Error, hilo ya está iniciado")
                    return@setOnClickListener
                } else {

                    setTitle("ESTADO: Iniciado ")

                    hiloControl?.start() //Inicializamos nuestro hilo con la funcion Start()

                }

            } catch (e: Exception) { //En el caso que
                setTitle("ESTADO: Detenido por completo")
                Mensaje("EXCEPCION: Hilo ya fue detenido")
            }
            setTitle("Iniciando juego")
        }

        pausar.setOnClickListener {//Creamos el evento de OnClickListener de nuestro Botton pausar
            turno++
            if (hiloControl!!.isAlive) {//Verificamos que nuestro hilo iniciado

                hiloControl?.lanzando()
            } else { //DE lo contrario que el hilo no es iniciado mandamos mensaje
                Mensaje("Error, hilo no está iniciado")
            }

        }

        Reiniciar.setOnClickListener { //Creamos el evento de OnClickListener de nuestro Botton reiniciar
            limpiar()
            cargarDatos()
        }
        cargarDatos()


    }

    fun limpiar() {
        contador = 0 //inicializamos el contador en 0
        for (num in 1..4) {
            RU1[num - 1] = 0
            RU2[num - 1] = 0
            RU3[num - 1] = 0
            RU4[num - 1] = 0
            R1[num - 1] = 0
            turno = 0

        }
    }

    fun cargarDatos() {
        R1[0] = RU1[0] + RU1[1] + RU1[2] + RU1[3]
        R1[1] = RU2[0] + RU2[1] + RU2[2] + RU2[3]
        R1[2] = RU3[0] + RU3[1] + RU3[2] + RU3[3]
        R1[3] = RU4[0] + RU4[1] + RU4[2] + RU4[3]
        jugador1.setText("Jugador 1: " + ("[" + RU1[0].toString() + "] [" + RU1[1].toString() + "] [" + RU1[2].toString() + "] [" + RU1[3].toString() + "]=" + R1[0]).toString())
        jugador2.setText("Jugador 2: " + ("[" + RU2[0].toString() + "] [" + RU2[1].toString() + "] [" + RU2[2].toString() + "] [" + RU2[3].toString() + "]=" + R1[1]).toString())
        jugador3.setText("Jugador 3: " + ("[" + RU3[0].toString() + "] [" + RU3[1].toString() + "] [" + RU3[2].toString() + "] [" + RU3[3].toString() + "]=" + R1[2]).toString())
        jugador4.setText("Jugador 4: " + ("[" + RU4[0].toString() + "] [" + RU4[1].toString() + "] [" + RU4[2].toString() + "] [" + RU4[3].toString() + "]=" + R1[3]).toString())

    }


    fun Mensaje(s: String) { //Creamos una funcion para poder mandar mendajes pasandole como un parametro un String
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("ATENCION")
            .setPositiveButton("OK") { d, i -> }
            .show()
    }
}


