import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.
VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.
To debug settings scripts in command-line, run the
    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate
command and attach your debugger to the port 8000.
To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.1"

project {


    buildType(B)

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
}



object B : BuildType({
    name = "b"

    steps {
        script {
            scriptContent = "sleep 60"
        }
    }
})
