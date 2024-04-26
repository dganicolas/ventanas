import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

@Composable
        /**
         * Función para crear y mostrar la primera ventana de la aplicación.
         *
         * @param text Texto a mostrar en la ventana.
         * @param icon Icono de la ventana.
         * @param cerrarPantallaOnCloseRequest Función que se llama cuando se solicita cerrar la ventana.
         * @param cambiarPantallaOnButtonClick Función que se llama cuando se hace clic en el botón para cambiar de ventana.
         */
fun primeraVentana(
    text: String,
    icon: BitmapPainter,
    cerrarPantallaonCloseResquest: () -> Unit,
    cambiarPantallaOnButtonClick: () -> Unit
) {
    Window(
        onCloseRequest = cerrarPantallaonCloseResquest,
        title = "primera ventana",
        icon = icon,
        resizable = false,
        state = WindowState(
            position = WindowPosition(300.dp, 400.dp),
            size = DpSize(600.dp, 400.dp)
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Gray
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                )
                Spacer(
                    modifier = Modifier.size(100.dp)
                )
                Button(onClick = cambiarPantallaOnButtonClick) {
                    Text(text)
                }
            }
        }
    }
}


@Composable
        /**
         * Función para crear y mostrar la segunda pantalla de la aplicación.
         *
         * @param text Texto a mostrar en la ventana.
         * @param icon Icono de la ventana.
         * @param cambiarVentanaOnButtonClick Función que se llama cuando se hace clic en el botón para cambiar de ventana.
         * @param cerrarPantallaOnCloseRequest Función que se llama cuando se solicita cerrar la ventana.
         */
fun segundaPantalla(
    text: String,
    icon: BitmapPainter,
    cambiarVentanaonButtonClick: () -> Unit,
    cerrarPantallaonCloseResquest: () -> Unit
) {
    Window(
        onCloseRequest = cerrarPantallaonCloseResquest,
        title = "Segunda ventana",
        icon = icon,
        resizable = false,
        state = WindowState(
            position = WindowPosition(0.dp, 0.dp),
            size = DpSize(300.dp, 400.dp)
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Gray
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                )
                Spacer(
                    modifier = Modifier.size(100.dp)
                )
                Button(onClick = cambiarVentanaonButtonClick) {
                    Text(text)
                }
            }
        }
    }
}

fun main() = application {
    val icon = BitmapPainter(useResource("troy.png", ::loadImageBitmap))
    var text by remember { mutableStateOf("esta es la primera ventana") }
    var segundaPantalla by remember { mutableStateOf(false) }
    var primerpantalla by remember { mutableStateOf(true) }
    if (!segundaPantalla) {
        primeraVentana(
            text = text,
            icon,
            cerrarPantallaonCloseResquest = { primerpantalla = false },
            cambiarPantallaOnButtonClick = {
                segundaPantalla = true
                primerpantalla = false
                text = "esta es la segunda pantalla"
            })

    } else
        segundaPantalla(
            text = text,
            icon,
            cambiarVentanaonButtonClick = {
                segundaPantalla = false
                primerpantalla = true
                text = "esta es la primera pantalla"
            },
            cerrarPantallaonCloseResquest = { segundaPantalla = false })

    if (!primerpantalla && !segundaPantalla)
        exitApplication()
}
