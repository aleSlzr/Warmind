package com.aliaslzr.warmind.feature.profile.domain.mapper

import com.aliaslzr.warmind.feature.profile.data.network.model.BnetMembershipEntity
import com.aliaslzr.warmind.feature.profile.data.network.model.LinkedProfileResponseEntity
import com.aliaslzr.warmind.feature.profile.data.network.model.MessageDataEntity
import com.aliaslzr.warmind.feature.profile.data.network.model.ProfilesEntity
import com.aliaslzr.warmind.feature.profile.data.network.model.ResponseEntity
import com.aliaslzr.warmind.feature.profile.ui.model.BnetMembership
import com.aliaslzr.warmind.feature.profile.ui.model.LinkedProfile
import com.aliaslzr.warmind.feature.profile.ui.model.MessageData
import com.aliaslzr.warmind.feature.profile.ui.model.Profiles
import com.aliaslzr.warmind.feature.profile.ui.model.Response
import com.aliaslzr.warmind.utils.Mapper

class ProfileEntityMapper : Mapper<LinkedProfileResponseEntity, LinkedProfile, Unit> {
    override fun transform(
        input: LinkedProfileResponseEntity,
        additionalArg: Unit?
    ): LinkedProfile = LinkedProfile(
        response = ResponseMapper().transform(input.response),
        errorCode = input.errorCode,
        throttleSeconds = input.throttleSeconds,
        errorStatus = input.errorStatus,
        message = input.message,
        messageData = MessageDataMapper().transform(input.messageData)
    )
}

class ResponseMapper : Mapper<ResponseEntity, Response, Unit> {
    override fun transform(input: ResponseEntity, additionalArg: Unit?): Response {
        val profileList: MutableList<Profiles> = mutableListOf()

        input.profiles.forEach {
            profileList.add(ProfilesMapper().transform(it))
        }
        return Response(
            profiles = profileList,
            bnetMembership = BnetMembershipMapper().transform(input.bnetMembership),
            profilesWithErrors = input.profilesWithErrors
        )
    }

}

class BnetMembershipMapper : Mapper<BnetMembershipEntity, BnetMembership, Unit> {
    override fun transform(input: BnetMembershipEntity, additionalArg: Unit?): BnetMembership {
        return with(input) {
            BnetMembership(
                supplementalDisplayName = supplementalDisplayName,
                iconPath = iconPath,
                crossSaveOverride = crossSaveOverride,
                isPublic = isPublic,
                membershipType = membershipType,
                membershipId = membershipId,
                displayName = displayName,
                bungieGlobalDisplayName = bungieGlobalDisplayName,
                bungieGlobalDisplayNameCode = bungieGlobalDisplayNameCode
            )
        }
    }

}

class ProfilesMapper : Mapper<ProfilesEntity, Profiles, Unit> {
    override fun transform(input: ProfilesEntity, additionalArg: Unit?): Profiles {
        return with(input) {
            Profiles(
                dateLastPlayed = dateLastPlayed,
                isOverridden = isOverridden,
                isCrossSavePrimary = isCrossSavePrimary,
                crossSaveOverride = crossSaveOverride,
                applicableMembershipTypes = applicableMembershipTypes,
                isPublic = isPublic,
                membershipType = membershipType,
                membershipId = membershipId,
                displayName = displayName,
                bungieGlobalDisplayName = bungieGlobalDisplayName,
                bungieGlobalDisplayNameCode = bungieGlobalDisplayNameCode
            )
        }
    }

}

class MessageDataMapper : Mapper<MessageDataEntity, MessageData, Unit> {
    override fun transform(input: MessageDataEntity, additionalArg: Unit?): MessageData {
        return with(input) {
            MessageData(
                dictionaryContents = dictionaryContents,
                dictionaryKeyType = dictionaryKeyType
            )
        }
    }
}
