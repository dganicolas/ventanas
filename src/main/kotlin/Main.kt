import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

/**
 * Una aplicación que abrirá una ventana principal (MainWindow) con un texto que indique que está en la Ventana principal y un botón para abrir una segunda ventana (SecondWindow). Los dos componentes se mostrarán centrados vertical y horizontalmente, uno encima de otro con una separación entre ambos de 100 dp. El botón de la función principal debe abrir la ventana secundaria y cerrarse.

 * La segunda ventana tendrá una disposición similar, pero indicando que se encuentra en la ventana secundaria. El botón debe volver a abrir la ventana principal y cerrarse.

 * Una función main() dónde directamente no se cree ninguna ventana (Window), sino que llame a funciones composables, que dentro de ellas creen dichas ventanas.

 * La función Composable MainWindow() deberá tener los parámetros necesarios para recibir un icono (BitmapPainter), un tamaño de la ventana (WindowState), qué hacer en el onClose de la ventana y qué hacer en el click del botón.

 * La función Composable SecondWindow() deberá ser similar.

 * En la función main() está todos los estados elevados (State Hosting) y además deberá comprobar si las dos ventanas están cerradas hará un exit de la aplicación.
 * */
@Composable
@Preview
fun App() {



}
@Composable
fun primeraVentana(text: String, segundaPantalla: Boolean, cambiarPantallaOnButtonClick:()->Unit ){
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
        Button(onClick =cambiarPantallaOnButtonClick ) {
            Text(text)
        }
    }
}
@Composable
fun segundaPantalla(){

}

fun main() = application {
    var text by remember { mutableStateOf("esta es la primera ventana") }
    var segundaPantalla by remember { mutableStateOf(false) }
    if (!segundaPantalla)

    Window(onCloseRequest = ::exitApplication) {
        primeraVentana(text,segundaPantalla){
            segundaPantalla = true
            text = "esta es la segunda pantalla"
        }

    }
    else
        segundaPantalla()
        Window(onCloseRequest = ::exitApplication) {

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
                Button(onClick = {
                    segundaPantalla = false
                    text = "esta es la primera pantalla"
                }) {
                    Text(text)
                }
            }
        }
}
