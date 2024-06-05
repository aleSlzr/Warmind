package com.aliaslzr.warmind.feature.profile.ui.model

data class LinkedProfile(
    var response: Response = Response(),
    var errorCode: Int? = 0,
    var throttleSeconds: Int? = 0,
    var errorStatus: String? = "",
    var message: String? = "",
    var messageData: MessageData = MessageData()
)

data class Response(
    var profiles: List<Profiles> = listOf(),
    var bnetMembership: BnetMembership? = BnetMembership(),
    var profilesWithErrors: List<String> = listOf()
)

data class Profiles(
    var dateLastPlayed: String? = "",
    var isOverridden: Boolean? = false,
    var isCrossSavePrimary: Boolean? = false,
    var crossSaveOverride: Int? = 0,
    var applicableMembershipTypes: ArrayList<Int> = arrayListOf(),
    var isPublic: Boolean? = false,
    var membershipType: Int? = 0,
    var membershipId: String? = "",
    var displayName: String? = "",
    var bungieGlobalDisplayName: String? = "",
    var bungieGlobalDisplayNameCode: Int? = 0
)

data class BnetMembership(
    var supplementalDisplayName: String? = "",
    var iconPath: String? = "",
    var crossSaveOverride: Int? = 0,
    var isPublic: Boolean? = false,
    var membershipType: Int? = 0,
    var membershipId: String? = "",
    var displayName: String? = "",
    var bungieGlobalDisplayName: String? = "",
    var bungieGlobalDisplayNameCode: Int? = 0
)

data class MessageData(
    var dictionaryContents: String? = null,
    var dictionaryKeyType: String? = null,
)
