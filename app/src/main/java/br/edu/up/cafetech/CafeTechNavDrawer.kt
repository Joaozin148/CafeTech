package br.edu.up.cafetech

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.up.cafetech.ui.screens.carrinho.TelaCarrinho
import br.edu.up.cafetech.ui.screens.revisao.TelaRevisao
import br.edu.up.cafetech.ui.screens.tarefas.CardapioNavHost
import kotlinx.coroutines.launch

object CafeTechRotas {
    val TELA_CARDAPIO_ROTA = "tela_um"
    val TELA_REVISAO_ROTA = "tela_dois"
    val TELA_CARRINHO_ROTA = "tela_tres"
}


@Preview(
    device = Devices.PIXEL
)
@Composable
fun CafeTechNavDrawer(){

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed)

    val navCtrlDrawer = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navCtrlDrawer, drawerState)
        },
        content = {
            NavHost(
                navController = navCtrlDrawer,
                startDestination = CafeTechRotas.TELA_CARDAPIO_ROTA)
            {
                composable(CafeTechRotas.TELA_CARDAPIO_ROTA) {
                    CardapioNavHost(drawerState)
                }
                composable(CafeTechRotas.TELA_REVISAO_ROTA) {
                    TelaRevisao(drawerState)
                }
                composable(CafeTechRotas.TELA_CARRINHO_ROTA) {
                    TelaCarrinho(drawerState)
                }
            }
        }
    )
}

@Composable
private fun DrawerContent(
    navController: NavController,
    drawerState: DrawerState
    ) {

    val coroutineScope = rememberCoroutineScope()

    val currentBack by navController.currentBackStackEntryAsState()
    val rotaAtual = currentBack?.destination?.route ?: CafeTechRotas.TELA_CARDAPIO_ROTA

    val ehRotaUm = rotaAtual == CafeTechRotas.TELA_CARDAPIO_ROTA
    val ehRotaDois = rotaAtual == CafeTechRotas.TELA_REVISAO_ROTA
    val ehRotaTres = rotaAtual == CafeTechRotas.TELA_CARRINHO_ROTA

    Column(
        modifier = Modifier
            .width(250.dp)
            .background(Color.Gray)
            .padding(20.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = getColorMenu(ehRotaUm)
            ),
            onClick = {
                navController.navigate(CafeTechRotas.TELA_CARDAPIO_ROTA)
                coroutineScope.launch {
                    drawerState.close()
                }
            }) {
            Icon(
                //imageVector = Icons.Default.Call,
                painter = painterResource(id = R.drawable.cafe),
                contentDescription = "c",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRotaUm)
            )
            Text(text = "Cardapio", fontSize = 30.sp,
                color = getColorTexto(ehRotaUm))
        }

        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = getColorMenu(ehRotaDois)
            ),
            onClick = {
                navController.navigate(CafeTechRotas.TELA_REVISAO_ROTA)
                coroutineScope.launch {
                    drawerState.close()
                }
            }) {
            Icon(
                //imageVector = Icons.Default.Call,
                painter = painterResource(id = R.drawable.cafe),
                contentDescription = "c",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRotaDois)
            )
            Text(text = "Revisão", fontSize = 30.sp,
                color = getColorTexto(ehRotaDois))
        }
        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = getColorMenu(ehRotaTres)
            ),
            onClick = {
                navController.navigate(CafeTechRotas.TELA_CARRINHO_ROTA)
                coroutineScope.launch {
                    drawerState.close()
                }
            }) {
            Icon(
                //imageVector = Icons.Default.Call,
                painter = painterResource(id = R.drawable.cafe),
                contentDescription = "c",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRotaTres)
            )
            Text(text = "Carrinho", fontSize = 30.sp,
                color = getColorTexto(ehRotaTres))
        }
    }
}

fun getColorMenu(estaSelecionada: Boolean): Color {
    if (estaSelecionada){
        return Color.White
    } else {
        return Color.Transparent
    }
}

fun getColorTexto(estaSelecionada: Boolean): Color {
    if (estaSelecionada){
        return Color.Black
    } else {
        return Color.DarkGray
    }
}
