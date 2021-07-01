package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'B'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("B")) {
    vcs {
        add(DslContext.settingsRoot.id!!)
    }

    expectSteps {
        script {
            scriptContent = "sleep 60"
        }
    }
    steps {
        update<ScriptBuildStep>(0) {
            clearConditions()
            scriptContent = "sleep 80"
        }
    }

    requirements {
        add {
            contains("teamcity.agent.name", "jetbrains")
        }
    }
}
