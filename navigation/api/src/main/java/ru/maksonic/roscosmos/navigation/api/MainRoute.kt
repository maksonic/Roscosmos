package ru.maksonic.roscosmos.navigation.api

/**
 * @Author: maksonic on 09.03.2022
 */
object MainRoute : Route("main") {
    object MainScreen : Route("global.main_screen")

    object NewsScreen : Route("main.news"), BottomNavRoute {
        override val selectedIcon: Int = ru.maksonic.roscosmos.shared.ui.R.drawable.ic_news_filled
        override val unselectedIcon: Int =
            ru.maksonic.roscosmos.shared.ui.R.drawable.ic_news_outlined
        override val labelId: Int = R.string.scr_title_news
    }

    object VideosScreen : Route("main.videos"), BottomNavRoute {
        override val selectedIcon: Int = ru.maksonic.roscosmos.shared.ui.R.drawable.ic_videos_filled
        override val unselectedIcon: Int =
            ru.maksonic.roscosmos.shared.ui.R.drawable.ic_videos_outlined
        override val labelId: Int = R.string.scr_title_videos
    }

    object SpaceScreen : Route("main.space"), BottomNavRoute {
        override val selectedIcon: Int = ru.maksonic.roscosmos.shared.ui.R.drawable.ic_angara_filled
        override val unselectedIcon: Int =
            ru.maksonic.roscosmos.shared.ui.R.drawable.ic_angara_outlined
        override val labelId: Int = R.string.scr_title_space
    }
}