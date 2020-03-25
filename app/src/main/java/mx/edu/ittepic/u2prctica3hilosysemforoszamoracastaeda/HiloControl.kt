package mx.edu.ittepic.u2prctica3hilosysemforoszamoracastaeda


import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class HiloControl(p: MainActivity) : Thread() {
    var resu = 1
    var posicion = 0
    private var puntero = p

    var iniciado = false
    var pausa = false
    var p1 = false
    var p2 = false
    var p3 = false
    var p4 = false
    var c = false

    //para poder controlar la inicializacion
    private val arreglo = arrayOf(0, 0, 0, 0)
    private var length: Int = arreglo.size
    override fun run() {

        super.run()
        iniciado = true
        pausa = false
        while (iniciado) {

            if (pausa) {
                puntero.runOnUiThread { //Metodo para evitar posibles problemas al momento de estar modificar
                    puntero.ram1 = (Math.random() * (7 - 1) + 1).toInt()
                    puntero.ram2 = (Math.random() * (7 - 1) + 1).toInt()
                    when (puntero.turno) {
                        1 -> {
                            puntero.setTitle("Ronda 1")
                            puntero.Jugadores.setText("Turno del jugador 1")

                            puntero.RU1[0] = (puntero.ram1 + puntero.ram2)

                        }
                        2 -> {
                            puntero.setTitle("Ronda 1")
                            puntero.Jugadores.setText("Turno del jugador 2")
                            puntero.RU2[0] = (puntero.ram1 + puntero.ram2)
                        }
                        3 -> {
                            puntero.setTitle("Ronda 1")
                            puntero.Jugadores.setText("Turno del jugador 3")
                            puntero.RU3[0] = (puntero.ram1 + puntero.ram2)
                        }
                        4 -> {
                            puntero.setTitle("Ronda 1")
                            puntero.Jugadores.setText("Turno del jugador 4")
                            puntero.RU4[0] = (puntero.ram1 + puntero.ram2)
                        }
                        5 -> {
                            puntero.setTitle("Ronda 2")
                            puntero.Jugadores.setText("Turno del jugador 1")
                            puntero.RU1[1] = (puntero.ram1 + puntero.ram2)
                        }
                        6 -> {
                            puntero.setTitle("Ronda 2")
                            puntero.Jugadores.setText("Turno del jugador 2")
                            puntero.RU2[1] = (puntero.ram1 + puntero.ram2)
                        }
                        7 -> {
                            puntero.setTitle("Ronda 2")
                            puntero.setTitle("Ronda 2")
                            puntero.Jugadores.setText("Turno del jugador 3")
                            puntero.RU3[1] = (puntero.ram1 + puntero.ram2)
                        }
                        8 -> {
                            puntero.setTitle("Ronda 2")
                            puntero.Jugadores.setText("Turno del jugador 4")
                            puntero.RU4[1] = (puntero.ram1 + puntero.ram2)
                        }
                        9 -> {
                            puntero.setTitle("Ronda 3")
                            puntero.Jugadores.setText("Turno del jugador 1")
                            puntero.RU1[2] = (puntero.ram1 + puntero.ram2)
                        }
                        10 -> {
                            puntero.setTitle("Ronda 3")
                            puntero.Jugadores.setText("Turno del jugador 2")
                            puntero.RU2[2] = (puntero.ram1 + puntero.ram2)
                        }
                        11 -> {
                            puntero.setTitle("Ronda 3")
                            puntero.Jugadores.setText("Turno del jugador 3")
                            puntero.RU3[2] = (puntero.ram1 + puntero.ram2)
                        }
                        12 -> {
                            puntero.setTitle("Ronda 3")
                            puntero.Jugadores.setText("Turno del jugador 4")
                            puntero.RU4[2] = (puntero.ram1 + puntero.ram2)
                        }
                        13 -> {
                            puntero.setTitle("Ronda 4")
                            puntero.Jugadores.setText("Turno del jugador 1")
                            puntero.RU1[3] = (puntero.ram1 + puntero.ram2)
                        }
                        14 -> {
                            puntero.setTitle("Ronda 4")
                            puntero.Jugadores.setText("Turno del jugador 2")
                            puntero.RU2[3] = (puntero.ram1 + puntero.ram2)
                        }
                        15 -> {
                            puntero.setTitle("Ronda 4")
                            puntero.Jugadores.setText("Turno del jugador 3")
                            puntero.RU3[3] = (puntero.ram1 + puntero.ram2)
                        }
                        16 -> {
                            puntero.setTitle("Ronda 4")
                            puntero.Jugadores.setText("Turno del jugador 4" )
                            puntero.RU4[3] = (puntero.ram1 + puntero.ram2)
                        }
                    }
                    puntero.cargarDatos()
                    if (puntero.turno >= 16) {
                        puntero.cargarDatos()
                        posicion = 0
                        resu = 0
                        for (num in 1..4) {
                            if (puntero.R1[num - 1] > resu) {
                                resu = puntero.R1[num - 1]
                                posicion = num - 1
                            }

                        }
                        puntero.Mensaje("El ganador es el jugador: " + (posicion + 1))
                        pausa = false
                    }

                    //  arreglo[puntero.contador]= (Math.random() * (6 -1) + 1).toInt()
                    //   puntero.Frase.setText(arreglo[puntero.contador].toString())

                    when (puntero.ram1) {
                        1 -> {
                            puntero.imagen1.setImageResource(R.drawable.dado1)
                        }
                        2 -> {
                            puntero.imagen1.setImageResource(R.drawable.dado2)
                        }
                        3 -> {
                            puntero.imagen1.setImageResource(R.drawable.dado3)
                        }
                        4 -> {
                            puntero.imagen1.setImageResource(R.drawable.dado4)
                        }
                        5 -> {
                            puntero.imagen1.setImageResource(R.drawable.dado5)
                        }
                        6 -> {
                            puntero.imagen1.setImageResource(R.drawable.dado6)
                        }
                    }
                    when (puntero.ram2) {
                        1 -> {
                            puntero.imagen2.setImageResource(R.drawable.dado1)
                        }
                        2 -> {
                            puntero.imagen2.setImageResource(R.drawable.dado2)
                        }
                        3 -> {
                            puntero.imagen2.setImageResource(R.drawable.dado3)
                        }
                        4 -> {
                            puntero.imagen2.setImageResource(R.drawable.dado4)
                        }
                        5 -> {
                            puntero.imagen2.setImageResource(R.drawable.dado5)
                        }
                        6 -> {
                            puntero.imagen2.setImageResource(R.drawable.dado6)
                        }
                    }
                    puntero.Frase.setText(puntero.ram1.toString() + "-" + puntero.ram2.toString())
                    puntero.progreso.setText("Calculando")
                    puntero.pausar.setText("Lanzar el siguiente jugador")
                    if (c) {
                        puntero.contador++

                    }

                    if (puntero.contador >= 10) {
                        puntero.progreso.setText("Resultado")
                        reproductor()
                        puntero.contador = 0
                        c = false

                    }
                }
            }
            sleep(500)
        }

    }

    fun reproductor() {
        sleep(200)
        pausa = !pausa

    }

    fun lanzando() {
        c = true
        reproductor()
    }
}