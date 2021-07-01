package Vcsproblem.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object Vcsproblem_B : BuildType({
    name = "b"

    vcs {
        root(Vcsproblem.vcsRoots.Vcsproblem_HttpsGithubComAChubatovaComposite)
    }

    steps {
        script {
            scriptContent = "sleep 80"
        }
    }

    requirements {
        contains("teamcity.agent.name", "jetbrains")
    }
})
