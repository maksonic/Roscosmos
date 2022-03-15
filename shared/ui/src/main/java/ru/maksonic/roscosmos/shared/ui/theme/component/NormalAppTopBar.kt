package ru.maksonic.roscosmos.shared.ui.theme.component

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.maksonic.roscosmos.shared.ui.R
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme

/**
 * @Author: maksonic on 10.03.2022
 */
@Composable
fun NormalAppTopBar(
    title: String,
    action: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = RCTheme.typography.toolbarTitle,
                color = RCTheme.color.primaryText
            )
        },
        backgroundColor = RCTheme.color.background,
        elevation = 1.dp,
        navigationIcon = {
            IconButtonPrimary(onClick = action) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_back),
                    contentDescription = null,
                    tint = RCTheme.color.primaryText
                )
            }
        }
    )
}