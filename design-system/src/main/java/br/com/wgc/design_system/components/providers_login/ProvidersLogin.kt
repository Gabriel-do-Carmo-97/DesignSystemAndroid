package br.com.wgc.design_system.components.providers_login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.R

@Composable
fun ProvidersLogin(
    modifier: Modifier = Modifier,
    providers: List<LoginProviderModel> = emptyList()
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
    ) {
        items(providers.size){
            Image(
                modifier = Modifier.size(48.dp).clickable { providers[it].onClick() },
                painter = painterResource(id = providers[it].iconRes),
                contentDescription = providers[it].contentDescription,
            )
        }
    }


}

@Preview(showBackground = true, name = "Only Component")
@Composable
private fun ProvidersLoginPreview() {
    ProvidersLogin(
        providers = listOf(
            LoginProviderModel(
                iconRes = R.drawable.google,
                contentDescription = "Google",
                onClick = {}
            ),
            LoginProviderModel(
                iconRes = R.drawable.facebook,
                contentDescription = "Google",
                onClick = {}
            ),
            LoginProviderModel(
                iconRes = R.drawable.phone,
                contentDescription = "Google",
                onClick = {}
            )
        )
    )
}