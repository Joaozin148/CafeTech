package br.edu.up.cafetech.ui.screens.tarefas

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object TelaUm {
    val TELA_AFAZERES_ROUTE = "t1a"
    val TELA_ROTINA_ROUTE = "t1b"
    val TELA_NOTAS_ROUTE = "t1c"
}

@Composable
fun CardapioNavHost(drawerState: DrawerState) {

    val navCtrlBottonNav = rememberNavController()
    NavHost(
        navController = navCtrlBottonNav,
        startDestination = TelaUm.TELA_AFAZERES_ROUTE
    ) {
        composable(TelaUm.TELA_AFAZERES_ROUTE) {
            TelaAfazeres(drawerState, navCtrlBottonNav)
        }
        composable(TelaUm.TELA_ROTINA_ROUTE) {
            TelaRevisao(drawerState, navCtrlBottonNav)
        }
        composable(TelaUm.TELA_NOTAS_ROUTE) {
            TelaCarrinho(drawerState, navCtrlBottonNav)
        }
    }
}
