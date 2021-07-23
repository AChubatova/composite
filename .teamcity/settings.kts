import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.schedule

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

    buildType(Folder3)
    buildType(Folder2)
    buildType(Folder1)
    buildType(Folder5)
    buildType(Folder4)
}

object Folder1 : BuildType({
    name = "folder1"

    vcs {
        root(DslContext.settingsRoot, "+:folder1 => folder14")

        checkoutMode = CheckoutMode.ON_SERVER
    }
})

object Folder2 : BuildType({
    name = "folder2"

    vcs {
        root(DslContext.settingsRoot, "+:folder2 => folder2")

        checkoutMode = CheckoutMode.ON_SERVER
    }

    dependencies {
        snapshot(Folder1) {
        }
    }
})

object Folder3 : BuildType({
    name = "folder3"

    vcs {
        root(DslContext.settingsRoot, "+:folder3 => folder3")

        checkoutMode = CheckoutMode.ON_SERVER
    }

    triggers {
        schedule {
            schedulingPolicy = daily {
                hour = 9
                minute = 30
            }
            triggerBuild = always()
        }
    }

    dependencies {
        snapshot(Folder2) {
        }
    }
})

object Folder4 : BuildType({
    name = "folder42"

    vcs {
        root(DslContext.settingsRoot, "+:folder4 => folder4", "+:folder2 => folder2")

        checkoutMode = CheckoutMode.ON_SERVER
    }

    triggers {
        schedule {
            schedulingPolicy = daily {
                hour = 9
                minute = 30
            }
            triggerBuild = always()
        }
    }

    dependencies {
        snapshot(Folder3) {
        }
    }
})

object Folder5 : BuildType({
    name = "folder5"

    vcs {
        root(DslContext.settingsRoot, "+:folder5 => folder5")

        checkoutMode = CheckoutMode.ON_SERVER
    }

    triggers {
        schedule {
            schedulingPolicy = daily {
                hour = 9
                minute = 30
            }
            triggerBuild = always()
        }
    }

    dependencies {
        snapshot(Folder4) {
        }
    }
})
