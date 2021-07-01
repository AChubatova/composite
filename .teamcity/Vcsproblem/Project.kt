package Vcsproblem

import Vcsproblem.buildTypes.*
import Vcsproblem.vcsRoots.*
import Vcsproblem.vcsRoots.Vcsproblem_HttpsGithubComAChubatovaComposite
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.versionedSettings

object Project : Project({
    id("Vcsproblem")
    parentId("_Root")
    name = "vcsproblem"

    vcsRoot(Vcsproblem_HttpsGithubComAChubatovaComposite)

    buildType(Vcsproblem_Abc)
    buildType(Vcsproblem_B)

    params {
        param("teamcity.internal.kotlinDsl.newProjects.allowUsingNonPortableDSL", "true")
    }

    features {
        feature {
            id = "PROJECT_EXT_2"
            type = "CloudImage"
            param("podTemplateMode", "simple")
            param("dockerImage", "jetbrains/teamcity-agent")
            param("profileId", "kube-1")
            param("imageDescription", "Run container: jetbrains/teamcity-agent")
            param("agent_pool_id", "-2")
            param("source-id", "jetbrains/teamcity-agent")
        }
        versionedSettings {
            id = "PROJECT_EXT_3"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = "${Vcsproblem_HttpsGithubComAChubatovaComposite.id}"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
        feature {
            id = "kube-1"
            type = "CloudProfile"
            param("secure:authToken", "")
            param("oidcClientId", "")
            param("secure:eksSecretKey", "")
            param("system.cloud.profile_id", "kube-1")
            param("description", "")
            param("enabled", "true")
            param("customPodTemplate", "")
            param("podTemplateMode", "notSelected")
            param("profileInstanceLimit", "")
            param("idpIssuerUrl", "")
            param("apiServerUrl", "172.29.26.34:8080")
            param("eksAccessId", "")
            param("eksIAMRoleArn", "")
            param("secure:oidcClientSecret", "")
            param("profileServerUrl", "")
            param("authStrategy", "unauthorized")
            param("total-work-time", "")
            param("cloud-code", "kube")
            param("terminate-after-build", "true")
            param("secure:oidcRefreshToken", "")
            param("secure:clientKeyData", "")
            param("eksClusterName", "")
            param("profileId", "kube-1")
            param("secure:clientCertData", "")
            param("secure:password", "")
            param("name", "kubes")
            param("namespace", "")
            param("next-hour", "")
            param("secure:caCertData", "")
            param("terminate-idle-time", "30")
            param("username", "")
        }
    }
})
