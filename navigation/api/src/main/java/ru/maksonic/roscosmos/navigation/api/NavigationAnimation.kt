/*
package ru.maksonic.roscosmos.navigation.api

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph

*/
/**
 * @Author: maksonic on 16.03.2022
 *//*

@ExperimentalAnimationApi
internal fun AnimatedContentScope<*>.defaultEnterTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): EnterTransition {
    if (initial.destination.route == Route.SplashoScreenButWithAWeirdNameNotToTriggerLint.route) {
        return fadeIn(tween(durationMillis = 0))
    }

    val initialNavGraph = initial.destination.hostNavGraph
    val targetNavGraph = target.destination.hostNavGraph
    // If we're crossing nav graphs (bottom navigation graphs), we crossfade
    if (initialNavGraph.id != targetNavGraph.id) {
        return fadeIn()
    }
    // Otherwise we're in the same nav graph, we can imply a direction
    return fadeIn() + slideIntoContainer(AnimatedContentScope.SlideDirection.Start)
}

@ExperimentalAnimationApi
internal fun AnimatedContentScope<*>.defaultExitTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): ExitTransition {
    if (initial.destination.route == NavigationRoute.SplashoScreenButWithAWeirdNameNotToTriggerLint.route) {
        return fadeOut(tween(durationMillis = 0))
    }

    val initialNavGraph = initial.destination.hostNavGraph
    val targetNavGraph = target.destination.hostNavGraph
    // If we're crossing nav graphs (bottom navigation graphs), we crossfade
    if (initialNavGraph.id != targetNavGraph.id) {
        return fadeOut()
    }
    // Otherwise we're in the same nav graph, we can imply a direction
    return fadeOut() + slideOutOfContainer(AnimatedContentScope.SlideDirection.Start)
}

private val NavDestination.hostNavGraph: NavGraph
    get() = hierarchy.first { it is NavGraph } as NavGraph

@ExperimentalAnimationApi
internal fun AnimatedContentScope<*>.defaultPopEnterTransition(): EnterTransition =
    fadeIn() + slideIntoContainer(AnimatedContentScope.SlideDirection.End)

@ExperimentalAnimationApi
internal fun AnimatedContentScope<*>.defaultPopExitTransition(): ExitTransition =
    fadeOut() + slideOutOfContainer(AnimatedContentScope.SlideDirection.End)
*/
