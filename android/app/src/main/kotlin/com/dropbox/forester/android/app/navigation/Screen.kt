package com.dropbox.forester.android.app.navigation

import com.dropbox.forester.android.app.R


private const val HOME_ROUTE = "home"
private const val ACCOUNT_ROUTE = "account"
private const val SEARCH_ROUTE = "search"
private const val NOTIFICATION_ROUTE = "notification"
private const val ACTIVITY_ROUTE = "activity"

private const val HOME = "HOME"
private const val ACCOUNT = "ACCOUNT"
private const val SEARCH = "SEARCH"
private const val NOTIFICATION = "NOTIFICATION"
private const val ACTIVITY = "ACTIVITY"

sealed class Screen(
    val route: String,
    val title: String,
    val iconSelected: Int,
    val iconNotSelected: Int
) {
    object Home : Screen(HOME_ROUTE, HOME, R.drawable.home_fill, R.drawable.home)
    object Account : Screen(ACCOUNT_ROUTE, ACCOUNT, R.drawable.person_fill, R.drawable.person)
    object Notification :
        Screen(NOTIFICATION_ROUTE, NOTIFICATION, R.drawable.notification_fill, R.drawable.notification)

    object Search : Screen(SEARCH_ROUTE, SEARCH, R.drawable.search, R.drawable.search)
    object Activity : Screen(ACTIVITY_ROUTE, ACTIVITY, R.drawable.activity_fill, R.drawable.activity)
}