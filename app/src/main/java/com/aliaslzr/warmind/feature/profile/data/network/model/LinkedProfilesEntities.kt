package com.aliaslzr.warmind.feature.profile.data.network.model

import com.google.gson.annotations.SerializedName

data class LinkedProfileResponseEntity(
    @SerializedName("Response")
    var response: ResponseEntity = ResponseEntity(),
    @SerializedName("ErrorCode")
    var errorCode: Int? = 0,
    @SerializedName("ThrottleSeconds")
    var throttleSeconds: Int? = 0,
    @SerializedName("ErrorStatus")
    var errorStatus: String? = "",
    @SerializedName("Message")
    var message: String? = "",
    @SerializedName("MessageData")
    var messageData: MessageDataEntity = MessageDataEntity()
)

data class ResponseEntity(
    @SerializedName("profiles")
    var profiles: List<ProfilesEntity> = listOf(),
    @SerializedName("bnetMembership")
    var bnetMembership: BnetMembershipEntity = BnetMembershipEntity(),
    @SerializedName("profilesWithErrors")
    var profilesWithErrors: List<String> = listOf()
)

data class ProfilesEntity(
    @SerializedName("dateLastPlayed")
    var dateLastPlayed: String? = "",
    @SerializedName("isOverridden")
    var isOverridden: Boolean? = false,
    @SerializedName("isCrossSavePrimary")
    var isCrossSavePrimary: Boolean? = false,
    @SerializedName("crossSaveOverride")
    var crossSaveOverride: Int? = 0,
    @SerializedName("applicableMembershipTypes")
    var applicableMembershipTypes: ArrayList<Int> = arrayListOf(),
    @SerializedName("isPublic")
    var isPublic: Boolean? = false,
    @SerializedName("membershipType")
    var membershipType: Int? = 0,
    @SerializedName("membershipId")
    var membershipId: String? = "",
    @SerializedName("displayName")
    var displayName: String? = "",
    @SerializedName("bungieGlobalDisplayName")
    var bungieGlobalDisplayName: String? = "",
    @SerializedName("bungieGlobalDisplayNameCode")
    var bungieGlobalDisplayNameCode: Int? = 0
)

data class BnetMembershipEntity(
    @SerializedName("supplementalDisplayName")
    var supplementalDisplayName: String? = "",
    @SerializedName("iconPath")
    var iconPath: String? = "",
    @SerializedName("crossSaveOverride")
    var crossSaveOverride: Int? = 0,
    @SerializedName("isPublic")
    var isPublic: Boolean? = false,
    @SerializedName("membershipType")
    var membershipType: Int? = 0,
    @SerializedName("membershipId")
    var membershipId: String? = "",
    @SerializedName("displayName")
    var displayName: String? = "",
    @SerializedName("bungieGlobalDisplayName")
    var bungieGlobalDisplayName: String? = "",
    @SerializedName("bungieGlobalDisplayNameCode")
    var bungieGlobalDisplayNameCode: Int? = 0

)

data class MessageDataEntity(
    var dictionaryContents: String? = null,
    var dictionaryKeyType: String? = null,
)
