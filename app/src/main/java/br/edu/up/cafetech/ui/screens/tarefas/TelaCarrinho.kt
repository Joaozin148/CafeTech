package br.edu.up.cafetech.ui.screens.tarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.cafetech.ui.screens.util.CafeTechTopBar
import br.edu.up.cafetech.ui.screens.util.TelaUmBottomBar

@Composable
fun TelaCarrinho(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {

    Scaffold(
        topBar = {
            CafeTechTopBar(drawerState)
        },
        content = { iPad ->
            iPad
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "CARRINHO",
                    Modifier.padding(30.dp),
                    fontSize = 40.sp
                )
            }
        },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}


