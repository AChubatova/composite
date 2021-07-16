import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.finishBuildTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

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

    buildType(ChkprA)
    buildType(ChkprB)
    buildType(CheckparC)
}

object CheckparC : BuildType({
    name = "checkparC"

    vcs {
        root(DslContext.settingsRoot)
    }
})

object ChkprA : BuildType({
    name = "chkprA"

    params {
        param("rtprjpar", "10000")
        param("deppar", "depparvalue")
    }

    vcs {
        root(DslContext.settingsRoot)
    }
})

object ChkprB : BuildType({
    name = "chkprB"

    params {
        param("par1", "pat1value")
        param("par2", "par2value")
        password("pwpr", "credentialsJSON:8de75e28-b0ec-49ac-af42-fa633d1d6305")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        finishBuildTrigger {
            enabled = false
            buildType = "${ChkprA.id}"

            buildParams {
                param("reverse.dep.Chkpr_CheckparC.rtprjpar", "mynewvalurfromtrigger1")
            }
        }
        finishBuildTrigger {
            enabled = false
            buildType = "${ChkprA.id}"

            buildParams {
                param("reverse.dep.Chkpr_CheckparC.rtprjpar", "mynewvalurfromtrigger2")
            }
        }
        vcs {
            enabled = false
            branchFilter = ""

            buildParams {
                param("reverse.dep.Chkpr_CheckparC.rtprjpar", "mynewvaluefromVCStrigger")
                param("short", "")
            }
        }
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                password("pwpr", "credentialsJSON:0f844515-5548-4c90-90e3-5b540a02ae56")
            }
        }
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                password("pwpr", "credentialsJSON:a72f69d0-8928-48c0-bc12-5d1355b153de")
            }
        }
    }

    dependencies {
        snapshot(CheckparC) {
        }
        snapshot(ChkprA) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
})
