package ru.maksonic.roscosmos.screen.settings.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.maksonic.roscosmos.screen.settings.R.*
import ru.maksonic.roscosmos.screen.settings.SettingsViewModel
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme

/**
 * @Author: maksonic on 17.03.2022
 */
@Composable
fun FontSizeWidget(
    modifier: Modifier = Modifier,
    state: Boolean,
    viewModel: SettingsViewModel,
    scope: CoroutineScope
) {

    AnimatedVisibility(
        visible = state,
        enter = expandVertically { 333 },
        exit = shrinkVertically(
            animationSpec = tween(333),
            shrinkTowards = Alignment.Top,
        )
    ) {
        Column(
            modifier
                .wrapContentHeight()
                .padding(
                    top = RCTheme.shape.padding8,
                    bottom = RCTheme.shape.padding8,
                    start = RCTheme.shape.padding16,
                    end = RCTheme.shape.padding16
                )
        ) {
            Row(
                modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Slider(
                    modifier = modifier.weight(1f),
                    value = viewModel.scalableTextSize.value,
                    valueRange = 12f..36f,
                    steps = 16,
                    onValueChange = {
                        viewModel.scalableTextSize.value = it

                        scope.launch {
                            viewModel.save(it)
                        }
                    },
                    colors = SliderDefaults.colors(
                        thumbColor = RCTheme.color.primary,
                        activeTrackColor = RCTheme.color.primary,
                        inactiveTrackColor = RCTheme.color.divider,
                        activeTickColor = RCTheme.color.primary,
                        inactiveTickColor = RCTheme.color.divider
                    )
                )
                Box(modifier = Modifier.size(32.dp), contentAlignment = Alignment.Center) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = RCTheme.shape.padding8
                            ),
                        text = viewModel.scalableTextSize.value.toInt().toString(),
                        style = RCTheme.typography.title,
                        color = RCTheme.color.primaryText
                    )
                }
            }
            Text(
                text = stringResource(id = string.txt_scalable_hint),
                fontSize = viewModel.scalableTextSize.value.sp,
                color = RCTheme.color.primaryText
            )
            Row(horizontalArrangement = Arrangement.End, modifier = modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = string.txt_scalable_hint_c),
                    fontSize = viewModel.scalableTextSize.value.sp,
                    color = RCTheme.color.primaryText,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}