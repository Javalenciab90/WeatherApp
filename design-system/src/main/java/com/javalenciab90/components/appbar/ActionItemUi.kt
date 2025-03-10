package com.javalenciab90.components.appbar

data class ActionItemUi(
    val actionType: ActionToolbarType,
    val icon: Int
)

sealed interface ActionToolbarType {
    data object OpenFilter : ActionToolbarType
    data object RefreshList : ActionToolbarType
}
