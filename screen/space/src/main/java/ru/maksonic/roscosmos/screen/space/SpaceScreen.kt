package ru.maksonic.roscosmos.screen.space

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.component.ScreenHeader

/**
 * @Author: maksonic on 09.03.2022
 */
@Composable
fun SpaceScreen(
    modifier: Modifier = Modifier,
    viewModel: SpaceScreenViewModel
) {
    val scrollState = rememberScrollState()
    Scaffold(
        backgroundColor = RCTheme.color.background
    ) {
       Column(modifier = modifier.verticalScroll(state = scrollState)) {
           ScreenHeader(title = "Космос")
           TextBody(textSize = viewModel.scalableTextSize.value.sp)
       }
    }
}


// TODO: Тестовый текст
@Composable
fun TextBody(textSize: TextUnit) {
    Text(text = "Государственная корпорация по космической деятельности «Роскосмос» (сокращённое название — Госкорпорация «Роскосмос») — российская корпорация, управляющая космической отраслью страны[4], созданная в 2015 году путём преобразования Федерального космического агентства «Роскосмос»[5]. «Роскосмос» осуществляет функции по обеспечению реализации государственной политики и правовому регулированию, оказанию государственных услуг и управлению государственным имуществом в сфере космической деятельности[⇨]. Основными направлениями деятельности корпорации являются: пилотируемая космонавтика, исследование планет, изучение Солнца, астрофизика и создание искусственных спутников Земли[⇨]. Одним из важных направлений деятельности корпорации является развитие туризма, как на земле, так и в космосе[⇨].\n" +
            "\n" +
            "«Роскосмос» берёт начало в Министерстве общего машиностроения СССР и является его правопреемником, как и Федерального космического агентства «Роскосмос», Российского космического агентства, Российского космического агентства при Правительстве Российской Федерации, Российского авиационно-космического агентства[6]. В его состав входят предприятия и научные организации, созданные ещё в советскую эпоху.[⇨]\n" +
            "\n" +
            "Офис «Роскосмоса» располагается в Москве. Центр управления полётами находится в городе Королёве. Центр подготовки космонавтов располагается в подмосковном Звёздном городке. «Роскосмосом» используются космодромы: «Байконур», «Восточный» и «Плесецк»[⇨].\n" +
            "Руководитель назначается и увольняется Президентом Российской Федерации; действующим главой корпорации является, с мая 2018 года, Дмитрий Рогозин[⇨]. ",
        fontSize = textSize, color = RCTheme.color.primaryText,
    style = RCTheme.typography.body)
}