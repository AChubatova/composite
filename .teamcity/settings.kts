import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.SvnVcsRoot

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

version = "2020.2"

project {

    vcsRoot(HttpsGithubComAChubatovaIntroToPytest)
    vcsRoot(Svnroot)

    buildType(Cfg)
}

object Cfg : BuildType({
    name = "cfg"

    vcs {
        root(DslContext.settingsRoot)
    }
})

object HttpsGithubComAChubatovaIntroToPytest : GitVcsRoot({
    name = "https://github.com/AChubatova/intro-to-pytest"
    url = "https://github.com/AChubatova/intro-to-pytest"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:695fd8da-8062-492e-95b0-38331a81c0f4"
    }
})

object Svnroot : SvnVcsRoot({
    name = "svnroot"
    url = "https://svn.svn"
    userName = "AChubatova"
    password = "credentialsJSON:1fcaf84b-fdf5-4bdc-a8b8-a000667ff38c"
})
