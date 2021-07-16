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
        param("pw2", "12")
        param("par1", "pat1value")
        param("par2", "par2value")
        password("pw3", "credentialsJSON:1cce7174-afb7-4b71-b3d2-2d834a73b86a")
        text("pwpr", "pdval0", allowEmpty = true)
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
                param("par1", "pat1value1")
            }
        }
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value2")
            }
        }
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value3")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value4")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value5")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value6")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value7")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value8")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value9")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value10")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value11")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value12")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value13")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value14")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value15")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value16")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value17")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value18")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value19")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value20")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value21")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value22")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value23")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value24")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value25")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value26")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value27")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value28")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value29")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value30")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value31")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value32")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value33")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value34")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value35")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value36")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value37")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value38")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value39")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value40")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value41")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value42")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value43")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value44")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value45")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value46")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value47")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value48")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value49")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value50")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value51")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value52")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value53")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value54")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value55")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value56")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value57")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value58")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value59")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value60")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value61")
            }
        }
        
        finishBuildTrigger {
            buildType = "${ChkprA.id}"

            buildParams {
                param("par1", "pat1value62")
            }
        }
        
    }

    dependencies {
        snapshot(ChkprA) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
})
