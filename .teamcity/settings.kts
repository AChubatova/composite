import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

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

version = "2020.1"

project {

    vcsRoot(Wer)
    vcsRoot(Ccccc)

    buildType(VerConfig)
    buildType(Kuj)
}

object Kuj : BuildType({
    name = "kuj"

    params {
        password("cc", "credentialsJSON:1ad49ae3-4731-4d39-8b8a-7a4fd8d7fc4b")
        param("a", "a")
        param("b", "b")
        password("s", "credentialsJSON:4005b82e-ce40-414c-a626-afcdb3957801")
    }

    vcs {
        root(DslContext.settingsRoot)
        root(Ccccc)
    }
})

object VerConfig : BuildType({
    name = "ver config"

    params {
        param("a", "a")
    }

    vcs {
        root(Wer)
    }

    steps {
        script {
            scriptContent = """echo "a""""
        }
    }
})

object Ccccc : GitVcsRoot({
    name = "ccccc"
    url = "https://github.com/AChubatova/errorexe"
    pushUrl = "https://github.com/AChubatova/errorexe"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:87118950-7042-4c13-8cd3-7cfb37660a92"
    }
})

object Wer : GitVcsRoot({
    name = "wer"
    url = "https://github.com/AChubatova/67580"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:87118950-7042-4c13-8cd3-7cfb37660a92"
    }
})
