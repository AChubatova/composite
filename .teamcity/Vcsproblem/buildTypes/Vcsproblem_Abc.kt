package Vcsproblem.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object Vcsproblem_Abc : BuildType({
    name = "abc"

    buildNumberPattern = "${Vcsproblem_B.depParamRefs.buildNumber}"

    vcs {
        root(Vcsproblem.vcsRoots.Vcsproblem_HttpsGithubComAChubatovaComposite)
    }

    steps {
        script {
            scriptContent = """
                sleep 10
                sleep 10
                sleep 10
                sleep 10
                sleep 10
                sleep 10
            """.trimIndent()
        }
    }

    dependencies {
        snapshot(Vcsproblem_B) {
        }
    }
})
